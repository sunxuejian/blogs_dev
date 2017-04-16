package com.smart.sh.server.service.handler.web_server;

import com.smart.sh.server.mode.enume.SaRequestType;
import com.smart.sh.server.service.handler.AbstractRequestHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
@Component
public class GetUserInfoHandler extends AbstractRequestHandler{

    @Override
    protected SaRequestType getSaRequestType() {
        return SaRequestType.GET_USER_INFO;
    }

    @Override
    public Object processEvent(Map map) {
        return userService.getUserInfo(map);
    }
}
