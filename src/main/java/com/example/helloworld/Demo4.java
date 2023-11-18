package com.example.helloworld;

import java.io.File;

/**
 * @author 马克
 * @date 2023/6/11
 */
public class Demo4 {
    public static void main(String[] args) {
        File file = new File("/Users/mark/Downloads/大舅KTV");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println( i + 1 + " " + files[i].getName());
        }
    }
}
