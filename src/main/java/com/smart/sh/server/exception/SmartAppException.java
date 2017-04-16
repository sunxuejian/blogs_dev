package com.smart.sh.server.exception;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
public class SmartAppException extends RuntimeException{
    private String message;

    private SaExceptionCode code;

    public SmartAppException(SaExceptionCode code,String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code.getCode();
    }
}
