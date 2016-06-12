package com.ftc.wechat.store.service;

import java.util.List;

import com.ftc.base.entity.MyPage;
import com.ftc.wechat.store.bean.StrOrder;
import com.ftc.wechat.store.bean.Store;
import com.ftc.wechat.store.entity.OrderTemp;
import com.ftc.wechat.store.entity.ShoppingCartTemp;

public interface OrderService {

	public OrderTemp creatOrder(List<ShoppingCartTemp> cart,Integer userId,Store store,Integer addressId);
	
	public StrOrder submitOrder(OrderTemp orderTemp,StrOrder order,String invoiceTitle);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,StrOrder order);

	public StrOrder getOrder(Integer orderId);
	
	public void updateOrderStatus(StrOrder order);
	
	public void removeOrderStatus(StrOrder order);
}
