package com.ftc.wechat.order.service;

import java.util.List;

import com.ftc.wechat.order.bean.Order;
import com.ftc.wechat.order.entity.OrderTemp;
import com.ftc.wechat.order.entity.ShoppingCartTemp;
import com.ftc.wechat.store.bean.Store;

public interface OrderService {

	public OrderTemp creatOrder(List<ShoppingCartTemp> cart,Integer userId,Store store,Integer addressId);
	
	public Order submitOrder(OrderTemp orderTemp,Order order,String invoiceTitle);
}
