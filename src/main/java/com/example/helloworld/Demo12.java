package com.example.helloworld;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 * @author 马克
 * @since 2024/3/7
 */
public class Demo12 {
    public static void main(String[] args) {
//        BigDecimal a = new BigDecimal(123321);
//        DecimalFormat df = new DecimalFormat("#0.00");
//        String format = df.format(a);
//        System.out.println(format);

//        String url = "//public-images-erda.obs.cn-east-3.myhuaweicloud.com/public-images-erda/trantor/attachments/e6f325cc-9017-4034-9802-c738497c145a.jpg";
//        String httpUrl = "https:" + url;
//        System.out.println(httpUrl);

//        // 创建一个LocalTime实例
//        LocalTime time = LocalTime.now();
//        // 创建一个DateTimeFormatter实例
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//
//        // 使用formatter将LocalTime转换为String
//        String timeString = time.format(formatter);
//
//        // 输出转换后的字符串
//        System.out.println(timeString);

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextLong());
        }
    }
}
