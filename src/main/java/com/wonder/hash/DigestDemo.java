package com.wonder.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 功能：验证数据完整性，具有防篡改检测的功能
 * 缺点：没有办法抵制彩虹表的攻击，可以通过加盐来处理。digest = md5(salt+message)
 * @author jameswan
 * @date 2022/7/3
 */
public class DigestDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 可以查看java doc查看支持哪些算法
        MessageDigest md = MessageDigest.getInstance("md5");
        md.update("hello".getBytes(StandardCharsets.UTF_8));
        md.update("world".getBytes(StandardCharsets.UTF_8));
        // 不同的算法，输出的byte length不一样
        byte[] result = md.digest();
        System.out.println(Arrays.toString(result));
    }
}
