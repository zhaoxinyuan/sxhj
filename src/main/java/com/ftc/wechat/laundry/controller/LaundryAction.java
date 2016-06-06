package com.ftc.wechat.laundry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.base.entity.MyPage;
import com.ftc.base.entity.MyStatus;
import com.ftc.wechat.laundry.bean.Order;
import com.ftc.wechat.laundry.bean.RevOrder;
import com.ftc.wechat.laundry.service.LaundryService;
import com.ftc.wechat.util.JsonpUtil;


@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/laundryAction")
public class LaundryAction {

	@Autowired
	private LaundryService laundryService;
	
	@RequestMapping(value = "submitrevorder",method = RequestMethod.GET)
	public String submiRevtOrder(HttpServletRequest request,HttpServletResponse response,RevOrder order,String callback){
		return JsonpUtil.jsonpCllback(laundryService.submiRevtOrder(order),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "revorders",method = RequestMethod.GET)
	public String getRevOrders(HttpServletRequest request,HttpServletResponse response,MyPage page,RevOrder order,String callback){
		return JsonpUtil.jsonpCllback(laundryService.getRevOrders(page, order),callback);
	}
	
	@RequestMapping(value = "revorder",method = RequestMethod.GET)
	public String getRevOrder(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(laundryService.getOrder(orderId),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "orders",method = RequestMethod.GET)
	public String getRevOrder(HttpServletRequest request,HttpServletResponse response,MyPage page,Order order,String callback){
		return JsonpUtil.jsonpCllback(laundryService.getOrders(page, order),callback);
	}
	
	@RequestMapping(value = "canclerevorder",method = RequestMethod.GET)
	public String cancleRevOrder(HttpServletRequest request,HttpServletResponse response,RevOrder order,String callback){
		laundryService.cancleRevOrder(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "modifystatus",method = RequestMethod.GET)
	public String updaOrderStaus(HttpServletRequest request,HttpServletResponse response,Order order,String callback){
		laundryService.updaOrderStaus(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
}
