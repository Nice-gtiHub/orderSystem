package com.order.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.order.productservice.dao.entity.Product;
import com.order.productservice.dao.mapper.ProductMapper;
import com.order.productservice.service.ProductService;

@Service
@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductMapper productMapper;

	public Product queryProductById(Integer productId) {
		return productMapper.findByProductId(productId);
	}

}

