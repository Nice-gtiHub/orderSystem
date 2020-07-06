package com.order.userservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.userservice.dao.entity.Address;
import com.order.userservice.dao.mapper.AddressMapper;
import com.order.userservice.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	public Address queryAddressByAddressIdAndUserId(Integer addressId, Integer userId) {
		return addressMapper.findAddressByAddressIdAndUserId(addressId, userId);
	}

}
