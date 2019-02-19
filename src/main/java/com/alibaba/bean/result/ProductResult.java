package com.alibaba.bean.result;

import com.alibaba.bean.domain.Product;
import com.alibaba.bean.response.ResponseResult;
import com.alibaba.bean.response.ResultCode;
import lombok.Data;

/**
 * @Author : laoyog
 * @Date : 2019/2/18 0018
 * @Description :定义project接口的返回值
 *
 */
@Data
public class ProductResult extends ResponseResult {

    Product product;
    public ProductResult (ResultCode resultCode, Product product){
        super(resultCode);
        this.product = product;
    }
}
