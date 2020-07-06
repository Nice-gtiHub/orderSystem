package com.order.productservice.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.order.productservice.dao.entity.Product;

@Mapper
public interface ProductMapper {
	
    Product findByProductId(Integer productId);

}
