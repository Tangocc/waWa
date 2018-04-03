package com.wave.service;


import com.wave.bean.UserBean;

public interface IUserService {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
   UserBean loadUserByName(String userName);

    /**
     * 添加用户
     * @param userEntity
     *
     * @return
     */
   boolean addUser(UserBean userEntity);

}
