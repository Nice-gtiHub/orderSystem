package com.order.userservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.util.Code;
import com.order.common.util.JsonResult;
import com.order.userservice.dao.entity.Address;
import com.order.userservice.dao.entity.User;
import com.order.userservice.service.AddressService;
import com.order.userservice.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Valid
	@PostMapping(value = "/queryUserByuserId", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public JsonResult<Map<String, Object>> queryUserByuserId(Integer userId) {
		System.out.println(userId);
		if (null == userId || userId <= 0) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		User user = userService.queryUserById(userId);
		if (null == user) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_NO_DATA, "no data");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		map.put("userName", user.getUserName());
		map.put("userPassword", user.getUserPwd());
		return new JsonResult<Map<String, Object>>(map, "success");

	}

	@Valid
	@PostMapping(value = "/queryAddressByAddressIdAndUserId", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public JsonResult<Map<String, Object>> queryAddressByAddressIdAndUserId(Integer userId, Integer addressId) {
		if (null == userId || userId <= 0) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		if (null == addressId || addressId <= 0) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		Address address = addressService.queryAddressByAddressIdAndUserId(addressId, userId);

		if (null == address) {
			return new JsonResult<Map<String, Object>>(Code.ERROR_NO_DATA, "no data");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("addressId", address.getAddressId());
		map.put("userId", address.getUserId());
		map.put("addressCountry", address.getAddressCountry());
		map.put("addressProvince", address.getAddressProvince());
		map.put("addressCity", address.getAddressCity());
		map.put("addressStreet", address.getAddressStreet());
		map.put("addressDetail", address.getAddressDetail());
		map.put("addressReceiverPhone", address.getAddressReceiverPhone());
		map.put("addressReceiverName", address.getAddressReceiverName());
		return new JsonResult<Map<String, Object>>(map, "success");

	}
}
