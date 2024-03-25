package com.example.helloworld.xiaominote;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author 马克
 * @since 2024/3/18
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        File dir = new File("/Users/mark/Downloads/k60/");
        try {
            File myObj = new File("/Users/mark/Desktop/note/妈妈真我手机笔记/9.md");
            Scanner myReader = new Scanner(myObj);
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
        JSONArray records = data.getJSONArray("records");
        List<Records> list = records.toList(Records.class);
        for (Records note : list) {
            String html = String.format(HtmlTemplate.HTML, note.getRawTitle(), note.getRawText());
            String substring = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
            String filename = dir + File.separator + substring + ".html";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(html);
            writer.close();
        }
    }
}
