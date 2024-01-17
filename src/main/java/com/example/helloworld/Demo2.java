package com.example.helloworld;


import cn.hutool.json.JSONArray;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author 马克
 * @date 2023/4/21
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        System.out.println(strTimeToLocalTime("9:30"));
        System.out.println(strTimeToLocalTime("12:30"));
        System.out.println(strTimeToLocalTime("09:1"));
        System.out.println(strTimeToLocalTime("23:10"));
        System.out.println(strTimeToLocalTime("23:11:23"));
    }

    public static LocalTime strTimeToLocalTime(String strTime) {
        String str = "";
        String hour = "";
        String min = "";
        String result = "";

        // 中文冒号转换 12：00 -> 12:00
        if (strTime.contains("："))
            str = strTime.replace("：", ":");
        else
            str = strTime;
        // 如果包含秒数转换 12:30:00 -> 12:30
        int i = str.indexOf(":");
        int j = str.lastIndexOf(":");
        if (i != j) {
            str = str.substring(0, j);
        }

        // 小时缺0转换
        String[] split = str.split(":");
        if (split[0].length() < 2)
            hour = String.format("%02d", new Integer(split[0]));
        else
            hour = split[0];

        // 分钟缺0转换
        if (split[1].length() < 2)
            min = String.format("%02d", new Integer(split[0]));
        else
            min = split[1];

        result = hour.concat(":").concat(min);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(result, formatter);
    }
}

//        char[] charArray = strTime.toCharArray();
//        int count = 0;
//        int index = 0;
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == '=') {
//                count += 1;
//            }
//        }
//        if (count > 1) {
//
//        }
