package com.smart.sh.server.exception;

/**
 * Created by 孙雪键 on 2017/4/16.
 */
public enum  SaExceptionCode {
    OTHER_ERROR("1"),

    DATABASE_ERROR("2"),

    JSONPARSE_ERROR("3");

    private String code;

    SaExceptionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
