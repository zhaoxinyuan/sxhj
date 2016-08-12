package com.tech.sayo.wechat.store.service;

import java.util.List;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.wechat.store.bean.Store;
import com.tech.sayo.wechat.store.bean.StrOrder;
import com.tech.sayo.wechat.store.entity.OrderTemp;
import com.tech.sayo.wechat.store.entity.ShoppingCartTemp;

public interface StoreOrderService {

	public OrderTemp creatOrder(List<ShoppingCartTemp> cart,Integer userId,Store store,Integer addressId);
	
	public StrOrder submitOrder(OrderTemp orderTemp,StrOrder order,String invoiceTitle);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,StrOrder order);

	public StrOrder getOrder(Integer orderId);
	
	public  StrOrder getOrder(String orderNo);
	
	public void updateOrderStatus(StrOrder order);
	
	public void removeOrderStatus(StrOrder order);
	
}
