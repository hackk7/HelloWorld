package util;

/**
 * @Author: liyafei
 * @Version V1.0
 * @Description ${Description}
 * @Date: 2020/4/20 17:54
 */

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAEncrypt {
    private static final String defaultCharset = "UTF-8";
    private static final String KEY_RSA = "RSA";
    public static String privateKey="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAngjk/aRDZCzrmrAPBc7l149I3etjRnMsN0CbyvdDiU4CS97Fm+nCZYcgQoKGkQA/N4+/saDWbKSJXfUULY4gKwIDAQABAkAWLNFU9fOu3s7AievRuNJviN+EpD7t58NQjXRO6ptDbMDm9C189wnVvBlGqvqW81qXp4AG1nMDWA2uji2buNHBAiEA/EO9q+6nQH83SzDEkJedFcUZm3YUGG6Nw/RZsFMOl3MCIQCgX/ThhfAHR1uNR/a3OpYB1UjUcF+Xv6Virm1JE3F2aQIhAL11EspB3pLt+FUcN0Rw2aUz9ltvfwAqZ4Y3yfRHLLpJAiAJzPNlGM9LUpQItT4hgmYKZKNXwCpHVsHfnvM0xQhpCQIgQdRnJtumxXQBgZZP2HxGHdkUHQvcKO9l1DpDwGTEQR4=";
    //    public static String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwT+YeOkuYLSXfFi9xBxlfL5NIJ7jSWj+OfzdWSNutGhoCj8pc105vi55pjpFZn/dfvurEyt+eHtTq2mBLcF8Gaj6NyRkZh6c1MOMyXsyrQONKcii1/toOSbym36xRpytg3qH8QN9Af4+NVVFiTGB4mXy5YNsp52u1+McPTWW+pwIDAQAB";
//    public static String privateKey="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJyBtoZNRsDfHoeU7x0PyZZSR153aNFn2VzdGR4LopOyT/XvRvps+EL2lpho6zG2B1eu/Giv82j+Xe+zPCWzMkgn09JhA0vP9p/2sIutqV48mnHmTwNxRIUTEEXB83yApeV4bsdvZFLvBlFKA8cMG6DbpSHzzkDEoloUVL5oNP8DAgMBAAECgYBOMeDoKSP4qYGvbBIsCv9FQ8a0xCRyu9g2NaGfCWEpOiYJUou8A0Xm7x0++OzJ4ZC5low2IfMTukNkx8B9dZLhAiF9iCuR2ocnn1mdB/zTKldP9suZIi494FwZf/5f0LC/BVsx3q7v0M/A8uX3kCubPbu0J0cn7G8tdNCaQJS5wQJBAM9FdY4LCxrwImmPKU4alsHr5h5mrlrqgARswOR2f4L9Grngo+xUw7H7yDCVKkOnqLg5W4O+y2RZvqZXaZLLfWcCQQDBTQE+ejUGo8a92AvcImzbW7ej6nWg5T8MTyFSozSJ8fkLCAvq4WmWfCridnlViBUWK2aYIFoj/xndtila5JQFAkBqm2M3R97SYCiS+ptYHLzlyRt3D4EmKe7mV7luyLQU/3G7oRsu9voglUwGEPLIEXfqKTY0sPGUD8TLcbJPWnKJAkAs9MXXTADNHIX6XSbU+cSrd7dMDhlxZB+3syei2oY7luU+5Y4wAGDYOOSYaslpVQ7iaxGfS9brDEdtwxH3K7YpAkASNz6qMVTXFjxKe9DNsfxEA3ViKJzdCBH9N4YqMnW1L7vlpJHK4iNkkbtpoyVq9Fuv7vYS8UW960s0fMfCZGJx";
    public static void main(String[] args) throws Exception {
        String messageDe = decrypt("bAbotLK7jQr7s0TXUo0S740mLYV3T0Ql51k/zx37kyUqxd4/uga0qky9fJ/aevd3L/lAwrbrazrUIcpWZEkqcA==",privateKey);
        System.out.println("还原后的字符串为:" + messageDe);
    }
    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public static Map<Integer, String> genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_RSA);
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        Map<Integer, String> keyMap = new HashMap<Integer, String>();
        keyMap.put(0,publicKeyString);  //0表示公钥
        keyMap.put(1,privateKeyString);  //1表示私钥
        return keyMap;
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
        if (StringUtils.isEmpty(str)){
            return str;
        }
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance(KEY_RSA);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes(defaultCharset)));
        return outStr;
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
        if (StringUtils.isEmpty(str)){
            return str;
        }
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes(defaultCharset));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_RSA).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance(KEY_RSA);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }
}
