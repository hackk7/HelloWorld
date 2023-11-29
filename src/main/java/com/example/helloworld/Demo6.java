package com.example.helloworld;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson2.JSON;

import lombok.Data;

/**
 * @author 马克
 * @date 2023/6/21
 */
public class Demo6 {
    public static void main(String[] args) throws Exception {
        Student student = JSON.parseObject("{ \"name\":\"mark\" }", Student.class);
        System.out.println(student.getName());
        System.out.println(student);
    }

    @Data
    public static class Student {
        private String name;
        private List<String> toys;
    }
}
