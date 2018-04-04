package com.wave.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
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


    /**
     * 文件MD5加密
     * @param in
     * @return
     */
    public static String encryptFile(InputStream in) {

        MessageDigest digest =null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");

            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        BigInteger bigint = new BigInteger(1, digest.digest());
        StringBuilder md5 = new StringBuilder(bigint.toString(16));

        return md5.toString();
    }
}
