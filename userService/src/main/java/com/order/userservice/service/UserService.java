package com.order.userservice.service;

import javax.validation.Valid;

import com.order.userservice.dao.entity.User;

public interface UserService {
	
    User queryUserById(@Valid Integer user_id);
    
}
