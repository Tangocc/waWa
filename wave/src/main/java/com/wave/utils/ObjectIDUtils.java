package com.wave.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tango
 * @create 2018-04-03 下午9:36
 * @desc 生成数据库中userID productID 等信息
 *
 * userID跟日期绑定
 * productID/cartID/orderID 跟userID 绑定
 *
 **/
public class ObjectIDUtils {

    private static AtomicInteger userID;

    private static AtomicInteger productID;

    private static AtomicInteger cartID;

    private static AtomicInteger orderID;


    public static Long nextUserID(){

        return 0L;
    }


    public static Long nextProductID(){

        return 0L;
    }


    public static Long nextCartID(){

        return 0L;
    }


    public static Long nextOrderID(){

        return 0L;
    }

}
