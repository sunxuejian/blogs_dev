package com.smart.sh.server.service.handler;

import java.util.Map;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
public interface Handler {

    String validate();

    Object processEvent(Map map);
}
