package com.order.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.userservice.dao.entity.User;
import com.order.userservice.dao.mapper.UserMapper;
import com.order.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User queryUserById(Integer user_id) {
		User user = userMapper.findById(user_id);
		return user;
	}

}
