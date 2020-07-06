package com.order.productservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.util.Code;
import com.order.common.util.JsonResult;
import com.order.productservice.dao.entity.Product;
import com.order.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = "queryProductById", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public JsonResult<Map<String, Object>> queryProductById(Integer productId) {

		if (null == productId || productId <= 0) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		Product product = productService.queryProductById(productId);
		if (null == product) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_NO_DATA, "no data");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productId", product.getProductId());
		map.put("productName", product.getProductName());
		map.put("productPrice", product.getProductPrice().toString());
		return new JsonResult<Map<String, Object>>(map, "success");

	}
}