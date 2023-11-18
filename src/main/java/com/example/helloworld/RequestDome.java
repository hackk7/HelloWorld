package com.example.helloworld;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import util.AES;

import java.net.URLEncoder;
import java.util.Base64;
import java.util.Random;

/**
 * @author 马克
 * @date 2023/4/4
 */
public class RequestDome {

    // RSA 公钥加密 私钥解密
    // AES 对称加密 加密解密 秘钥相同
    public static String RSAPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSUmOXyQmYYSnZacp0btvAZCOvCNPtzixAp7eJmzmAG4mgy/VgrY/s1BDLh9qTNHIRWXepUtwMrf1kYul/A45qE/2oxIbeeq4238YDWQ7ModOVXR9ytEHsT0jpCFvoYfYXYZnnoWRrLIBylQeXzqxbLDxxBxGCs4AjoRKh5S7nNQIDAQAB";
    public static String RSAPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANJSY5fJCZhhKdlpynRu28BkI68I0+3OLECnt4mbOYAbiaDL9WCtj+zUEMuH2pM0chFZd6lS3Ayt/WRi6X8DjmoT/ajEht56rjbfxgNZDsyh05VdH3K0QexPSOkIW+hh9hdhmeehZGssgHKVB5fOrFssPHEHEYKzgCOhEqHlLuc1AgMBAAECgYEAqTB9zWx7u4juEWd45ZEIVgw4aGXBllt0Xc6NZrTn3JZKcH+iNNNqJCm0GQaAXkqiODKwgBWXzttoK4kmLHa/6D7rXouWN8PGYXj7DHUNzyOe3IgmzYanowp/A8gu99mJQJzyhZGQ+Uo9dZXAgUDin6HAVLaxF3yWD8/yTKWN4UECQQD8Q72r7qdAfzdLMMSQl50VxRmbdhQYbo3D9FmwUw6W1gy2jhJyPXMi0JZKdKaqhxMZIT3zy4jYqw8/0zF2xc5/AkEA1W+n24Ef3ucbPgyiOu+XGwW0DNpJ9F8D3ZkEKPBgjOMojM7oqlehRwgy52hU+HaL4Toq9ghL1SwxBQPxSWCYSwJAGQUO9tKAvCDh9w8rL7wZ1GLsG0Mm0xWD8f92NcrHE6a/NAv7QGFf3gAaJ+BR92/WMRPe9SMmu3ab2JS1vzX3OQJAdN70/T8RYo8N3cYxNzBmf4d59ee5wzQb+8WD/57QX5UraR8LS+s8Bpc4uHnqvTq8kZG2YI5eZ9YQ6XwlLVbVTQJAKOSXNT+XEPWaol1YdWZDvr2m/ChbX2uwz52s8577Tey96O4Z6S/YA7V6Fr7hZEzkNF+K0LNUd79EOB6m2eQq5w==";
    static String publicKeyString = "ZeTGMbbEe8MUgngV5cBgF5nEK08N4mS8VE5c0pm45I73Mh+TFyv/XhpIG5QIUdZqWaJXDUWuBZvIoVTNVVd8RMIIpJQsQ3D+R2b7qNC6sK9+xKXUgBDe4NHflrMGOcqX2giToGocEyXVlWjY2YP7hKVI91z9jHcZaCoCMwPF8xY=";

    public static void main(String[] args) throws Exception {
        // AES 加密
        String AESKey = random(16);
        String params = "{uri: \"/signForIntegrals/sign\"}";
        String paramsEnc = AES.aesEncrypt(params, AESKey);

        // RSA 解密 AES 秘钥
        RSA rsa = new RSA(null, RSAPublicKey);
        byte[] encrypt = rsa.encrypt(AESKey, KeyType.PublicKey);
        String encoded = Base64.getEncoder().encodeToString(encrypt);

        String encode = URLEncoder.encode(paramsEnc, "UTF-8");
        String encode1 = URLEncoder.encode(encoded, "UTF-8");

        System.out.println("param = \n" + encode);
        System.out.println("random = \n" + encode1);
    }

    private static String random(int digit) {
        String library = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        int min = 0;
        int max = 61;
        Random random = new Random();
        for (int i = 0; i < digit; i++) {
            int randomNum = random.nextInt(max + min) + min;
            result.append(library.substring(randomNum, randomNum + 1));
        }
        return result.toString();
    }
}