package com.example.helloworld;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 马克
 * @date 2023/10/8
 */
public class Demo9 {
    public static void main(String[] args) {
        List<Foo> list = Arrays.asList(new Foo(1, "P1", 300, 400),
                new Foo(2, "P2", 600, 400),
                new Foo(3, "P3", 30, 20),
                new Foo(3, "P3", 70, 20),
                new Foo(1, "P1", 360, 40),
                new Foo(4, "P4", 320, 200),
                new Foo(4, "P4", 500, 900));

        Map<Integer, Integer> collect = list.stream().collect(Collectors.groupingBy(foo -> foo.id, Collectors.summingInt(foo -> foo.num)));
        System.out.println(collect);
    }

    static class Foo {
        private Integer id;
        private String grade;
        private Integer num;

        private Integer num2;

        public Foo(Integer id, String grade, Integer num, Integer num2) {
            this.id = id;
            this.grade = grade;
            this.num = num;
            this.num2 = num2;
        }
    }
}
