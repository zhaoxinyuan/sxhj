package com.tech.sayo.wechat.pay.service;

import java.util.List;

import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.pay.bean.Platform;

public interface PayService {

	public List<Platform> getPlatforms();

	public MyStatus PayStoreByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayCleanByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayLaundryByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayDifferenceByAccount(Integer orderId, Integer accountUserid);
}
