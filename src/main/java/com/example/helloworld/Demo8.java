package com.example.helloworld;

import cn.hutool.json.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 马克
 * @date 2023/7/11
 */
public class Demo8 {
    public static void main(String[] args) {
        JSONObject entries = JSONUtil.parseObj(json);
        Object order = entries.get("orders");
        JSONArray objects = JSONUtil.parseArray(order);
        Object o = objects.get(0);
        JSONArray objects1 = JSONUtil.parseArray(JSONUtil.parseObj(o).get("items"));
        for (Object o1 : objects1) {
            JSON parse = JSONUtil.parse(o1);
        }
        JSONObject orderJson = JSONUtil.parseObj(o);
        Double drugFee = orderJson.getDouble("drugFee");
        System.out.println("drugFee = " + drugFee);

        Map<String, Double> testMap = new HashMap<>();

    }

    static String json = "{\n" +
            "    \"orders\": [\n" +
            "        {\n" +
            "            \"orderNo\": \"32169\",\n" +
            "            \"deliveryFee\": 0,\n" +
            "            \"deliveryId\": \"20170721124540E00001\",\n" +
            "            \"dpDeliveryId\": \"1439\",\n" +
            "            \"drugFee\": 62.23,\n" +
            "            \"invoiceTitle\": \"陈云\",\n" +
            "            \"isExpress\": 0,\n" +
            "            \"orderFee\": 62.23,\n" +
            "            \"partnerId\": \"TEST00001\",\n" +
            "            \"payTime\": \"2017-07-21 12:46:05\",\n" +
            "            \"dpSelfId\": \"E6123216323\",\n" +
            "            \"payMethod\": 0,\n" +
            "            \"state\": 1,\n" +
            "            \"items\": [\n" +
            "                {\n" +
            "                    \"itemId\": 1234321,\n" +
            "                    \"dpDrugCode\": \"0102900\",\n" +
            "                    \"drugCode\": \"110575\",\n" +
            "                    \"drugName\": \"阿卡波糖片\",\n" +
            "                    \"drugTradeName\": \"拜唐苹\",\n" +
            "                    \"coldChian\": 0,\n" +
            "                    \"price\": 62.23,\n" +
            "                    \"amount\": 1,\n" +
            "                    \"sum\": 62.23\n" +
            "                }\n" +
            "            ],\n" +
            "            \"pscripts\": [\n" +
            "                {\n" +
            "                    \"deptName\": \"发热门诊\",\n" +
            "                    \"diagnosis\": \"糖尿病\",\n" +
            "                    \"docName\": \"陈晓珍\",\n" +
            "                    \"dpMatchId\": \"1437\",\n" +
            "                    \"drugs\": [\n" +
            "                        {\n" +
            "                            \"pscriptDtlId\": 113077,\n" +
            "                            \"amount\": 1,\n" +
            "                            \"dpDrugCode\": \"0102900\",\n" +
            "                            \"dpDrugId\": \"110575\",\n" +
            "                            \"dpPscriptDtlId\": \"2186\",\n" +
            "                            \"drugName\": \"阿卡波糖片\",\n" +
            "                            \"drugSource\": 1,\n" +
            "                            \"drugSpec\": \"50mg*30片\",\n" +
            "                            \"drugTradeName\": \"拜唐苹\",\n" +
            "                            \"drugType\": 0,\n" +
            "                            \"frequency\": \"每日3次\",\n" +
            "                            \"frequencyCode\": \"tid\",\n" +
            "                            \"frequencyQty\": 10,\n" +
            "                            \"manufaturer\": \"拜耳医药保健有限公司\",\n" +
            "                            \"oneDosage\": 50,\n" +
            "                            \"oneDosageUnit\": \"mg\",\n" +
            "                            \"price\": 62.23,\n" +
            "                            \"sum\": 62.23,\n" +
            "                            \"totalDosage\": 1500,\n" +
            "                            \"totalDosageUnit\": \"mg\",\n" +
            "                            \"units\": \"盒\",\n" +
            "                            \"usage\": \"口服\",\n" +
            "                            \"usageCode\": \"PO\",\n" +
            "                            \"usageDesc\": \"口服 每日3次 每次50.0mg\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"hosId\": 226,\n" +
            "                    \"hosName\": \"暨南大学附属第一医院\",\n" +
            "                    \"matchId\": \"20170721124510M00001\",\n" +
            "                    \"patInfo\": {\n" +
            "                        \"patAge\": 24,\n" +
            "                        \"patIdCardNo\": \"411503199304100751\",\n" +
            "                        \"patName\": \"陈云\",\n" +
            "                        \"patPhone\": \"17099998888\",\n" +
            "                        \"patSex\": 0\n" +
            "                    },\n" +
            "                    \"pscriptDate\": \"2017-07-21 09:38:47\",\n" +
            "                    \"pscriptId\": 133949\n" +
            "                }\n" +
            "            ],\n" +
            "            \"contactInfo\": {\n" +
            "                \"address\": \"广信江湾大酒店298芸辉公司\",\n" +
            "                \"area\": \"越秀区\",\n" +
            "                \"areaCode\": \"440104\",\n" +
            "                \"city\": \"广州市\",\n" +
            "                \"cityCode\": \"440100\",\n" +
            "                \"contactName\": \"张三\",\n" +
            "                \"contactPhone\": \"17099998888\",\n" +
            "                \"location\": \"广东省广州市越秀区农林街道广信江湾大酒店298芸辉公司\",\n" +
            "                \"province\": \"广东省\",\n" +
            "                \"provinceCode\": \"440000\",\n" +
            "                \"street\": \"农林街道\",\n" +
            "                \"streetCode\": \"440104012\",\n" +
            "                \"zipCode\": \"\"\n" +
            "            },\n" +
            "            \"invoice\": {\n" +
            "                \"invType\": 0,\n" +
            "                \"titleType\": 1,\n" +
            "                \"title\": \"广东芸辉科技有限公司\",\n" +
            "                \"taxNo\": \"YYYY12321312\",\n" +
            "                \"receiveEmail\": \"xxx@163.com\"\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
