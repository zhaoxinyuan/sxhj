package com.ftc.wechat.pay.service;

import java.util.List;

import com.ftc.base.entity.MyStatus;
import com.ftc.wechat.pay.bean.Platform;

public interface PayService {

	public List<Platform> getPlatforms();

	public MyStatus PayStoreByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayCleanByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayLaundryByAccount(Integer orderId, Integer accountUserid);
}
