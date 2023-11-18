package com.example.helloworld;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * @author 马克
 * @date 2023/7/6
 */
public class Demo7 {
    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//            System.out.println(IdUtil.objectId());
//        }

//        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
//        Snowflake snowflake2 = IdUtil.getSnowflake(1, 1);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("1: " + snowflake.nextId());
//            System.out.println("2: " + snowflake2.nextId());
//        }

        for (int i = 0; i < 10; i++) {
            System.out.println(IdUtil.getSnowflakeNextIdStr());
        }
    }
}
