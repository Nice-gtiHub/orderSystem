package com.order.orderservice.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.common.util.JsonResult;

@FeignClient(value = "userService")

public interface  UserFeignClient {

	 @RequestMapping(value = "/user/queryUserByuserId", method = RequestMethod.POST)
	 public JsonResult<Map<String, Object>> queryUserByuserId(@RequestParam("userId") Integer userId);
	 
	 
	 @RequestMapping(value = "/user/queryAddressByAddressIdAndUserId", method = RequestMethod.POST)
	 public JsonResult<Map<String, Object>> queryAddressByAddressIdAndUserId(@RequestParam("userId")Integer userId, @RequestParam("addressId")Integer addressId);
}
