package com.wave.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tango
 * @create 2018-03-30 下午7:51
 * @desc 订单相关的操作
 **/
@Controller
public class OrderController {


    @RequestMapping(value = "/order/commit",method = RequestMethod.POST)
    @ResponseBody
    public Object commitOrder(){

        return "";
    }

    @RequestMapping(value = "/order/cancel",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelOrder(){

        return "";
    }
}
