package com.ftc.wechat.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.base.dao.BaseDao;
import com.ftc.wechat.account.bean.UserAddress;
import com.ftc.wechat.account.service.UserAddressService;

@Service 
public class UserAddressServiceImpl implements UserAddressService{
	
	private static final String NAMESPACE_INFOUSER  = "com.ftc.wechat.account.bean.mapper.UserAddressMapper.";
	
	@Autowired
    private  BaseDao baseDao;

	@Override
	public List<UserAddress> getAddresses(Integer addressUserid) {
		return baseDao.selectList(NAMESPACE_INFOUSER + "selectAll", addressUserid);
	}

	@Override
	public UserAddress getAddress(Integer addressId) {
		return baseDao.selectOne(NAMESPACE_INFOUSER + "selectByPrimaryKey", addressId);
	}

	@Override
	public UserAddress saveAddress(UserAddress address) {
		if(address.getAddressDefault() == 1){
			UserAddress addressToDefault = new UserAddress();
			addressToDefault.setAddressUserid(address.getAddressUserid());
			addressToDefault.setAddressDefault(0);
			baseDao.modify(NAMESPACE_INFOUSER + "updateBySelective", addressToDefault);
		}
		baseDao.insert(NAMESPACE_INFOUSER + "insertSelective", address);
		return baseDao.selectOne(NAMESPACE_INFOUSER + "selectByLast", address.getAddressUserid());
	}

	@Override
	public void updateAddress(UserAddress address) {
		baseDao.modify(NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", address);
	}

	@Override
	public void deleteAddress(UserAddress address) {
		baseDao.modify(NAMESPACE_INFOUSER + "deleteByPrimaryKey", address);
	}

	@Override
	public void updateAddressDefault(UserAddress address) {		
		UserAddress addressToDefault = new UserAddress();
		addressToDefault.setAddressUserid(address.getAddressUserid());
		addressToDefault.setAddressDefault(0);
		baseDao.modify(NAMESPACE_INFOUSER + "updateBySelective", addressToDefault);
		baseDao.modify(NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", address);
	}

	
}
