package com.alibaba.api;

import com.alibaba.bean.domain.Product;
import com.alibaba.bean.result.ProductResult;

/**
 * @Author : laoyog
 * @Date : 2019/2/18 0018
 * @Description :Product api接口  方便远程调用
 */
public interface ProductControllerApi {

    /**
     * 添加商品
     * @param product
     * @return
     */
    ProductResult add(Product product);

    /**
     * 修改商品
     * @param product
     * @return
     */
    ProductResult edit(Product product);

}
