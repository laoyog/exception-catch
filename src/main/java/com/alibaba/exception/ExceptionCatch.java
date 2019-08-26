package com.alibaba.exception;

import com.alibaba.bean.result.ResponseResult;
import com.alibaba.bean.resultcode.ResultCode;
import com.alibaba.bean.resultcode.CommonCode;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : laoyog
 * @Date : 2019/2/19 0019
 * @Description :异常捕获类
 */

//将对于控制器的全局配置放在同一个位置
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    /**
     * 异常类型,错误代码的映射
     * ImmutableMap 一旦创建不可改变,且线程安全
     */
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> exceptions;

    /**
     * 使用builder创建一个异常类型和错误代码的异常
     */
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    //加入一些基础的异常类型判断
    static {
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
        //...其他
    }

    /**
     * 用于捕获不可预知的异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception e){
        LOGGER.error("catch exception:{}\r\nexception",e.getMessage(),e);

        if(exceptions == null){
            exceptions = builder.build();
        }

        final ResultCode resultCode = exceptions.get(e.getClass());
        final ResponseResult responseResult;
        if(resultCode != null){
            responseResult = new ResponseResult(resultCode);
        }else{
            responseResult = new ResponseResult(CommonCode.INVALID_PARAM);
        }

        return responseResult;
    }

    /**
     * 捕获自定义异常
     * 注解@ExceptionHandler 用于全局处理控制器里的异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(CustomizeException.class)
    public ResponseResult customizeException(CustomizeException e) {
        LOGGER.error("catch exception:{}\r\nexception", e.getMessage(), e);

        ResultCode resultCode = e.getResultCode();
        return new ResponseResult(resultCode);
    }

}
