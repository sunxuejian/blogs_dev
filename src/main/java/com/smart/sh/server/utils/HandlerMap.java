package com.smart.sh.server.utils;

import com.smart.sh.server.mode.enume.SaRequestType;
import com.smart.sh.server.service.handler.Handler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 孙雪键 on 2017/4/16.
 */

@Component
public class HandlerMap {

    private Map<SaRequestType,Handler> map = new ConcurrentHashMap<SaRequestType,Handler>();

    public void put(SaRequestType type,Handler handler){
        map.put(type,handler);
    }

    public Handler handler(SaRequestType type){
        if (map.containsKey(type)){
            return map.get(type);
        }
        return null;
    }
}
