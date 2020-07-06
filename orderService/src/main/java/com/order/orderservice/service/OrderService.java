package com.order.orderservice.service;

import java.util.List;

import javax.validation.Valid;

import com.order.orderservice.dao.entity.Order;

public interface OrderService {
	
    List<Order> queryOrdersByUserId(@Valid Integer user_id);

	int create(Order order);
	
	Order queryOrdersByOrderNo(@Valid String out_trade_no);
}
