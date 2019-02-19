package com.alibaba.bean.result;

import com.alibaba.bean.response.ResultCode;
import lombok.ToString;

/**
 * @Author : laoyog
 * @Date : 2019/2/15 0015
 * @Description :通用返回代码
 *      如返回成功，不可预知的异常等
 */
@ToString
public enum CommonCode implements ResultCode {

    /**
     * 参数异常
     */
    INVALID_PARAM(false,10001,"非法参数"),
    SUCCESS(true,10000,"操作成功");

    boolean success;
    int code;
    String message;
    CommonCode(boolean success,int code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
