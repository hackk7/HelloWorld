package com.example.helloworld;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 马克
 * @date 2023/6/14
 */
public class Demo5 {
    public static void main(String[] args) {

        String str = null;
        if (StringUtils.isNotBlank(str) && str.length() > 50) {
            System.out.println("Hello");
        }
    }
}
