package com.smart.sh.server.web;

import com.smart.sh.server.mode.UserInfo;
import com.smart.sh.server.service.UserService;
import com.smart.sh.server.service.handler.CoreProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 孙雪键 on 2017/4/15.
 */
@Component
@RestController
public class HttpRequestIn {

    @Autowired
    private CoreProcess process;

    @RequestMapping(value = "/SaService",method = RequestMethod.POST)
    public String service(@RequestBody String content){
        return process.process(content);
    }
}
