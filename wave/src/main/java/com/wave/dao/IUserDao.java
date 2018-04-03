package com.wave.dao;

import com.wave.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author tango
 * @create 2018-04-03 上午10:21
 * @desc ${DESCRIPTION}
 **/

@Repository
public interface IUserDao {

  UserEntity findUserByName(String username);


  boolean insertUser(UserEntity userEntity);


}
