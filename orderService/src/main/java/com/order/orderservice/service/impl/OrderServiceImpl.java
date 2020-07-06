package com.order.orderservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.order.orderservice.dao.entity.Order;
import com.order.orderservice.dao.mapper.OrderMapper;
import com.order.orderservice.service.OrderService;

@Service
@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderMapper orderMapper;
    
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public int create(Order order) {
		int result = orderMapper.insert(order);
		return result;
	}

	public List<Order> queryOrdersByUserId(Integer user_id) {
		return orderMapper.findOrdersbyUserId(user_id);
	}

	public Order queryOrdersByOrderNo(String out_trade_no) {
		return orderMapper.findOrdersByOrderNo(out_trade_no);
	}

}
