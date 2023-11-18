package com.example.helloworld.english;

/**
 * @author 马克
 * @since 2023/11/15
 */
public interface Template {
    String htmlTemplate = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "    <script>\n" +
            "        function playAudio(url) {\n" +
            "            new Audio(url).play();\n" +
            "        }\n" +
            "    </script>\n" +
            "    <style>\n" +
            "        body {\n" +
            "            background-color: #2B2B2B;\n" +
            "            font-size: 24px;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "%s\n" +
            "</body>\n" +
            "</html>";

    String rowTemplate = "<p style=\"color: #a9b7c6\">&nbsp&nbsp&nbsp&nbsp %s &nbsp&nbsp&nbsp&nbsp" +
            "<input type=\"button\" tabindex = \"%s\" value=\"UK\" onclick=\"playAudio('https://dict.youdao.com/dictvoice?audio=%s&type=1')\">" +
            "<input type=\"button\" value=\"US\" onclick=\"playAudio('https://dict.youdao.com/dictvoice?audio=%s&type=2')\">" +
            "<input type=\"button\" value=\"image\" onclick='window.open(\"https://cn.bing.com/images/search?q=%s&first=1\")'/> </p>\n";

    String getRowTemplateForExample = "<p style=\"color: #a9b7c6\">&nbsp&nbsp&nbsp&nbsp %s &nbsp&nbsp&nbsp&nbsp" +
            "<input type=\"button\" tabindex = \"%s\" value=\"UK\" onclick=\"playAudio('https://dict.youdao.com/dictvoice?audio=%s&type=1')\">" +
            "<input type=\"button\" value=\"US\" onclick=\"playAudio('https://dict.youdao.com/dictvoice?audio=%s&type=2')\">" +
            "<input type=\"button\" value=\"image\" onclick='window.open(\"https://cn.bing.com/images/search?q=%s&first=1\")'/>  %s </p>\n";
}
