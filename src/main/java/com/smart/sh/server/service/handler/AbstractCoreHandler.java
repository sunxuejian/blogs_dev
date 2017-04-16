package com.smart.sh.server.service.handler;

import com.smart.sh.server.mode.enume.SaRequestType;
import com.smart.sh.server.utils.HandlerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
@Component
public abstract class AbstractCoreHandler implements Handler {
    @Autowired
    private HandlerMap map;

    @Override
    public String validate() {
        return null;
    }

    protected abstract SaRequestType getSaRequestType();

    @PostConstruct
    public void init(){
        map.put(getSaRequestType(),this);
    }
}
