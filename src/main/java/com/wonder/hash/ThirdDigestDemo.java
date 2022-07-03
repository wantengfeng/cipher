package com.wonder.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 第三方算法库，提供了Java标准库中没有的的算法
 * @author jameswan
 * @date 2022/7/3
 */
public class ThirdDigestDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 通过该方法注册
        Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        byte[] result = md.digest();
        System.out.println(Arrays.toString(result));
    }

}
