package com.example.helloworld;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 马克
 * @date 2023/6/21
 */
public class Demo6 {
    public static void main(String[] args) {
        String productIds = "5366510,5304858,5304861";
        List<Integer> collect = Arrays.asList(productIds.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        System.out.println("collect = " + collect);

    }
}
