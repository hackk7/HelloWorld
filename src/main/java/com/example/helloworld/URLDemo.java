package com.example.helloworld;

/**
 * @author 马克
 * @date 2023/11/2
 */
public class URLDemo {
    public static void main(String[] args) {
        String template = "<p style=\"color: #a9b7c6\">&nbsp&nbsp&nbsp&nbsp %s &nbsp&nbsp&nbsp&nbsp" +
                "<input type=\"button\" tabindex = \"%s\" value=\"UK\" onclick=\"playAudio('https://dict.youdao.com/dictvoice?audio=%s&type=1')\">" +
                "<input type=\"button\" value=\"US\" onclick=\"playAudio('https://dict.youdao.com/dictvoice?audio=%s&type=2')\">" +
                "<input type=\"button\" value=\"image\" onclick='window.open(\"https://cn.bing.com/images/search?q=%s&first=1\")'/> </p>\n";

    }

}
