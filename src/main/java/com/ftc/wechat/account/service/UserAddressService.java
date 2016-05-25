package com.ftc.wechat.account.service;

import java.util.List;

import com.ftc.wechat.account.bean.UserAddress;

public interface UserAddressService {
	public List<UserAddress> getAddresses(Integer addressUserid);
	
	public UserAddress getAddress(Integer addressId);
	
	public UserAddress saveAddress(UserAddress address);
	
	public void updateAddress(UserAddress address);
	
	public void deleteAddress(UserAddress address);
	
	public void updateAddressDefault(UserAddress address);
	
	public UserAddress getDefaultAddress(Integer addressUserid);
}
