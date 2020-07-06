package com.order.userservice.service;

import javax.validation.Valid;

import com.order.userservice.dao.entity.Address;

public interface AddressService {
	
    Address queryAddressByAddressIdAndUserId(@Valid Integer addressId,@Valid Integer userId);
    
}
