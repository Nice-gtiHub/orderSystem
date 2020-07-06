package com.order.userservice.dao.entity;

public class Address {
	private int addressId;

	private int userId;

	private String addressCountry;

	private String addressProvince;
	
	private String addressCity;

	private String addressStreet;
	private String addressDetail;

	private String addressReceiverPhone;
	private String addressReceiverName;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getAddressProvince() {
		return addressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressReceiverPhone() {
		return addressReceiverPhone;
	}

	public void setAddressReceiverPhone(String addressReceiverPhone) {
		this.addressReceiverPhone = addressReceiverPhone;
	}

	public String getAddressReceiverName() {
		return addressReceiverName;
	}

	public void setAddressReceiverName(String addressReceiverName) {
		this.addressReceiverName = addressReceiverName;
	}

	

}
