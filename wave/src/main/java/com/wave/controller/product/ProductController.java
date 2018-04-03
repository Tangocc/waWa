package com.wave.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tango
 * @create 2018-03-30 下午7:51
 * @desc 产品相关的操作
 **/
@Controller
public class ProductController {

    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addProduct(){
        return "";

    }

    @RequestMapping(value = "/product/delete",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteProduct(){

        return "";
    }

    @RequestMapping(value = "/product/update",method = RequestMethod.POST)
    @ResponseBody
    public  Object updateProduct(){

        return "";
    }

    @RequestMapping(value = "/product/search",method = RequestMethod.POST)
    @ResponseBody
    public Object searchProduct(){

        return "";
    }

}
