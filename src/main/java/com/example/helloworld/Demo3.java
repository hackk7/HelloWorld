package com.example.helloworld;

/**
 * @author 马克
 * @date 2023/6/4
 */
public class Demo3 {
    public static void main(String[] args) {
       boolean flag = false;
        System.out.println("flag = " + flag);
        flag = clear(false);
        System.out.println("flag = " + flag);

    }

    private static boolean clear(Boolean flag) {
        return true;
    }
}
