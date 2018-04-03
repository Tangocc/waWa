package com.wave.service.impl;

import com.wave.bean.UserBean;
import com.wave.dao.IUserDao;
import com.wave.entity.UserEntity;
import com.wave.service.IUserService;
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

        return convertEntity2Bean(userEntity);
    }

    public boolean addUser(UserBean userBean) {

        UserEntity userEntity = convertBean2Entity(userBean);
        iUserDao.insertUser(userEntity);
        return true;
    }



    private UserBean convertEntity2Bean(UserEntity userEntity){

        UserBean userBean = new UserBean();

        userBean.setUsername( userEntity.getUserName());
        userBean.setPassword( userEntity.getPassword());

        return userBean;
    }


    private UserEntity convertBean2Entity(UserBean userBean){

        UserEntity userEntity = new UserEntity();

        userEntity.setUserName( userBean.getUsername());

        return userEntity;

    }
}
