package com.wave.service.impl;

import com.wave.bean.UserBean;
import com.wave.dao.IUserDao;
import com.wave.entity.UserEntity;
import com.wave.service.IUserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao iUserDao;


    public UserBean loadUserByName(String userName) {

        UserEntity userEntity = iUserDao.findUserByName(userName);
        if(userEntity ==null){
            return null;
        }

        UserBean userBean = new UserBean();

        BeanUtils.copyProperties(userEntity,userBean);

        return userBean;
    }

    public boolean addUser(UserBean userBean) {

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userBean,userEntity);
        iUserDao.insertUser(userEntity);
        return true;
    }

}
