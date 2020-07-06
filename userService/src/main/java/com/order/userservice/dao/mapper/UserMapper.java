package com.order.userservice.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.order.userservice.dao.entity.User;

@Mapper
public interface UserMapper {
	
    User findById(Integer user_id);

}


