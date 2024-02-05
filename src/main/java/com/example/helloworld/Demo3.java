package com.example.helloworld;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 马克
 * @date 2023/6/4
 */
public class Demo3 {
    public static void main(String[] args) {
        String str1 = "3:01";
        String str2 = "04:00";

        LocalTime localTime = strTimeToLocalTime(str1);
        System.out.println("localTime = " + localTime);

    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^1[0-9]{10}$"); // 定义手机号码格式的正则表达式
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private static boolean frontLessThenBehind(String front, String behind) {
        String[] frontArr = front.split(":");
        String[] behindArr = behind.split(":");
        LocalTime t1 = LocalTime.of(Integer.parseInt(frontArr[0]), Integer.parseInt(frontArr[1]));
        LocalTime t2 = LocalTime.of(Integer.parseInt(behindArr[0]), Integer.parseInt(behindArr[1]));
        return t1.isBefore(t2);
    }

    private static boolean checkStrTimeFormatError(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            simpleDateFormat.parse(str);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    private static LocalTime strTimeToLocalTime(String strTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(strTime, formatter);
    }
}
