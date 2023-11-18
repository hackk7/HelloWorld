package util.other;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

/**
 * RSA 加密
 * @author ZH
 *
 */
public class RSAEncrypt2 {

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDdYAeZoU41pZrIR87tYElenpqRgLIA+MfuwgODYmhiTkaNXp03js4AU1NtDFoN1oY5GI4Pej2t6kbMMN8SCypanISTfZL81HXb1wYaC7Czfle+el82iBspWVgHYThBBoEewgHdok/TB+3X55Fr8EwBZFL35dt/SckrQBFTip0fQQIDAQAB";
    private static String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAN1gB5mhTjWlmshHzu1gSV6empGAsgD4x+7CA4NiaGJORo1enTeOzgBTU20MWg3WhjkYjg96Pa3qRsww3xILKlqchJN9kvzUddvXBhoLsLN+V756XzaIGylZWAdhOEEGgR7CAd2iT9MH7dfnkWvwTAFkUvfl239JyStAEVOKnR9BAgMBAAECgYEAiB8GTVc8agxcco6FFL1CICZSUOnbinFvLsaptl4KZXhQNZlZ/tGWpeiWwdT4gs3IVs9cevPlfU0zH1dlswiej1gnMuSo9UnT8LMq0nLiiAxnguLt4VQvlGECTk6/jOxH0gQEoChrA8MyOnAiVgzYdxaoCwaMtB9264Blbltuq+ECQQDxjLYB4DOY2XKnm2Pdh3CYnpQi0LGDY16Psbvqbj2D8a6FYR6EpmfvdhYXXhNU9Jp8uMETx/oEfALnDEzL/bsFAkEA6p5Zb/wo5iwkogJnN+zkbVsMeA1XvHT1XAyGvY8M3/pdXtOeHQtjW0+IxtTxuV+irRzNPETtalSyzV6H3RIgDQJATD79aMQrpVDmVy++qzvId/R+kCrODco9HCCfT5Wyx0Zvr1yDtJ2Oa1EcEg45DfUUGtB66dKTAf1fMS15xF54PQJBAMjcFj+8Rpt/0UDuA8YqRgmlOFCTQ7iw/Nn4U2Z30JL0OfmT/DprZH1o4vUum1+Tk6bXEJH3hLZSmt0df/1wpgUCQQDcKSWQpsLkGEAyL1q2X3mTSnpCd1N4zbTYwpORZfMgfPt4mRnmPEfjuolTUrZoMriJsG0ssrD4NcHbhRJXqX1j";

    public static void main(String[] args) throws Exception {
        //加密字符串
        String message = "中文测试，。；符号测试'\"";

        String messageEn = encrypt(message);
        System.out.println(message + "\t\n加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn);
        System.out.println("还原后的字符串为:" + messageDe);
    }


    /**
     * RSA公钥加密
     *
     * @param str 加密字符串
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     * @param: publicKey
     * 公钥
     */
    public static String encrypt(String str) throws Exception {
        if (str == null) {
            return "";
        }
        if (str.equals("")) {
            return "";
        }
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str 加密字符串
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     * @param: privateKey
     * 私钥
     */
    public static String decrypt(String str) throws Exception {
        if (str.equals("") || str == null) {
            return "";
        }
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte), "UTF-8");
        return outStr;
    }

}