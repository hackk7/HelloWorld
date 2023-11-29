package com.example.helloworld;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.helloworld.Demo7.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 马克
 * @date 2023/7/6
 */
public class Demo7 {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 12);
        Student student2 = new Student("张三", 11);
        Student student3 = new Student("李四", 15);

        List<Student> list = Arrays.asList(student1, student2, student3);

        Map<String,Long> countMap = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        System.out.println(countMap);




    }


    @Data
    @AllArgsConstructor
    public static class Student{
        private String name;
        private int age;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Student other = (Student) obj;
            return Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
