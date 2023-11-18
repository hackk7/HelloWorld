package util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;


public class RSAUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RSAUtil.class);

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "publicKeyString";
    private static final String PRIVATE_KEY = "privateKeyString";

    public static final String PRIVATE_KEY2 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANJSY5fJCZhhKdlpynRu28BkI68I0+3OLECnt4mbOYAbiaDL9WCtj+zUEMuH2pM0chFZd6lS3Ayt/WRi6X8DjmoT/ajEht56rjbfxgNZDsyh05VdH3K0QexPSOkIW+hh9hdhmeehZGssgHKVB5fOrFssPHEHEYKzgCOhEqHlLuc1AgMBAAECgYEAqTB9zWx7u4juEWd45ZEIVgw4aGXBllt0Xc6NZrTn3JZKcH+iNNNqJCm0GQaAXkqiODKwgBWXzttoK4kmLHa/6D7rXouWN8PGYXj7DHUNzyOe3IgmzYanowp/A8gu99mJQJzyhZGQ+Uo9dZXAgUDin6HAVLaxF3yWD8/yTKWN4UECQQD8Q72r7qdAfzdLMMSQl50VxRmbdhQYbo3D9FmwUw6W1gy2jhJyPXMi0JZKdKaqhxMZIT3zy4jYqw8/0zF2xc5/AkEA1W+n24Ef3ucbPgyiOu+XGwW0DNpJ9F8D3ZkEKPBgjOMojM7oqlehRwgy52hU+HaL4Toq9ghL1SwxBQPxSWCYSwJAGQUO9tKAvCDh9w8rL7wZ1GLsG0Mm0xWD8f92NcrHE6a/NAv7QGFf3gAaJ+BR92/WMRPe9SMmu3ab2JS1vzX3OQJAdN70/T8RYo8N3cYxNzBmf4d59ee5wzQb+8WD/57QX5UraR8LS+s8Bpc4uHnqvTq8kZG2YI5eZ9YQ6XwlLVbVTQJAKOSXNT+XEPWaol1YdWZDvr2m/ChbX2uwz52s8577Tey96O4Z6S/YA7V6Fr7hZEzkNF+K0LNUd79EOB6m2eQq5w==";

    public static byte[] decryptBASE64(String key) {
        return Base64.decodeBase64(key);
    }

    public static String encryptBASE64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data
     *    加密数据
     * @param privateKey
     *    私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data
     *    加密数据
     * @param publicKey
     *    公钥
     * @param sign
     *    数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }

    public static byte[] decryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 解密<br>
     * 用私钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(String data, String key)
            throws Exception {
        return decryptByPrivateKey(decryptBASE64(data), key);
    }

    /**
     * 解密<br>
     * 用公钥解密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(String data, String key)
            throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data.getBytes());
    }

    /**
     * 加密<br>
     * 用私钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Key> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Key> keyMap) throws Exception {
        Key key = keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    public static Map<String, String> initKey() throws Exception {
        KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
        SecureRandom secrand = new SecureRandom();
        /**
         * 初始化随机产生器
         */
        secrand.setSeed("initSeed".getBytes());
        /**
         * 初始化密钥生成器
         */
        keygen.initialize(512, secrand);
        KeyPair keys = keygen.genKeyPair();

        byte[] pub_key = keys.getPublic().getEncoded();
        String publicKeyString = Base64.encodeBase64String(pub_key);

        byte[] pri_key = keys.getPrivate().getEncoded();
        String privateKeyString = Base64.encodeBase64String(pri_key);

        Map<String, String> keyPairMap = new HashMap<>();
        keyPairMap.put("publicKeyString", publicKeyString);
        keyPairMap.put("privateKeyString", privateKeyString);

        return keyPairMap;
    }

    /**
     * 私钥解密
     *
     * @param content   待解密的数据
     * @param priKey 私钥
     * @return
     * @throws Exception
     */
    public static String decryptByPriKey(String content, String priKey) throws Exception {
        byte[] decodedData = RSAUtil
                .decryptByPrivateKey(Base64.decodeBase64(content.replaceAll("@", "+")),
                        priKey);
        String outputStr = new String(decodedData);
        return outputStr;


    }


    /**
     * 私钥解密
     *
     * @param content   待解密的数据
     * @return
     * @throws Exception
     */
    public static String decryptByPriKey(String content){
        String outputStr = null;
        try {
            byte[] decodedData = RSAUtil
                    .decryptByPrivateKey(Base64.decodeBase64(content.replaceAll("@", "+")),
                            RSAUtil.PRIVATE_KEY2);
            outputStr = new String(decodedData);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("解密异常：" + e.getMessage());
        }
        return outputStr;
    }


    public static void main(String[] args) throws Exception {
//        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwjDm1HXDw8QH5ZtGMQIl2h/I8E+chOQA8aQ8xCR/+aHnROaN/ZU5Vmd2Zz7g6cAacR9BSm60+iSCYtvEGJKl0WqvbPGJkc8tedjNF1QqgWqkkuE6Udgw2OkEKJCxDg6PrAniR7Cc0io9G8bW4P8JDJjSbbafvMPDDFbVVUWJxxwIDAQAB";
        String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAngjk/aRDZCzrmrAPBc7l149I3etjRnMsN0CbyvdDiU4CS97Fm+nCZYcgQoKGkQA/N4+/saDWbKSJXfUULY4gKwIDAQABAkAWLNFU9fOu3s7AievRuNJviN+EpD7t58NQjXRO6ptDbMDm9C189wnVvBlGqvqW81qXp4AG1nMDWA2uji2buNHBAiEA/EO9q+6nQH83SzDEkJedFcUZm3YUGG6Nw/RZsFMOl3MCIQCgX/ThhfAHR1uNR/a3OpYB1UjUcF+Xv6Virm1JE3F2aQIhAL11EspB3pLt+FUcN0Rw2aUz9ltvfwAqZ4Y3yfRHLLpJAiAJzPNlGM9LUpQItT4hgmYKZKNXwCpHVsHfnvM0xQhpCQIgQdRnJtumxXQBgZZP2HxGHdkUHQvcKO9l1DpDwGTEQR4=";
//        String inputStr = "sign";
//        byte[] data = inputStr.getBytes();
//
//        byte[] encodedData = RSAUtil.encryptByPrivateKey(data, privateKey);
//
//        byte[] decodedData = RSAUtil
//                .decryptByPrivateKey(Base64.decodeBase64("bAbotLK7jQr7s0TXUo0S740mLYV3T0Ql51k/zx37kyUqxd4/uga0qky9fJ/aevd3L/lAwrbrazrUIcpWZEkqcA==".replaceAll("@", "+")),
//                        privateKey);
//        byte[] decodedData = RSAUtil
//                .decryptByPrivateKey(Base64.decodeBase64("bAbotLK7jQr7s0TXUo0S740mLYV3T0Ql51k/zx37kyUqxd4/uga0qky9fJ/aevd3L/lAwrbrazrUIcpWZEkqcA==".replaceAll("@", "+")),
//                        privateKey);
//        String outputStr = new String(decodedData);
//        System.err.println( "解密后: " + outputStr);
//        Map<String, String> stringStringMap = initKey();
//        String publicKey = stringStringMap.get("publicKeyString");
//        String privateKey = stringStringMap.get("privateKeyString");
//        System.out.println(publicKey);
//        System.out.println(privateKey);
      String key="fdyAbb+lqLxJMgHkOg/YL3E1zyu+hIAOhXKTnW7AKPywIhNgsOVy06WpyRs984uwCsh362nnvjO6C4wXgw2PSS0AL2jdWuiaGZ6ZPxJItO3xzmfft9UCc0QkvZvDCI2R/Gron3MKAKrdGZ1NwHD0EcpukwWBkoggVerVb9hjmZg=";
        key =  RSAUtil.decryptByPriKey(key);
        String user="NCIiAudfC4Ug9q4SgSoTdQ==";
        String p="Iu+S7ntdoL5eH6xGBW0gXQ==";
        System.out.println(key);
        System.out.println(AES.aesDecrypt(user, key));
        System.out.println(AES.aesDecrypt(p, key));
    }
}
