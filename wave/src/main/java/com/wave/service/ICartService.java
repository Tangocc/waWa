package com.wave.service;

import com.wave.bean.CartItem;

/**
 * @author tango
 * @create 2018-03-30 下午7:02
 * @desc 购物车服务类
 **/
public interface ICartService {



    boolean addItemIntoCart(long uid, CartItem item);

    boolean deleteItemFromCart(long uid, CartItem item);

    boolean cleanAllItemFromCart(long uid);

    boolean updateItemInfoCart(long uid, CartItem item);

}
