package com.example.helloworld;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 马克
 * @date 2023/10/30
 */
public class EnglishCount {
    public static void main(String[] args) throws Exception {
        List<String> allLines = Files.readAllLines(Paths.get("/Users/mark/Desktop/note/English/count.txt"));
        Set<String> countSet = new LinkedHashSet();
        for (String line : allLines) {
            String word = line.trim();
            if (isNumeric2(word))
                continue;
            countSet.add(word);
        }

        StringBuffer sb = new StringBuffer();

    }

    public static boolean isNumeric2(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }
}
