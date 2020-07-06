package com.order.productservice.service;

import javax.validation.Valid;

import com.order.productservice.dao.entity.Product;

public interface ProductService {
	
    Product queryProductById(@Valid Integer productId);
}
