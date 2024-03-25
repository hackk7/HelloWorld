package com.example.helloworld.xiaominote;

/**
 * @author 马克
 * @since 2024/3/18
 */
public interface HtmlTemplate {
    public String HTML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE html\n" +
            "    PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
            "    <title>%s</title>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "    %s\n" +
            "</body>\n" +
            "\n" +
            "</html>";
}
