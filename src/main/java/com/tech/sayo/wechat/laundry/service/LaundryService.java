package com.tech.sayo.wechat.laundry.service;


import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.wechat.laundry.bean.Laundry;
import com.tech.sayo.wechat.laundry.bean.RevOrder;

public interface LaundryService {
	public Laundry getLaundry();

	public RevOrder submiRevtOrder(RevOrder order);
	
	public RevOrder getOrder(Integer orderId);
	
	public RevOrder getOrder(String orderNo);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,RevOrder order);
	
	public void updaOrderStaus(RevOrder order);
	
	public void removeOrder(RevOrder order);
}
