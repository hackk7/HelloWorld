package com.example.helloworld.english;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author 马克
 * @since 2023/11/12
 */
public class ReadJsonEnglishWord {
    public static void main(String[] args) throws Exception {
        List<String> allLines = Files.readAllLines(Paths.get("/Users/mark/Downloads/GaoZhongluan_2.json"));

        int fileNameCount = 1;
        int worldCount = 0;

        File file = new File("GaoZhong_" + fileNameCount + ".md");
        FileWriter fr = new FileWriter(file, true);
        fr.write("word  | example \n");
        fr.write("------|-----\n");


        for (String allLine : allLines) {
            JSONObject entries = JSONUtil.parseObj(allLine);
            String headWord = String.valueOf(entries.get("headWord"));
            fr.write(headWord + " | \n");
            worldCount += 1;

            if (worldCount >= 153) {
                fr.close();
                worldCount = 0;
                fileNameCount += 1;
                file = new File("GaoZhong_" + fileNameCount + ".md");
                fr = new FileWriter(file, true);
                fr.write("word                                                           a | mean \n");
                fr.write("-----------------------------------------------------------------|-----\n");
            }
        }
        fr.close();
    }
}
