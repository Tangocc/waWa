package com.wave.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5Util {


    private static Logger logger = LoggerFactory.getLogger(MD5Util.class);
    /**
     * MD5加密
     *
     * @param msg
     * @return
     */
    public static String encrypt(String msg) {

        MessageDigest md5 = null;
        //确定计算方法
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {

            logger.warn("msg" +"can not encrypt!");
            return msg;
        }
        BASE64Encoder base64en = new BASE64Encoder();

        //加密后的字符串
        String encryptMsg = base64en.encode(md5.digest(msg.getBytes()));
        return encryptMsg;

    }


    /**
     * MD5解密(未实现)
     * @param msg
     * @return
     */
    public static String decrypt(String msg) {
        return "";
    }


}
