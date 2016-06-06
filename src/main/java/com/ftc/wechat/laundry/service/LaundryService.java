package com.ftc.wechat.laundry.service;


import com.ftc.base.entity.MyPage;
import com.ftc.wechat.laundry.bean.Order;
import com.ftc.wechat.laundry.bean.RevOrder;

public interface LaundryService {

	public RevOrder submiRevtOrder(RevOrder order);
	
	public RevOrder getRevOrder(Integer orderId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getRevOrders(MyPage page,RevOrder order);
	
	public void cancleRevOrder(RevOrder order);
	
	public Order getOrder(Integer orderId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,Order order);
	
	public void updaOrderStaus(Order order);
}
