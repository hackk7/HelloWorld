package com.example.helloworld;

import util.AES;

/**
 * @author 马克
 * @date 2023/4/5
 */
public class DecDemo {
    public static void main(String[] args) throws Exception {
        String aesKey = "bcZQaiRPhLKxgPTf";
        String param = "pWsGSLml1HTlbnGgRwBtpUg/wTnGs7NeweyMpOUddKo=";
        param = AES.aesDecrypt(param, aesKey);
        System.out.println("param = " + param);
    }
}
