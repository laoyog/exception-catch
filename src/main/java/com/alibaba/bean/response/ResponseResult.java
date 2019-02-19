package com.alibaba.bean.response;

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
public class ResponseResult {

    boolean success = true;
    int code = 10000;
    String message;

    /**
     * 只使用有参构造
     * @param resultCode
     */
    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }
}
