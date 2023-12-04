package com.example.helloworld.english;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author 马克
 * @date 2023/11/1
 */
public class GenerateHtml {

    static String htmlCode = "";

    public static void main(String[] args) throws Exception {

        generate("/Users/mark/Desktop/note/English/GaoZhong_1.md",true);

        outPut("/Users/mark/Desktop/note/English/practice.html");
        outPut("/Users/mark/Desktop/practice.html");
        outPut("practice.html");
    }



    private static void generate(String file, boolean flag) throws Exception {
        List<String> allLines = Files.readAllLines(Paths.get(file));
        // 去掉标题与表格符
        allLines.remove(0);
        allLines.remove(0);
        StringBuffer stringBuffer = new StringBuffer();
        int tabIndex = 0;
        for (String line : allLines) {
            // 去掉后部中文
            String[] split = line.split("\\|");
            if (split.length == 0)
                continue;
            String substring = split[0];
            String handler;
            // 转换成html元素
            if (flag)
                handler = transformHtmlElement(substring, String.valueOf(tabIndex += 1), split.length > 1 ? split[1] : "");
            else
                handler = transformHtmlElement(substring, String.valueOf(tabIndex += 1), "");
            // 添加到html元素集合中
            stringBuffer.append(handler);
        }
        // 转换成html文档
        htmlCode = htmlTemp(stringBuffer.toString());

    }

    private static void outPut(String outPath) throws Exception {
        // 输出到文件
        fileWriterMethod(outPath, htmlCode);
    }

    private static String transformHtmlElement(String word, String tabIndex, String example) {
        String trimWord = word.trim();
        return String.format(Template.getRowTemplateForExample, trimWord, tabIndex, trimWord, trimWord, trimWord, example);
    }

    private static String htmlTemp(String content) {
        return String.format(Template.htmlTemplate, content);
    }

    /**
     * 方法 1：使用 FileWriter 写文件
     *
     * @param filepath 文件目录
     * @param content  待写入内容
     * @throws IOException
     */
    public static void fileWriterMethod(String filepath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.append(content);
        }
    }
}
