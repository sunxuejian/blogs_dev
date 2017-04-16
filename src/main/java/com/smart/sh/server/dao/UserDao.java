package com.smart.sh.server.dao;

import com.smart.sh.server.mode.UserInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
@Component
public class UserDao {

    @Autowired
    private SqlSessionTemplate sessionTemplate;


    public UserInfo findUserInfoByUserId(String userId){
        return sessionTemplate.selectOne("com.smart.sh.mapper.user.getUserInfo",userId);
    }
}
