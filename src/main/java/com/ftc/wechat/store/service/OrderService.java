package com.ftc.wechat.store.service;

import java.util.List;

import com.ftc.base.entity.MyPage;
import com.ftc.wechat.store.bean.Order;
import com.ftc.wechat.store.bean.Store;
import com.ftc.wechat.store.entity.OrderTemp;
import com.ftc.wechat.store.entity.ShoppingCartTemp;

public interface OrderService {

	public OrderTemp creatOrder(List<ShoppingCartTemp> cart,Integer userId,Store store,Integer addressId);
	
	public Order submitOrder(OrderTemp orderTemp,Order order,String invoiceTitle);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,Order order);

	public Order getOrder(Integer orderId);
	
	public void updateOrderStatus(Order order);
	
	public void removeOrderStatus(Order order);
}
