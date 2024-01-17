package com.example.helloworld;

import java.util.Optional;

/**
 * @author 马克
 * @date 2023/6/14
 */
public class Demo5 {
    public static void main(String[] args) {
        String val = null;
        Optional<String> value = Optional.ofNullable(val);
        String result = value.orElse("default");
        System.out.println("result = " + result);


        Optional<String> value2 = Optional.ofNullable(val);
        String result2 = value2.orElse("default");
        System.out.println("result2 = " + result2);

    }
}
