package com.example.helloworld;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 马克
 * @date 2023/6/11
 */
public class Demo4 {
    public static void main(String[] args) {
        String str = "{\"coldChain\":0,\"createTime\":\"2023-12-01 09:24:25\",\"deliveryFee\":0.0,\"dpId\":10400,\"dpSelfId\":\"100001\",\"drugFee\":0.06,\"extPayOrderId\":\"4200002000202312018990785444\",\"healFee\":0.0,\"isExpress\":1,\"items\":[{\"amount\":2,\"coldChain\":0,\"dpDrugCode\":\"6028475\",\"drugCode\":\"YTD_10400_6028475\",\"drugManufaturer\":\"沈阳君元药业有限公司\",\"drugName\":\"精制银翘解毒片\",\"drugSpec\":\"每片含扑热息痛44mg,24片\",\"itemId\":1181964,\"minPackUnit\":\"盒\",\"price\":0.01,\"pscriptDtlId\":2745178,\"sum\":0.02},{\"amount\":4,\"coldChain\":0,\"dpDrugCode\":\"2211330\",\"drugCode\":\"YTD_10400_2211330\",\"drugManufaturer\":\"湖北香连药业有限责任公司\",\"drugName\":\"风寒感冒颗粒\",\"drugSpec\":\"每袋重8g\",\"drugTradeName\":\"仁和可立克\",\"itemId\":1181965,\"minPackUnit\":\"盒\",\"price\":0.01,\"pscriptDtlId\":2745179,\"sum\":0.04}],\"orderFee\":0.06,\"orderNo\":\"900900487686\",\"orderSrc\":\"HOS\",\"otherOrderNum\":0,\"packingListUrl\":\"https://ytnonpbiz.hsyuntai.com/p_722982d9a14c40efaf0601d0755758cb.pdf\",\"partnerId\":\"100001\",\"payChannel\":\"ten\",\"payMethod\":0,\"payMode\":1,\"payOrderId\":\"YT210111410704000000423120107015\",\"payStatus\":2,\"payTime\":\"2023-12-01 09:24:31\",\"psCategory\":1,\"pscripts\":[{\"accPscriptId\":\"YT2023120100001\",\"createTime\":\"2023-12-01 09:14:22\",\"deptName\":\"胃肠外科\",\"diagnosis\":\"感冒\",\"docName\":\"李亮\",\"drugs\":[{\"amount\":2,\"dpDrugCode\":\"6028475\",\"dpDrugId\":\"6028475\",\"drugCode\":\"YTD_10400_6028475\",\"drugName\":\"精制银翘解毒片\",\"drugSpec\":\"每片含扑热息痛44mg,24片\",\"frequency\":\"每日2次\",\"frequencyCode\":\"BID\",\"manufaturer\":\"沈阳君元药业有限公司\",\"oneDosage\":3.0,\"oneDosageUnit\":\"片\",\"price\":0.01,\"pscriptDtlId\":2745178,\"sum\":0.02,\"totalDosage\":\"42.00\",\"totalDosageUnit\":\"片\",\"units\":\"盒\",\"usage\":\"口服\",\"usageCode\":\"PO_口服\",\"usageDesc\":\"口服 每日2次 每次3片\",\"useDay\":\"7\"},{\"amount\":4,\"dpDrugCode\":\"2211330\",\"dpDrugId\":\"2211330\",\"drugCode\":\"YTD_10400_2211330\",\"drugName\":\"风寒感冒颗粒\",\"drugSpec\":\"每袋重8g\",\"drugTradeName\":\"仁和可立克\",\"frequency\":\"每日3次\",\"frequencyCode\":\"TID\",\"manufaturer\":\"湖北香连药业有限责任公司\",\"oneDosage\":1.0,\"oneDosageUnit\":\"袋\",\"price\":0.01,\"pscriptDtlId\":2745179,\"sum\":0.04,\"totalDosage\":\"21.00\",\"totalDosageUnit\":\"袋\",\"units\":\"盒\",\"usage\":\"口服\",\"usageCode\":\"PO_口服\",\"usageDesc\":\"口服 每日3次 每次1袋\",\"useDay\":\"7\"}],\"hisSourceType\":0,\"hosId\":101114,\"hosName\":\"中山大学附属第七医院（深圳）\",\"medInsDualChannelFlag\":0,\"patInfo\":{\"patAge\":\"29岁\",\"patBirthday\":\"2002-04-05\",\"patIdCardNo\":\"441411200204057654\",\"patName\":\"冯小天\",\"patPhone\":\"15907552086\",\"patSex\":\"0\"},\"prescriptionFileUrl\":\"https://ytnonpbiz.hsyuntai.com/5bc5aa8727334d1fa83187c9274546a8.pdf\",\"psCategory\":1,\"pscriptDate\":\"2023-12-01 09:14:22\",\"pscriptId\":1487474,\"scene\":1,\"urgentFlag\":0}],\"selfFee\":0.06,\"state\":1,\"toLogisticshub\":0,\"userNote\":\"\"}";
        System.out.println(str);
    }
}
