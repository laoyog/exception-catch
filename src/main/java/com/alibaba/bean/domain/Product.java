package com.alibaba.bean.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

/**
 * @Author : laoyog
 * @Date : 2019/2/15 0015
 * @Description :商品
 *      字段中,商品识别码idCode唯一且非空
 */

@Data
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Product {
    private Long id;

    //商品识别码
    private String idCode;

    //商品名称
    private String name;

    //商品类型
    private String type;

    //其他......
}
