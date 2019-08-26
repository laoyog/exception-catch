package com.alibaba.bean.result;

import com.alibaba.bean.resultcode.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author : laoyog
 * @Date : 2019/2/15 0015
 * @Description :
 */

@Data
@ToString
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {

    boolean success = true;
    int code = 10000;
    String message;
    T t;

    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResponseResult(ResultCode resultCode,T t) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.t = t;
    }
}
