package com.example.helloworld;


import cn.hutool.json.JSONArray;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author 马克
 * @date 2023/4/21
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
       String  str = "{\"coldChain\":0,\"contactInfo\":{\"address\":\"浙江省杭州市余杭区金家渡中路2☎\uFE0F\",\"area\":\"余杭区\",\"areaCode\":\"330110\",\"city\":\"杭州市\",\"cityCode\":\"330100\",\"contactName\":\"唐红\",\"contactPhone\":\"18221115698\",\"location\":\"浙江省杭州市余杭区浙江省杭州市余杭区金家渡中路2☎\uFE0F\",\"province\":\"浙江省\",\"provinceCode\":\"330000\"},\"createTime\":\"2023-12-05 13:29:11\",\"deliveryFee\":0.02,\"deliveryId\":\"20231205132859E00001\",\"dpId\":10400,\"dpSelfId\":\"100001\",\"drugFee\":0.009999999999999998,\"extPayOrderId\":\"4200002085202312051576733014\",\"healFee\":0,\"isExpress\":0,\"items\":[{\"amount\":1,\"coldChain\":0,\"dpDrugCode\":\"6028475\",\"drugCode\":\"YTD_10400_6028475\",\"drugManufaturer\":\"沈阳君元药业有限公司\",\"drugName\":\"精制银翘解毒片\",\"drugSpec\":\"每片含扑热息痛44mg,24片\",\"itemId\":1182005,\"minPackUnit\":\"盒\",\"price\":0.01,\"pscriptDtlId\":2745228,\"sum\":0.01}],\"orderFee\":0.03,\"orderNo\":\"900900487701\",\"orderSrc\":\"HOS\",\"otherOrderNum\":0,\"packingListUrl\":\"https://ytnonpbiz.hsyuntai.com/p_3cbc7b3d073449769e5e63e574fae376.pdf\",\"partnerId\":\"100001\",\"payChannel\":\"ten\",\"payMethod\":0,\"payMode\":0,\"payOrderId\":\"YT210111420553000000923120507015\",\"payStatus\":2,\"payTime\":\"2023-12-05 13:29:17\",\"psCategory\":1,\"pscripts\":[{\"accPscriptId\":\"YT2023120500005\",\"createTime\":\"2023-12-05 13:23:08\",\"deptName\":\"胃肠外科\",\"diagnosis\":\"感冒、低蛋白血症、胃炎、心悸\",\"docName\":\"李亮\",\"drugs\":[{\"amount\":1,\"dpDrugCode\":\"6028475\",\"dpDrugId\":\"6028475\",\"drugCode\":\"YTD_10400_6028475\",\"drugName\":\"精制银翘解毒片\",\"drugSpec\":\"每片含扑热息痛44mg,24片\",\"frequency\":\"每日2次\",\"frequencyCode\":\"BID\",\"manufaturer\":\"沈阳君元药业有限公司\",\"oneDosage\":3,\"oneDosageUnit\":\"片\",\"price\":0.01,\"pscriptDtlId\":2745228,\"sum\":0.01,\"totalDosage\":\"18.00\",\"totalDosageUnit\":\"片\",\"units\":\"盒\",\"usage\":\"口服\",\"usageCode\":\"PO_口服\",\"usageDesc\":\"口服 每日2次 每次3片\",\"useDay\":\"3\"}],\"hisSourceType\":0,\"hosId\":101114,\"hosName\":\"中山大学附属第七医院（深圳）\",\"medInsDualChannelFlag\":0,\"patInfo\":{\"patAge\":\"29岁\",\"patBirthday\":\"2002-04-05\",\"patIdCardNo\":\"441411200204057654\",\"patName\":\"单药单\",\"patPhone\":\"15907552086\",\"patSex\":\"0\"},\"prescriptionFileUrl\":\"https://ytnonpbiz.hsyuntai.com/13ce94750d0b404399af1c0e77f3192f.pdf\",\"psCategory\":1,\"pscriptDate\":\"2023-12-05 13:23:08\",\"pscriptId\":1487506,\"scene\":1,\"urgentFlag\":0}],\"selfFee\":0.01,\"state\":1,\"toLogisticshub\":0,\"userNote\":\"\"}";
        System.out.println(str);
    }
}
