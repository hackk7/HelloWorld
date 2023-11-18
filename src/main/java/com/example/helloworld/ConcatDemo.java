package com.example.helloworld;

/**
 * @author 马克
 * @date 2023/11/2
 */
public class ConcatDemo {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(str.concat("-").concat(String.valueOf(System.currentTimeMillis())));
    }
}
