package util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.Map;

/**
 */
public class AES {

//    private static final String KEY = "OXYGEN2019";
//    public static String KEY = "WONDERSWPPRO2019";
    public static String KEY = "zHh4iXXAEedS2eos";

    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    private static Map<String,String> sessionKey = new HashedMap();

    public static void put(String sessionId, String key){
        sessionKey.put(sessionId, key);
    }

    /**
     * aes解密
     * @throws Exception
     */
    public static String aesDecrypt(String encrypt) {
        try {
            return aesDecrypt(encrypt, KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * aes加密
     */
    public static String aesEncrypt(String content) {
        try {
            return aesEncrypt(content, KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     */
    public static String binary(byte[] bytes, int radix){
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

    /**
     * base 64 encode
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes){
        return Base64.encodeBase64String(bytes);
    }

    /**
     */
    public static byte[] base64Decode(String base64Code) throws Exception{
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }


    /**
     * AES加密
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }


    /**
     * AES加密为base 64 code
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        if (StringUtils.isEmpty(content)){
            return null;
        }
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES加密为base 64 code
     */
    public static String aesEncryptByKey(String content) throws Exception {
        return StringUtils.isEmpty(content) ? null :base64Encode(aesEncryptToBytes(content, KEY));
    }

    /**
     * AES解密
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes,"utf-8");
    }


    /**
     * 将base 64 code AES解密
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * 测试.m4a
     */
    public static void main(String[] args) throws Exception {
//        String str = "E7TDnEWG4/BbxIzWnY+B/0pXz/fa7sp9FGWMFYY93nI=";
//        String str2 = aesDecrypt(str,"kMIqqcF2htbvzxvl");
//        System.out.println(str2);
        /*Map<String,Object> param = new HashMap<>();
        param.put("questionStatus","1");
//        param.put("code","5a250f250129441d973181ff310265f1");
        String content = JSONObject.toJSONString(param);
//        System.out.println(content);
//        System.out.println("加密前：" + content);
//        System.out.println("加密密钥和解密密钥：" + KEY);
        String encrypt = aesEncrypt(content, KEY);
        System.out.println("加密后：" + encrypt);
//        String abc = "/jK7a/6Tl6lhqgcKCynoIg5oXGcpntWNu3w8imE2lwcF9AqP3Rp3KjUQ3Rby8y0RiUw7aWFbyQvIw4aNGov/JVwrYWfB4mbnvRb9HlfQWiqnFemtqd8/cfL4wGtEKLt9fK0qvPiuTd2VHKrmqtCHlg==\n";
        String abc = "RDRjbGTgNfq/8Ws/fdDLxQ==";
        String urlEncode = URLEncoder.encode(encrypt,"UTF-8");
        System.out.println("编码：" + urlEncode);
        String decrypt = aesDecrypt(URLDecoder.decode(abc,"UTF-8"), KEY);
        System.out.println("解密后：" + decrypt);*/
        System.out.println(AES.aesEncrypt("test"));

    }
}
