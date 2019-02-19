package com.alibaba.bean.result;

import com.alibaba.bean.response.ResultCode;
import lombok.ToString;

/**
 * @author laoyog
 * @date 2019/2/15 0015
 * @Desc 自定义异常的错误代码
 *      每个业务操作，都使用异常代码去标识
 */
@ToString
public enum CustomCode implements ResultCode {

    /**
     * 商品识别码已存在
     */
    IdCODE_EXIST(false,20001,"商品识别码已存在");

    boolean success;
    int code;
    String message;

    CustomCode(boolean success, int code, String message) {
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
