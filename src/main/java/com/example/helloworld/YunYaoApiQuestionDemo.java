package com.example.helloworld;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 马克
 * @since 2023/11/10
 */
public class YunYaoApiQuestionDemo {

    private static final String url = "http://api-uat.hsyuntai.com/hsyt-yun-restapi/opm/api/v1/drugEvent";

    public static void main(String[] args) throws Exception {

        // 平台请求对象
        MainRequest request = new MainRequest();
        // 接口请求对象
        DrugEventRequest drugEventRequest = new DrugEventRequest();
        // 接口事件对象
        DrugEventRequest.Event event = new DrugEventRequest.Event();
        // 接口事件参数对象
        DrugEventRequest.Event.EventParam eventParam = new DrugEventRequest.Event.EventParam();

        // 设置接口参数，库存2
        eventParam.setQty(2);
        // 设置接口事件参数
        event.setParams(eventParam);

        // 设置事件
        event.setEventType(Constant.STOCK_CHANGE);
        event.setDpDrugCode("6028475");

        // 设置接口请求
        drugEventRequest.setEvents(Collections.singletonList(event));
        drugEventRequest.setHosId(100001);
        drugEventRequest.setEventBatchNo("0000001");

        // 云平台公钥签名
        String paramsStr = getParmsString(JSONUtil.toJsonStr(drugEventRequest));
        System.out.println("签名前sign: " + paramsStr);
        String encrypt = encrypt(paramsStr, Constant.YUN_YAO_PUBLIC_KEY);
        System.out.println("签名后sign: " + encrypt);

        // 设置平台请求
        request.setSign(encrypt);
        request.setContent(JSONUtil.toJsonStr(drugEventRequest));
        request.setVersion(Constant.VERSION);
        request.setPartnerId(Constant.PARTNER_ID);
        request.setVersion(Constant.VERSION);
        request.setSignType(Constant.SIGN_TYPE);
        request.setContent(JSONUtil.toJsonStr(drugEventRequest));
        request.setTimestamp(getTimestamp());
        request.setContent(drugEventRequest);

        // 发送POST请求
        String postBodyJson = JSONUtil.toJsonStr(request);
        System.out.println("POST请求体：" + postBodyJson);
        String responseStr = HttpUtil.post(url, postBodyJson);

        // 响应
        System.out.println(responseStr);
    }

    public static String getParmsString(String content) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        StringBuffer sb = new StringBuffer();
        sb.append("content=");
        sb.append(content);
        sb.append("&");
        sb.append("partnerId=");
        sb.append(Constant.PARTNER_ID);
        sb.append("&");
        sb.append("signType=");
        sb.append(Constant.SIGN_TYPE);
        sb.append("&");
        sb.append("timestamp=");
        sb.append(simpleDateFormat.format(new Date()));
        sb.append("&");
        sb.append("version=");
        sb.append(Constant.VERSION);
        return sb.toString();
    }

    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //分段加密
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] bytes = str.getBytes();
        int inputLen = bytes.length;
        int offLen = 0;//偏移量
        int i = 0;
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        while(inputLen - offLen > 0){
            byte [] cache;
            if(inputLen - offLen > 117){
                cache = cipher.doFinal(bytes, offLen,117);
            }else{
                cache = cipher.doFinal(bytes, offLen,inputLen - offLen);
            }
            bops.write(cache);
            i++;
            offLen = 117 * i;
        }
        bops.close();
        byte[] encryptedData = bops.toByteArray();
        String encodeToString = Base64.encodeBase64String(encryptedData);
        return encodeToString;
    }

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //分段解密
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);

        byte[] bytes = Base64.decodeBase64(str);
        int inputLen = bytes.length;
        int offLen = 0;
        int i = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while(inputLen - offLen > 0){
            byte[] cache;
            if(inputLen - offLen > 128){
                cache = cipher.doFinal(bytes,offLen,128);
            }else{
                cache = cipher.doFinal(bytes,offLen,inputLen - offLen);
            }
            byteArrayOutputStream.write(cache);
            i++;
            offLen = 128 * i;

        }
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return new String(byteArray);
    }

    private static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    static public class MainRequest {
        // 合作伙伴ID 由云药房分配
        private String partnerId;
        // 签名类型 默认填写RSA
        private String signType;
        // 签名串 请求参数的签名串，详见签名生成算法
        private String sign;
        // 时间戳 发送请求的时间,格式为：yyyy-MM-dd HH:mm:ss
        private String timestamp;
        // 接口版本 调用的接口版本，默认 1.1
        private String version;
        // 业务参数 JSON 格式，详见各个业务接口说明
        private Object content;

        public String getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(String partnerId) {
            this.partnerId = partnerId;
        }

        public String getSignType() {
            return signType;
        }

        public void setSignType(String signType) {
            this.signType = signType;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }
    }


    static public class DrugEventRequest {
        // 事件批次号
        private String eventBatchNo;
        // 门店ID
        private String dpSelfId;
        // 医院ID
        private Number hosId;
        // 事件集合，单次最多500条
        private List<Event> events;

        public static class Event {
            // 药商药品编码
            private String dpDrugCode;
            // 事件类型：0-药品下架、1-药品上架、2-价格变更、3-库存变更
            private Number eventType;

            private EventParam params;

            public static class EventParam {
                // 价格，事件类型为2时传该字段
                private Number drugPrice;
                // 库存数量，事件类型为3时传该字段
                private Number qty;

                public Number getDrugPrice() {
                    return drugPrice;
                }

                public void setDrugPrice(Number drugPrice) {
                    this.drugPrice = drugPrice;
                }

                public Number getQty() {
                    return qty;
                }

                public void setQty(Number qty) {
                    this.qty = qty;
                }
            }

            public String getDpDrugCode() {
                return dpDrugCode;
            }

            public void setDpDrugCode(String dpDrugCode) {
                this.dpDrugCode = dpDrugCode;
            }

            public Number getEventType() {
                return eventType;
            }

            public void setEventType(Number eventType) {
                this.eventType = eventType;
            }

            public EventParam getParams() {
                return params;
            }

            public void setParams(EventParam params) {
                this.params = params;
            }
        }

        public String getEventBatchNo() {
            return eventBatchNo;
        }

        public void setEventBatchNo(String eventBatchNo) {
            this.eventBatchNo = eventBatchNo;
        }

        public String getDpSelfId() {
            return dpSelfId;
        }

        public void setDpSelfId(String dpSelfId) {
            this.dpSelfId = dpSelfId;
        }

        public Number getHosId() {
            return hosId;
        }

        public void setHosId(Number hosId) {
            this.hosId = hosId;
        }

        public List<Event> getEvents() {
            return events;
        }

        public void setEvents(List<Event> events) {
            this.events = events;
        }
    }

    static public class Constant {
        // 事件类型：0-药品下架、1-药品上架、2-价格变更、3-库存变更
        private static Integer STOCK_CHANGE = 3;
        // 合作伙伴ID
        private static String PARTNER_ID = "4363C1DC3E304FF7AE2F6A6F3B6ABB98";
        // 签名类型
        private static String SIGN_TYPE = "RSA";
        // 接口版本
        private static String VERSION = "1.1";
        // 云药房公钥
        private static String YUN_YAO_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPuFesMHZMK9UtNfDCCzBdjmMIHF3hHCu9F/vFKJDFJZeTBrAnDn41O+IQT/ajBH8dYi9fbbdtb6Rb5NMMFWt3atRnkBoTmpW3kReGsN16RGpABp0hFVWzhfwfRmWR+ezRpQOwf/IXdzhpgFmoif6ysAWhURrkz0Ce6acd1yOHXwIDAQAB";
    }
}
