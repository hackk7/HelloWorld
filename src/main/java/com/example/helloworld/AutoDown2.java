package com.example.helloworld;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 马克
 * @since 2023/11/30
 */
@Slf4j
public class AutoDown2 {
    public static void main(String[] args) throws Exception {
        // 请求url
        String url = "http://api.yageapp.com/api/web/share/postor.php?aid=37759&sid=1621455&bundleid=&base_uid=1480873";
        Document document = Jsoup.connect(url).get();

        // 取中文文件名
        List<String> chineseFileName = new ArrayList<>();
        Elements elements = document.getElementsByClass("qui_list__txt");
        elements.forEach(e -> chineseFileName.add(e.text()));

        List<String> numName = getNumName(document);
        Map<String, String> nameToUrl = getNameToUrl(document, numName);

        Map<String, String> downloadInfo = transformName(chineseFileName, numName, nameToUrl);
        for (String s : downloadInfo.keySet()) {
            File file = new File(s);
            URL fileUrl = new URL(downloadInfo.get(s));
            FileUtils.copyURLToFile(fileUrl, file);
            Thread.sleep(2000L);
            log.info("{} download done.", s);
        }
    }

    public static Map<String, String> transformName (List<String> chineseFileName, List<String> numName, Map<String, String> numNameToUrl) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < numName.size(); i++) {
            String url = numNameToUrl.get(numName.get(i));
            String suffixName = url.substring(url.lastIndexOf("."));
            String fileName = chineseFileName.get(i);
            result.put(fileName + suffixName, numNameToUrl.get(numName.get(i)));
        }
        return result;
    }

    public static List<String> getNumName (Document document) {
        // 读取js
        Element script = document.select("script").get(7);
        // 获取文件名
        String midList = extractVariableValue(script.html(), "midlist");
        JSONArray midListJson = JSONUtil.parseArray(midList);
        return midListJson.toList(String.class);
    }

    public static Map<String, String> getNameToUrl(Document document, List<String> numNameList) {
        // 读取js
        Element script = document.select("script").get(7);
        // 获取文件url
        String pathArrayStr = extractVariableValue(script.html(), "patharray");
        JSONObject jsonObject = JSONUtil.parseObj(pathArrayStr);
        Map<String, String> result = new HashMap<>();
        numNameList.forEach(e -> result.put(e, jsonObject.getJSONObject(e).getStr("playurl")));
        return result;
    }

    public static String extractVariableValue(String content, String variableName) {
        String pattern = variableName + "\\s*=\\s*(.*?);";
        Matcher matcher = Pattern.compile(pattern).matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
