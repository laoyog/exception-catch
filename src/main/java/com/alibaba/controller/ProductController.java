package com.alibaba.controller;

import com.alibaba.api.ProductControllerApi;
import com.alibaba.bean.domain.Product;
import com.alibaba.bean.result.ResponseResult;
import com.alibaba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : laoyog
 * @Date : 2019/2/15 0015
 * @Description :接口
 */

@RestController
@RequestMapping("/product")
public class ProductController implements ProductControllerApi {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    @Override
    public ResponseResult add(@RequestBody Product product) {
        return productService.add(product);
    }

    @PostMapping("/edit")
    @Override
    public ResponseResult edit(@RequestBody Product product) {
        return productService.edit(product);
    }
}
