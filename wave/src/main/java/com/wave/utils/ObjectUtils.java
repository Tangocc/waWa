package com.wave.utils;

/**
 * @author tango
 * @create 2018-04-03 下午8:54
 * @desc ${DESCRIPTION}
 **/
public class ObjectUtils {

    public static boolean isEmpty(Object obj){

        if(obj == null || "".equals(obj)){
            return true;
        }

        return false;

    }
}
