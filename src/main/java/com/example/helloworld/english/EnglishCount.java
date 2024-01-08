package com.example.helloworld.english;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author 马克
 * @date 2023/10/30
 */
public class EnglishCount {
    public static void main(String[] args) throws Exception {

        Map<String, String> result = new LinkedHashMap<>();

        for (String file : Common.files) {
            List<String> allLines = Files.readAllLines(Paths.get(file));
            allLines.remove(0);
            allLines.remove(0);

            result.put(file, "---");

            for (String line : allLines) {
                String[] split = line.split("\\|");
                String word = split[0].trim();

                Set<String> keySet = result.keySet();
                if (!keySet.contains(word)) {
                    result.put(word, split.length == 1 ? "" : split[1]);
                }
            }
        }

        Set<String> keySet = result.keySet();
        for (String keyString : keySet) {
            System.out.println(keyString + " | " + result.get(keyString));
        }
    }
}
