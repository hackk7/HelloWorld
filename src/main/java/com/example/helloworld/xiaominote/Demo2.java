package com.example.helloworld.xiaominote;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

/**
 * @author 马克
 * @since 2024/3/18
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {

        File dir = new File("/Users/mark/Downloads/k60/");
        List<File> files = new ArrayList<>();
        files.add(new File("/Users/mark/Desktop/note/妈妈真我手机笔记/k60-1.md"));
        files.add(new File("/Users/mark/Desktop/note/妈妈真我手机笔记/k60-2.md"));
        Set<String> contents = new HashSet<>();
        for (File file : files) {
            StringBuilder sb = new StringBuilder();
            try {
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    sb.append(data);
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONUtil.parseObj(sb.toString());
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray records = data.getJSONArray("entries");
            for (Object record : records) {
                JSONObject entries = JSONUtil.parseObj(record);
                String snippet = entries.getStr("snippet");
                contents.add(snippet);
            }
        }


        for (String text : contents) {
            String html = String.format(HtmlTemplate.HTML, "", text);
            String substring = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
            String filename = dir + File.separator + substring + ".html";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(html);
            writer.close();
        }
    }
}
