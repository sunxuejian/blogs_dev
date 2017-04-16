package com.smart.sh.server.mode.enume;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
public enum SaRequestType {
    LOGIN("login"),
    GET_USER_INFO("getUserInfo"),
    MAIN("main");

    private String display;

    private static Map<String,SaRequestType> map = new HashMap<String, SaRequestType>();

    SaRequestType(String display) {
        this.display = display;
    }

    static {
        SaRequestType[] values= SaRequestType.values();
        for(SaRequestType type : values){
            map.put(type.getDisplay(),type);
        }
    }

    public static SaRequestType convert(String type){
        if(map.containsKey(type)){
            return map.get(type);
        }
        return null;
    }

    public String getDisplay() {
        return display;
    }
}
