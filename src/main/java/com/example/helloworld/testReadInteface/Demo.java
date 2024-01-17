package com.example.helloworld.testReadInteface;

/**
 * @author 马克
 * @since 2024/1/12
 */
public class Demo {
    public static void main(String[] args) {
        String str = "aa,bb,cc,";

        System.out.println("str = " + str);

        str = str.substring(0, str.lastIndexOf(","));

        System.out.println("str = " + str);
    }
}
