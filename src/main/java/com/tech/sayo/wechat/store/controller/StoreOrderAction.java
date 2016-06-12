package com.tech.sayo.wechat.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.store.bean.Store;
import com.tech.sayo.wechat.store.bean.StrOrder;
import com.tech.sayo.wechat.store.entity.OrderTemp;
import com.tech.sayo.wechat.store.entity.ShoppingCartTemp;
import com.tech.sayo.wechat.store.service.OrderService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/store/orderAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class StoreOrderAction {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "creatOrder",method = RequestMethod.GET)
	public String creatOrder(HttpServletRequest request,HttpServletResponse response,String cart, Integer userId,Store store,Integer addressId,String callback){
		List<ShoppingCartTemp> cartList = new Gson().fromJson(cart, new TypeToken<List<ShoppingCartTemp>>(){}.getType());
		return JsonpUtil.jsonpCllback(orderService.creatOrder(cartList, userId, store, addressId),callback);
	}
	
	@RequestMapping(value = "submitOrder",method = RequestMethod.GET)
	public String submitOrder(HttpServletRequest request,HttpServletResponse response,String orderTemp,StrOrder order,String invoiceTitle,String callback){
		return JsonpUtil.jsonpCllback(orderService.submitOrder(new Gson().fromJson(orderTemp, OrderTemp.class), order, invoiceTitle),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "orders",method = RequestMethod.GET)
	public String getOrders(HttpServletRequest request,HttpServletResponse response,MyPage page, StrOrder order,String callback){
		return JsonpUtil.jsonpCllback(orderService.getOrders(page, order),callback);
	}
	
	@RequestMapping(value = "order",method = RequestMethod.GET)
	public String getOrder(HttpServletRequest request,HttpServletResponse response, Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(orderService.getOrder(orderId),callback);
	}
	
	@RequestMapping(value = "modifystatus",method = RequestMethod.GET)
	public String updateOrderStatus(HttpServletRequest request,HttpServletResponse response, StrOrder order,String callback){
		orderService.updateOrderStatus(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "removeorder",method = RequestMethod.GET)
	public String removeOrder(HttpServletRequest request,HttpServletResponse response, StrOrder order,String callback){
		orderService.removeOrderStatus(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
}
