package com.alibaba.dao;

import com.alibaba.bean.domain.Product;
import org.apache.ibatis.annotations.*;

/**
 * @Author : laoyog
 * @Date : 2019/2/18 0018
 * @Description :
 */

@Mapper
public interface ProductMapper {

    @Insert(value = "insert into product(id_code,name,type) values (#{idCode},#{name},#{type})")
    int add(Product product);

    @Select("select * from product where id = #{id}")
    Product findById(Long id);

    @Update("update product set id_code =#{idCode},name=#{name},type=#{type} where id = #{id}")
    void edit(Product product);

    /**
     * 根据idCode查询是否该识别号已存在
     * @param idCode
     * @return
     */
    @Select("select id from product where id_code = #{idCode}")
    Long findByIdCode(String idCode);
}
