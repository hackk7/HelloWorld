package com.example.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyan
 * @description: 从富文本里抓取图片地址
 * @date 2019-12-09 12:54 PM
 */
public class ImgFromEditor {
    //利用预编译功能，加快匹配速度
     /**
     * p_image
     * r_image 
     */


    /**
     * @description
     * @author sunyan
     * @date 2019/12/9 1:34 PM
     * @param htmlStr
     * @return java.util.List<java.lang.String>
     *
     */
    public static List<String> getImgStr(String htmlStr) {
        Pattern p_image=Pattern.compile("<img.*src\\s*=\\s*(.*?)[^>]*?>",Pattern.CASE_INSENSITIVE);
        Pattern r_image=Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)");
        List<String> list = new ArrayList<>();
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        Matcher m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            String img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = r_image.matcher(img);
            while (m.find()) {
                list.add("https:" + m.group(1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = getImgStr("<br/><div class=\"media-wrap image-wrap\"><img class=\"media-wrap image-wrap\" src=\"//public-images-erda.obs.cn-east-3.myhuaweicloud.com/public-images-erda/trantor/attachments/fe5776a5-e75b-43e7-8fb2-44ece2259534.png\"/></div><p>aa</p><div class=\"media-wrap image-wrap\"><img class=\"media-wrap image-wrap\" src=\"//public-images-erda.obs.cn-east-3.myhuaweicloud.com/public-images-erda/trantor/attachments/5c63ae00-d37e-4216-8b56-12a23af4d70b.png\"/></div><p>sdfasdfasdfa</p>");
        for (Object a:list){
            System.out.println(a.toString());
        };
    }
}

