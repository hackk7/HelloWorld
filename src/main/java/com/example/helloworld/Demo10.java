package com.example.helloworld;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 马克
 * @since 2024/2/28
 */
public class Demo10 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        // 求list1与list2的差集
        List<Integer> difference = list1.stream()
                .filter(num -> !list2.contains(num))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("差集为：" + difference);
    }
}
