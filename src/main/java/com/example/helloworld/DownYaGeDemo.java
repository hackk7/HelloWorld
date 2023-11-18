package com.example.helloworld;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 马克
 * @since 2023/11/11
 */
public class DownYaGeDemo {

    private static String json = "{\n" +
            "    \"1549831\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-22/34/1437334--2262433379.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1107595&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1554417\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-25/34/1437334--224986931.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1110820&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1556112\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-26/34/1437334--3487464652.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1111947&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1558153\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-27/34/1437334--164764735.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1113391&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1559831\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-28/34/1437334--889445216.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1114629&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1561544\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-29/34/1437334--2975488116.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1115840&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1562190\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-29/34/1437334--3484622558.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1116340&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1562191\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-29/34/1437334--513154490.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1116341&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1565327\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-31/34/1437334--3341432377.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1118778&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1565328\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/10-31/34/1437334--3170004050.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1118779&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1567359\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-1/34/1437334--1415493281.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1120163&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1567360\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-1/34/1437334--1756584977.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1120164&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1568528\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-2/34/1437334--1821359534.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1120918&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1568529\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-2/34/1437334--3182083786.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1120919&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1569630\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-2/34/1437334--2371595145.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1121643&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1569631\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-2/34/1437334--3842436521.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1121644&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1571867\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-4/34/1437334--3755869752.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1123086&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1571868\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-4/34/1437334--3506802186.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1123087&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1574157\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-5/34/1437334--526991110.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1124644&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1575431\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-6/34/1437334--2566514425.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1125571&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1575432\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-6/34/1437334--4142262062.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1125572&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1577395\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-7/34/1437334--3530469111.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1126760&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1577396\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-7/34/1437334--1418804404.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1126761&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1579160\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-8/34/1437334--3453593576.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1127698&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1579161\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-8/34/1437334--3715422850.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1127699&uid=1437334&cover_ts=0\"\n" +
            "    },\n" +
            "    \"1581066\": {\n" +
            "        \"playurl\": \"http://cdn.yingxuapp.cn/pfc/2023/11-9/34/1437334--1212305099.m4a\",\n" +
            "        \"media\": \"a\",\n" +
            "        \"cover\": \"http://napi.yingxuapp.cn/pastorfcpic/imginfo.php?type=fc_cover&fcid=1128810&uid=1437334&cover_ts=0\"\n" +
            "    }\n" +
            "}";
    static String fileName = "畅谈以色列(%d).m4a";
    public static void main(String[] args) throws Exception {
        JSONObject entries = JSONUtil.parseObj(json);
        int[] names = new int[]{1549831,1554417,1556112,1558153,1559831,1561544,1562190,1562191,1565327,1565328,1567359,1567360,1568528,1568529,1569630,1569631,1571867,1571868,1574157,1575431,1575432,1577395,1577396,1579160,1579161,1581066};
        for (int i = 0; i < names.length; i++) {
            JSONObject sub = JSONUtil.parseObj(entries.get(names[i] + ""));
            String playUrl= String.valueOf(sub.get("playurl"));
            File file = new File(String.format(fileName, i+1));
            URL url = new URL(playUrl);
            System.out.println(file.getName());
            FileUtils.copyURLToFile(url,file);
            Thread.sleep(2000L);
        }
    }
}
