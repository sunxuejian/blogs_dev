package com.smart.sh.server.service.handler;

import com.smart.sh.server.exception.SaExceptionCode;
import com.smart.sh.server.exception.SmartAppException;
import com.smart.sh.server.mode.enume.SaRequestType;
import com.smart.sh.server.utils.Constant;
import com.smart.sh.server.utils.HandlerMap;
import com.smart.sh.server.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
@Component
public class CoreProcess {

    @Autowired
    private HandlerMap handlerMap;


    public String process(String content){
        if (StringUtils.isEmpty(content)){
            throw new SmartAppException(SaExceptionCode.OTHER_ERROR,"请求数据不能为空:"+content);
        }

        Map map = JsonUtils.readValue(content);

        if (!map.containsKey("requestType")){
            return "";
        }

        SaRequestType type = SaRequestType.convert((String) map.get("requestType"));
        if (null == type){
            return "未知的请求类型.....";
        }

        //校验用户基本信息。
        String str = validateUser(map);

        if(StringUtils.isNotEmpty(str)){
            return str;
        }

        Object obj = null;
        try{
            Handler handler = handlerMap.handler(type);
            if (handler != null){
                obj = handler.processEvent(map);
            }
            return generatorSuccessResult(obj);
        }catch (Exception exception){
            return generatorFailResult(exception);
        }
    }


    private String validateUser(Map map) {
        return "";
    }

    private String generatorSuccessResult(Object object){
        Map<String,Object> result = new LinkedHashMap<String,Object>();
        List list;
        result.put("code",Constant.SUCCESS_CODE);
        result.put("status", Constant.SUCCESS);
        if(object instanceof List){
            list = (List) object;
        }else {
            list = new ArrayList();
            list.add(object);
        }
        result.put("result",list);
        result.put("resultSize",list.size());
        return JsonUtils.writeValueAsString(result);
    }


    private String generatorFailResult(Exception exception) {
        Map<String,Object> result = new LinkedHashMap<String,Object>();
        result.put("status", Constant.FAIL);
        if(exception instanceof SmartAppException){
            SmartAppException sa = (SmartAppException) exception;
            result.put("code", sa.getCode());
            result.put("errorMessage",sa.getMessage());
        }else{
            result.put("code", Constant.FAIL_CODE);
        }
        return JsonUtils.writeValueAsString(result);
    }
}
