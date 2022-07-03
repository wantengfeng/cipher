package com.wonder.hash;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/**
 * 用户口令加盐hash存储，抵御彩虹表攻击
 * 例如：HmacMD5 ≈ md5(secure_random_key, input)
 * @author jameswan
 * @date 2022/7/3
 */
public class HmacDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGenerator.generateKey();
        byte[] skey = key.getEncoded();
        // 打印随机生成的key
        System.out.println(Arrays.toString(skey));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("Hello World".getBytes(StandardCharsets.UTF_8));
        byte[] result = mac.doFinal();
        System.out.println(Arrays.toString(result));
    }

}
