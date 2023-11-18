package com.example.helloworld;

/**
 * @author 马克
 * @date 2023/11/4
 */
public class GenericsDemo {
    public static void main(String[] args) {
        System.out.println(add(3.3, 6));
    }

    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }
}
