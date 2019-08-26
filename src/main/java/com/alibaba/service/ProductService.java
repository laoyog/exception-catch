package com.alibaba.service;

import com.alibaba.bean.domain.Product;
import com.alibaba.bean.result.ResponseResult;
import com.alibaba.bean.resultcode.CommonCode;
import com.alibaba.dao.ProductMapper;
import com.alibaba.exception.ExceptionCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : laoyog
 * @Date : 2019/2/18 0018
 * @Description :
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 添加商品
     * @param product
     * @return
     */
    public ResponseResult add(Product product) {
        //先根据识别号查重
        Long id = productMapper.findByIdCode(product.getIdCode());
        //说明该识别号已存在,抛出异常
        if(id != null){
            ExceptionCast.cast(CommonCode.IdCODE_EXIST);
        }

        int count= productMapper.add(product);
        System.out.println(count);

        return new ResponseResult(CommonCode.SUCCESS,product);

    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    public ResponseResult edit(Product product) {
        Product one = productMapper.findById(product.getId());
        if(one != null){

            productMapper.edit(product);
        }

        return new ResponseResult(CommonCode.SUCCESS,product);
    }
}
