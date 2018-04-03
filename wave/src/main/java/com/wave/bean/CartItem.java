package com.wave.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author tango
 * @create 2018-03-30 下午7:13
 * @desc 购物车条目信息
 **/
public class CartItem implements Serializable{

    /**
     * 产品ID
     */
    private long productID;

    /**
     * 购物车ID
     */
    private long cartID;

    /**
     * 颜色
     */
    private String color;

    /**
     * 尺码
     */
    private String size;

    /**
     * 数量
     */
    private int quantity;

    /**
     * 小计金额
     */
    private BigDecimal totalMoney;

    /**
     * 类目状态
     *
     * 0 - 无效
     * 1 - 有效
     *
     *
     */
    private int status;

}
