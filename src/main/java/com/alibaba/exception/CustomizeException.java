package com.alibaba.exception;

import com.alibaba.bean.response.ResultCode;

/**
 * @Author : laoyog
 * @Date : 2019/2/19 0019
 * @Description :可预知异常处理   自定义异常类型
 */
public class CustomizeException extends RuntimeException {

    private ResultCode resultCode;

    public CustomizeException(ResultCode resultCode){
        super("错误代码:"+resultCode.code()+",错误信息:"+resultCode.message());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return this.resultCode;
    }
}
