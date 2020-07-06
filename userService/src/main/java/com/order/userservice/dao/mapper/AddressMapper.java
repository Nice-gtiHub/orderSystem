package com.order.userservice.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.order.userservice.dao.entity.Address;


@Mapper
public interface AddressMapper {
	
    Address findAddressByAddressIdAndUserId(@Param("addressId")Integer addressId,@Param("userId")Integer userId);

}


