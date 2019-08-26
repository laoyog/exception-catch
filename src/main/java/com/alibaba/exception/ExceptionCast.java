package com.alibaba.exception;

import com.alibaba.bean.resultcode.ResultCode;

/**
 * @Author : laoyog
 * @Date : 2019/2/19 0019
 * @Description :异常捕获/抛出类
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomizeException(resultCode);
    }

}
