package com.example.helloworld;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 马克
 * @since 2024/3/4
 */
public class Demo11 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//
//        String result = String.join(",", list);
//        System.out.println(result);

//        Map<String, String> dict = new HashMap<>();
//        dict.put("SELF_GD", "国大总部");
//        dict.put("NOT_SELF_GD", "国大商家");
//        dict.put("JOIN_GD", "加盟商家");
//        dict.put("EXTERNAL_GD", "外部商家");
//
//        String joinGd = dict.get("JOIN_GD");
//        System.out.println("joinGd = " + joinGd);
//        String aaaaaa = dict.get("aaaaaa");
//        System.out.println("aaaaaa = " + aaaaaa);

//        List<String> list = Arrays.asList("One",
//                "Two",
//                "Three",
//                "Four",
//                "Five");
//        String join = StringUtils.join(list, "");
//        System.out.println("join = " + join);
        String s = date2String(new Date());
        System.out.println("s = " + s);
    }

    public static String date2String(Date date) {
        if (Objects.isNull(date))
            return null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
