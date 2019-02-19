package com.alibaba.bean.response;

/**
 * @Author : laoyog
 * @Date : 2019/2/15 0015
 * @Description :定义返回结果的接口，具体使用它的实现类
 */
public interface ResultCode {

    boolean success();

    int code();

    String message();
}
