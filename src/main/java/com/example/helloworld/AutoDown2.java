package com.example.helloworld;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 马克
 * @since 2023/11/30
 */
@Slf4j
public class AutoDown2 {
    private static final String ROOT_DIR = "/Users/mark/Downloads/妈妈下载/";
    private static final String DOWNLOAD_URL = "http://api.yageapp.com/api/web/share/postor.php?aid=6559&sid=199819&bundleid=&base_uid=-1";
    private static final Map<String, String> NUMBER_FILENAME_TO_URL = new HashMap<>();
    private static final Map<String, String> CHINESE_FILENAME_TO_URL = new HashMap<>();

    public static void main(String[] args) throws Exception {
        List<String> urlStrings = Arrays.asList("http://api.yageapp.com/api/web/share/postor.php?aid=39179&sid=1691492&bundleid=&base_uid=1480873");

        for (String url : urlStrings) {
            Document document = Jsoup.connect(url).get();
            String title = document.title();
            // 取中文文件名
            List<String> chineseFilename = new ArrayList<>();
            Elements elements = document.getElementsByClass("qui_list__txt");
            elements.forEach(e -> chineseFilename.add(e.text()));

            // 获取数字文件名
            List<String> numName = getNumName(document);
            // 获取 fileNameToUrl
            getNameToUrl(document, numName);
            // 处理下载信息 chineseFilename to url
            transformNumberNameToChineseName(chineseFilename, numName);
            // 将要下载的文件
            List<File> targetFiles = shallCreateFile(title);
            // 下载文件
            targetFiles.forEach(e -> downloadFile(e, CHINESE_FILENAME_TO_URL));
            // 清理记录
            NUMBER_FILENAME_TO_URL.clear();
            CHINESE_FILENAME_TO_URL.clear();
            Thread.sleep(1000);
        }
    }

    @SneakyThrows
    public static void downloadFile(File file, Map<String, String> filenameToUrl) {
        if (file.exists()) {
            log.info("{} file already exist, skip and continue", file.getName());
            return;
        }
        URL fileUrl = new URL(filenameToUrl.get(file.getName()));
        FileUtils.copyURLToFile(fileUrl, file);
        Thread.sleep(2000L);
        log.info("{} download done.", file.getName());
    }

    public static List<File> shallCreateFile(String title) {
        Set<String> strings = CHINESE_FILENAME_TO_URL.keySet();
        List<File> result = new ArrayList<>();
        for (String fileName : strings) {
            File file = new File(ROOT_DIR.concat(title).concat(File.separator).concat(fileName));
            result.add(file);
        }
        return result;
    }

    public static void transformNumberNameToChineseName(List<String> chineseFileName, List<String> numName) {
        for (int i = 0; i < numName.size(); i++) {
            String url = NUMBER_FILENAME_TO_URL.get(numName.get(i));
            String suffixName = url.substring(url.lastIndexOf("."));
            String fileName = chineseFileName.get(i);
            CHINESE_FILENAME_TO_URL.put(fileName + suffixName, NUMBER_FILENAME_TO_URL.get(numName.get(i)));
        }
    }

    public static List<String> getNumName(Document document) {
        // 读取js
        Element script = document.select("script").get(7);
        // 获取文件名
        String midList = extractVariableValue(script.html(), "midlist");
        JSONArray midListJson = JSONUtil.parseArray(midList);
        return midListJson.toList(String.class);
    }

    public static void getNameToUrl(Document document, List<String> numNameList) {
        // 读取js
        Element script = document.select("script").get(7);
        // 获取文件url
        String pathArrayStr = extractVariableValue(script.html(), "patharray");
        JSONObject jsonObject = JSONUtil.parseObj(pathArrayStr);
        numNameList.forEach(e -> NUMBER_FILENAME_TO_URL.put(e, jsonObject.getJSONObject(e).getStr("playurl")));
    }

    public static String extractVariableValue(String content, String variableName) {
        String pattern = variableName + "\\s*=\\s*(.*?);";
        Matcher matcher = Pattern.compile(pattern).matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    static <T> Predicate<T> not(Predicate<T> p) {
        return o -> !p.test(o);
    }
}
