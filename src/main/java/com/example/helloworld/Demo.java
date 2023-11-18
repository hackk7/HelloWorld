package com.example.helloworld;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 马克
 * @date 2023/4/14
 */
public class Demo {


    public static void main(String[] args) {
        String comment = "<br/><div class=\"media-wrap image-wrap\"><img class=\"media-wrap image-wrap\" src=\"//public-images-erda.obs.cn-east-3.myhuaweicloud.com/public-images-erda/trantor/attachments/fe5776a5-e75b-43e7-8fb2-44ece2259534.png\"/></div><p>aa</p><div class=\"media-wrap image-wrap\"><img class=\"media-wrap image-wrap\" src=\"//public-images-erda.obs.cn-east-3.myhuaweicloud.com/public-images-erda/trantor/attachments/5c63ae00-d37e-4216-8b56-12a23af4d70b.png\"/></div><p>sdf测试，啊啊啊asdfasdfa</p>";
        String s = htmlFilter(comment);
        System.out.println("s = " + s);
    }


    public static String htmlFilter(String htmlStr) {
        // 定义script的正则表达式
        String regExScript = "<script[^>]*?>[\\s\\S]*?</script>";
        // 定义style的正则表达式
        String regExStyle = "<style[^>]*?>[\\s\\S]*?</style>";
        // 定义HTML标签的正则表达式
        String regExHtml = "<[^>]+>";

        // 过滤script标签
        Pattern pScript = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE);
        Matcher mScript = pScript.matcher(htmlStr);
        htmlStr = mScript.replaceAll("");

        Pattern pStyle = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll("");

        Pattern pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll("");

        String str = htmlStr.trim();
        str = str.replaceAll("\\s*", "").replaceAll("", "");
        return str;
    }

    private List<String> getFileUrl(String str) {
        return null;
    }

    public static String getStringBetweenTwoChars(String str, String startChar, String endChar) {
        String regex = startChar + "([^" + endChar + "]*)" + endChar;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
