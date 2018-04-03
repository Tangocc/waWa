package com.wave.controller.user;

import com.wave.bean.UserBean;
import com.wave.dto.ResponseDTO;
import com.wave.service.IUserService;
import com.wave.utils.MD5Util;
import com.wave.utils.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author tango
 * @create 2018-03-31 下午7:53
 * @desc ${DESCRIPTION}
 **/
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param way  登录方式  0 - 用户名登录  1 - 手机验证码登录
     * @return
     */
    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    @ResponseBody
    public Object logIn(String  username,String password,int way){

        logger.info(username+" login");

        UserBean userBean = iUserService.loadUserByName(username);

        //不存在该用户
        if(userBean ==null){
            return new ResponseDTO(ResponseCode.NO_SUCH_USER.getCode(),ResponseCode.NO_SUCH_USER.getMsg(),null);
        }

        String encryptPassword = MD5Util.encrypt(password);

        if(encryptPassword.equals(userBean.getPassword())){
            return new ResponseDTO(ResponseCode.LOG_IN_SUCCESS.getCode(),ResponseCode.LOG_IN_SUCCESS.getMsg(),null);
        }

        return new ResponseDTO(ResponseCode.PASSWORD_ERROR.getCode(),ResponseCode.PASSWORD_ERROR.getMsg(),null);
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.GET)
    @ResponseBody
    public Object register(UserBean userBean){

        String username = userBean.getUsername();

        boolean ret = validateUserName(username);
        //用户名已经被注册过
        if(ret){
            return new ResponseDTO(ResponseCode.USER_ALREADY_REGISTERED.getCode(),ResponseCode.USER_ALREADY_REGISTERED.getMsg(),userBean);
        }

        //验证用户名和密码等信息是否符合要求
        String userName = userBean.getUsername();
        String password = userBean.getPassword();

        //修改password
        String encryptPassword = MD5Util.encrypt(password);
        userBean.setPassword(encryptPassword);

        //添加入数据库
        iUserService.addUser(userBean);

        return new ResponseDTO(ResponseCode.REGISTER_SUCCESS.getCode(),ResponseCode.REGISTER_SUCCESS.getMsg(),null);
    }

    /**
     *  验证用户名是否已经注册
     * @param username
     * @return false - 未注册  true - 已经注册
     */
    private boolean validateUserName(String username){

       UserBean userBean = iUserService.loadUserByName(username);

       if(userBean == null){
           return false;
       }
       return  true;
    }


}
