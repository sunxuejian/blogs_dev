package com.smart.sh.server.service.handler;

import com.smart.sh.server.service.UserService;
import com.smart.sh.server.service.handler.AbstractCoreHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 孙雪键 on 2017/4/16.
 */

/**
 * 所有请求处理相同的逻辑在这实现
 */
@Component
public abstract class AbstractRequestHandler extends AbstractCoreHandler {
    @Autowired
    protected UserService userService;
}
