package com.order.orderservice.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.common.util.JsonResult;


@FeignClient(value = "productService")

public interface  ProductFeignClient {

	@PostMapping(value = "/product/queryProductById", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public JsonResult<Map<String, Object>> queryProductById(@RequestParam("productId") Integer productId);

}
