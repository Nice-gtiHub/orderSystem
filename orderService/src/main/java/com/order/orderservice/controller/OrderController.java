package com.order.orderservice.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.order.common.util.Code;
import com.order.common.util.JsonResult;
import com.order.orderservice.dao.entity.Order;
import com.order.orderservice.feign.ProductFeignClient;
import com.order.orderservice.feign.UserFeignClient;
import com.order.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	public static final String WECHAT = "wechat";
	public static final String ALIPAY = "alipay";

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserFeignClient userFeignClient;
	@Autowired
	private ProductFeignClient productFeignClient;

	@PostMapping(value = "/queryOrdersByUserId", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public JsonResult<List<Order>> queryOrdersByUserId(Integer userId) {

		if (null == userId || userId <= 0) {
			return new JsonResult<List<Order>>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		JsonResult<Map<String, Object>> userResult = userFeignClient.queryUserByuserId(userId);
		if (null == userResult || !Code.SUCCESS.equals(userResult.getCode())) {
			return new JsonResult<List<Order>>(Code.ERROR_NO_DATA, "User does not exist.");
		}

		List<Order> orderlist = orderService.queryOrdersByUserId(userId);
		if (null == orderlist || orderlist.isEmpty()) {
			return new JsonResult<List<Order>>(Code.ERROR_NO_DATA, "no data.");
		}
		return new JsonResult<List<Order>>(orderlist, "success.");

	}

	@PostMapping(value = "/queryOrdersByOrderNo", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public JsonResult<Order> queryOrdersByOrderId(String outTradeNo) {

		if (null == outTradeNo || outTradeNo.isEmpty()) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		Order order = orderService.queryOrdersByOrderNo(outTradeNo);
		if (null == order) {
			return new JsonResult<Order>(Code.ERROR_NO_DATA, "Order number does not exist.");
		}

		return new JsonResult<Order>(order, "success.");
	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public JsonResult<Order> create(Integer userId, Integer addressId, Integer productId, String productName,
			BigDecimal orderPrice, String payType) {

		if (null == userId || userId <= 0) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		if (null == addressId || addressId <= 0) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		if (null == productId || productId <= 0) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR,
					"Missing data or wrong parameters.Please refer to the api documentation.");
		}

		if (null == orderPrice || orderPrice.intValue() < 0) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR, "Wrong parameter or value.");
		}

		if (null == productName || productName.isEmpty()) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR, "Wrong parameter or value.");
		}

		JsonResult<Map<String, Object>> productResult = productFeignClient.queryProductById(productId);

		if (null == productResult || !"0".equals(productResult.getCode())) {
			return new JsonResult<Order>(Code.ERROR_NO_DATA, "Product does not exist, please check.");
		}

		BigDecimal productPrice = new BigDecimal((String) productResult.getData().get("productPrice"));
		String productName1 = (String) productResult.getData().get("productName");

		if (!productName.equals(productName1)) {
			return new JsonResult<Order>(Code.WARM_DATA_MODIFY,
					"The product name has been changed and the new price is " + productName
							+ ".Please refresh your page.");
		}

		if (!productPrice.equals(orderPrice)) {
			return new JsonResult<Order>(Code.WARM_DATA_MODIFY,
					"The product price has been changed and the new price is " + productPrice
							+ ".Please refresh your page.");
		}

		if (payType.isEmpty() || !(WECHAT.equals(payType) || ALIPAY.equals(payType))) {
			return new JsonResult<Order>(Code.ERROR_PARAMETOR, "Illegal payment type.Please check the API document.");
		}

		JsonResult<Map<String, Object>> userResult = userFeignClient.queryUserByuserId(userId);
		if (null == userResult || !Code.SUCCESS.equals(userResult.getCode())) {
			return new JsonResult<Order>(Code.ERROR_NO_DATA, "User does not exist.");
		}

		JsonResult<Map<String, Object>> addressResult = userFeignClient.queryAddressByAddressIdAndUserId(addressId,
				userId);
		if (null == addressResult || !Code.SUCCESS.equals(addressResult.getCode())) {
			return new JsonResult<Order>(Code.ERROR_NO_DATA, "User does not exist.");
		}

		String addressString = JSONObject.toJSONString(addressResult.getData());

		Order order = new Order();

		order.setUserId(userId);
		order.setUserName((String) userResult.getData().get("userName"));
		order.setAddress(addressString);
		order.setProductId(productId);
		order.setProductName(productName);
		order.setOutTradeNo(getOrderIdByTime());
		order.setOrderPrice(orderPrice);
		Date date = new Date();
		order.setOrderTime(date);
		order.setOrderStatus("1");// to be paid
		order.setPayType(payType);
		int result = orderService.create(order);
		if (result > 0) {
			return new JsonResult<Order>(order);
		}
		return new JsonResult<Order>(Code.ERROR_FAILD, "Create order fail.");

	}

	public String getOrderIdByTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate = sdf.format(new Date());
		String result = "";
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			result += random.nextInt(10);
		}
		return newDate + result;
	}

}