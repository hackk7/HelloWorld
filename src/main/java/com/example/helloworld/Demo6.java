package com.example.helloworld;

import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson2.JSON;

import lombok.Data;

/**
 * @author 马克
 * @date 2023/6/21
 */
public class Demo6 {
    public static void main(String[] args) throws Exception {
        Student stu1 = new Student("mark", 18);
        Student stu2 = new Student("bb", 18);
        Student stu3 = new Student("mark", 20);

        List<Student> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);

        Map<String, Student> result = new HashMap<>();
        stuList.forEach(e -> result.put(e.getName(), e));
        System.out.println(result);
    }
}

class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
