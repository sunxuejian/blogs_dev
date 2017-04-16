package com.smart.sh.server.service;

import com.smart.sh.server.dao.UserDao;
import com.smart.sh.server.exception.SaExceptionCode;
import com.smart.sh.server.exception.SmartAppException;
import com.smart.sh.server.mode.UserInfo;
import com.smart.sh.server.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by 孙雪键 on 2017/4/16.
 */

@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserInfo getUserInfo(Map map){
        if (map.containsKey(Constant.USERID)){
            String userId = (String) map.get(Constant.USERID);
            return userDao.findUserInfoByUserId(userId);
        }
        throw new SmartAppException(SaExceptionCode.OTHER_ERROR,"handler fail ,argument userId not exist");
    }
}
