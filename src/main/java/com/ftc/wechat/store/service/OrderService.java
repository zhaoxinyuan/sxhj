package com.ftc.wechat.store.service;

import java.util.List;

import com.ftc.wechat.store.bean.Order;
import com.ftc.wechat.store.bean.Store;
import com.ftc.wechat.store.entity.OrderTemp;
import com.ftc.wechat.store.entity.ShoppingCartTemp;

public interface OrderService {

	public OrderTemp creatOrder(List<ShoppingCartTemp> cart,Integer userId,Store store,Integer addressId);
	
	public Order submitOrder(OrderTemp orderTemp,Order order,String invoiceTitle);
}
