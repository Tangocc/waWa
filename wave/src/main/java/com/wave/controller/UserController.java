package com.wave.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tango
 * @create 2018-04-02 下午7:42
 * @desc ${DESCRIPTION}
 **/
@Controller
public class UserController {


    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    @ResponseBody
    public Object login(){

        return "index";
    }
}
