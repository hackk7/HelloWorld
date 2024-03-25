package com.example.helloworld;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;

/**
 * @author 马克
 * @since 2024/3/16
 */
public class Demo13 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        long timestamp2 = calendar.getTimeInMillis();
        System.out.println(timestamp2);
    }
}
