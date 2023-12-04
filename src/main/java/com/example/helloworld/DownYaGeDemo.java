package com.example.helloworld;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 马克
 * @since 2023/11/11
 */
public class DownYaGeDemo {

    private static String json = "{\n" +
            "    \"1579858\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-8/73/1480873--1916617300.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1128142&uid=1480873&cover_ts=1699420933\"\n" +
            "    },\n" +
            "    \"1605576\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-22/73/1480873--3297532648.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1145503&uid=1480873&cover_ts=1700632666\"\n" +
            "    },\n" +
            "    \"1607371\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-23/73/1480873--2677575156.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1146846&uid=1480873&cover_ts=1700718597\"\n" +
            "    },\n" +
            "    \"1609137\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-24/73/1480873--3204046247.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1148080&uid=1480873&cover_ts=1700806520\"\n" +
            "    },\n" +
            "    \"1611398\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-25/73/1480873--3661148991.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1149699&uid=1480873&cover_ts=1700912291\"\n" +
            "    },\n" +
            "    \"1612206\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-26/73/1480873--4163075398.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1150296&uid=1480873&cover_ts=1700961121\"\n" +
            "    },\n" +
            "    \"1613932\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-27/73/1480873--1764593208.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1151536&uid=1480873&cover_ts=1701046226\"\n" +
            "    },\n" +
            "    \"1615838\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-28/73/1480873--2176357182.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1152810&uid=1480873&cover_ts=1701148841\"\n" +
            "    },\n" +
            "    \"1617725\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-29/73/1480873--2029588507.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1154142&uid=1480873&cover_ts=1701242421\"\n" +
            "    },\n" +
            "    \"1619418\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-30/73/1480873--3996278323.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1155307&uid=1480873&cover_ts=1701329588\"\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) throws Exception {
        List<String> chineseName = Arrays.asList("道路 真理 生命", "做聪明的童女", "生命路上的仇敌", "建造心灵的圣殿", "希西家病得痊愈", "生命路上的拯救者", "更正不对的心态", "在审判的路上等候你", "住在高处和高城的人", "罪的律和神的恩");
        JSONObject entries = JSONUtil.parseObj(json);
        int[] names = new int[]{1579858,1605576,1607371,1609137,1611398,1612206,1613932,1615838,1617725,1619418};
        for (int i = 0; i < names.length; i++) {
            JSONObject sub = JSONUtil.parseObj(entries.get(names[i] + ""));
            String playUrl= String.valueOf(sub.get("playurl"));
            File file = new File(chineseName.get(i)+".m4a");
            URL url = new URL(playUrl);
            System.out.println(url);
            System.out.println(file.getName());
            FileUtils.copyURLToFile(url,file);
            Thread.sleep(2000L);
        }
    }
}
