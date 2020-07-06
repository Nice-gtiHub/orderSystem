package com.order.orderservice.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.order.orderservice.dao.entity.Order;

@Mapper
public interface OrderMapper {
	
    List<Order> findOrdersbyUserId(Integer user_id);
    int insert(Order record);
    Order findOrdersByOrderNo(String order_no);
}

