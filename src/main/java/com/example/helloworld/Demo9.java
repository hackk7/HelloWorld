package com.example.helloworld;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author 马克
 * @date 2023/10/8
 */
public class Demo9 {
    public static void main(String[] args) {
        String str = "{\"coldChain\":0,\"contactInfo\":{\"address\":\"11\",\"area\":\"荔湾区\",\"areaCode\":\"440103\",\"city\":\"广州市\",\"cityCode\":\"440100\",\"contactName\":\"冲冲冲\",\"contactPhone\":\"15268335693\",\"location\":\"广东省广州市荔湾区11\",\"province\":\"广东省\",\"provinceCode\":\"440000\"},\"createTime\":\"2023-11-28 10:01:16\",\"deliveryFee\":0.01,\"deliveryId\":\"20231114160511E00001\",\"dpId\":10400,\"dpSelfId\":\"100001\",\"drugFee\":0.01,\"extPayOrderId\":\"4200001971202311149046928144\",\"healFee\":0.0,\"isExpress\":0,\"items\":[{\"amount\":1,\"coldChain\":0,\"dpDrugCode\":\"2211330\",\"drugCode\":\"YTD_10400_2211330\",\"drugManufaturer\":\"湖北香连药业有限责任公司\",\"drugName\":\"风寒感冒颗粒\",\"drugSpec\":\"每袋重8g\",\"drugTradeName\":\"仁和可立克\",\"itemId\":1181249,\"minPackUnit\":\"盒\",\"price\":0.01,\"pscriptDtlId\":2743502,\"sum\":0.01}],\"orderFee\":0.02,\"orderNo\":\"900900487534\",\"orderSrc\":\"HOS\",\"otherOrderNum\":0,\"packingListUrl\":\"https://ytnonpbiz.hsyuntai.com/p_ce52f1d7335440e281153b8c888c4989.pdf\",\"partnerId\":\"100001\",\"payChannel\":\"ten\",\"payMethod\":0,\"payMode\":3,\"payOrderId\":\"YT210111477907000000423111407015\",\"payStatus\":2,\"payTime\":\"2023-11-28 16:10:21\",\"psCategory\":1,\"pscripts\":[{\"accPscriptId\":\"YT2023111400010\",\"createTime\":\"2023-11-28 17:10:47\",\"deptName\":\"胃肠外科\",\"diagnosis\":\"感冒\",\"docName\":\"李亮\",\"drugs\":[{\"amount\":1,\"dpDrugCode\":\"2211330\",\"dpDrugId\":\"2211330\",\"drugCode\":\"YTD_10400_2211330\",\"drugName\":\"风寒感冒颗粒\",\"drugSpec\":\"每袋重8g\",\"drugTradeName\":\"仁和可立克\",\"frequency\":\"每日3次\",\"frequencyCode\":\"TID\",\"manufaturer\":\"湖北香连药业有限责任公司\",\"oneDosage\":1.0,\"oneDosageUnit\":\"袋\",\"price\":0.01,\"pscriptDtlId\":2743502,\"sum\":0.01,\"totalDosage\":\"3.00\",\"totalDosageUnit\":\"袋\",\"units\":\"盒\",\"usage\":\"口服\",\"usageCode\":\"PO_口服\",\"usageDesc\":\"口服 每日3次 每次1袋\",\"useDay\":\"1\"}],\"hisSourceType\":0,\"hosId\":101114,\"hosName\":\"中山大学附属第七医院（深圳）\",\"medInsDualChannelFlag\":0,\"patInfo\":{\"patAge\":\"23岁\",\"patBirthday\":\"1998-08-07\",\"patIdCardNo\":\"441423199808072343\",\"patName\":\"冯小天\",\"patPhone\":\"15907552086\",\"patSex\":\"0\"},\"prescriptionFileUrl\":\"https://ytnonpbiz.hsyuntai.com/9d111b19bed54ffb8cd96815381d6086.pdf\",\"psCategory\":1,\"pscriptDate\":\"2023-11-14 16:00:47\",\"pscriptId\":1486621,\"scene\":1,\"urgentFlag\":0}],\"selfFee\":0.01,\"state\":1,\"toLogisticshub\":0,\"userNote\":\"\"}";
        JSONObject jsonObject = JSON.parseObject(str);

        JSONArray items = jsonObject.getJSONArray("items");

        String newItem = "{\n" +
                "    \"amount\": 1,\n" +
                "    \"coldChain\": 0,\n" +
                "    \"dpDrugCode\": \"2434096\",\n" +
                "    \"drugCode\": \"YTD_10400_2434096\",\n" +
                "    \"drugManufaturer\": \"湖北香连药业有限责任公司\",\n" +
                "    \"drugName\": \"感冒灵颗粒\",\n" +
                "    \"drugSpec\": \"每袋重10g\",\n" +
                "    \"drugTradeName\": \"仁和可立克\",\n" +
                "    \"itemId\": 1181249,\n" +
                "    \"minPackUnit\": \"盒\",\n" +
                "    \"price\": 0.01,\n" +
                "    \"pscriptDtlId\": 2743502,\n" +
                "    \"sum\": 0.01\n" +
                "}";
        items.add(JSON.parse(newItem));
        System.out.println(items);

        String straa = "[{\"amount\":1,\"coldChain\":0,\"dpDrugCode\":\"2211330\",\"drugCode\":\"YTD_10400_2211330\",\"drugManufaturer\":\"湖北香连药业有限责任公司\",\"drugName\":\"风寒感冒颗粒\",\"drugSpec\":\"每袋重8g\",\"drugTradeName\":\"仁和可立克\",\"itemId\":1181249,\"minPackUnit\":\"盒\",\"price\":0.01,\"pscriptDtlId\":2743502,\"sum\":0.01},{\"amount\":1,\"coldChain\":0,\"dpDrugCode\":\"2434096\",\"drugCode\":\"YTD_10400_2434096\",\"drugManufaturer\":\"湖北香连药业有限责任公司\",\"drugName\":\"感冒灵颗粒\",\"drugSpec\":\"每袋重10g\",\"drugTradeName\":\"仁和可立克\",\"itemId\":1181249,\"minPackUnit\":\"盒\",\"price\":0.01,\"pscriptDtlId\":2743502,\"sum\":0.01}]" ;
    }
}
