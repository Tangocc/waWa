package com.wave.controller.cart;

import com.wave.bean.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tango
 * @create 2018-03-30 下午7:28
 * @desc  购物车相关操作
 **/
@Controller
public class CartController {


    @RequestMapping(value = "/cart/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addItemIntoCart(long uid, CartItem cartItem){


        return "";
    }

    @RequestMapping(value = "/cart/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteItemFromCart(long uid, CartItem cartItem){

        return "";
    }


    @RequestMapping(value = "/cart/clean",method = RequestMethod.POST)
    @ResponseBody
    public Object cleanAllItemFromCart(long uid, CartItem cartItem){

        return "";
    }

    @RequestMapping(value = "/cart/update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateItemInfoCart(long uid, CartItem cartItem){

        return "";
    }
}
