package com.ftc.wechat.laundry.service;


import com.ftc.base.entity.MyPage;
import com.ftc.wechat.laundry.bean.Laundry;
import com.ftc.wechat.laundry.bean.RevOrder;

public interface LaundryService {
	public Laundry getLaundry();

	public RevOrder submiRevtOrder(RevOrder order);
	
	public RevOrder getOrder(Integer orderId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,RevOrder order);
	
	public void updaOrderStaus(RevOrder order);
	
	public void removeOrder(RevOrder order);
}
