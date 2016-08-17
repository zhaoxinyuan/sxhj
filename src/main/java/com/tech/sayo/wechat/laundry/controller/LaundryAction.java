package com.tech.sayo.wechat.laundry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.sayo.background.sys.service.SMessageService;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.laundry.bean.RevOrder;
import com.tech.sayo.wechat.laundry.service.LaundryService;
import com.tech.sayo.wechat.util.JsonpUtil;


@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/laundryAction")
public class LaundryAction {

	@Autowired
	private LaundryService laundryService;
	
	@Autowired
	private SMessageService messageService;
	
	@RequestMapping(value = "laundry",method = RequestMethod.GET)
	public String getLaundry(HttpServletRequest request,HttpServletResponse response,RevOrder order,String callback){
		return JsonpUtil.jsonpCllback(laundryService.getLaundry(),callback);
	}
	
	@RequestMapping(value = "submitrevorder",method = RequestMethod.GET)
	public String submiRevtOrder(HttpServletRequest request,HttpServletResponse response,RevOrder order,String callback){
		messageService.insertLaundryOrderMessage();
		return JsonpUtil.jsonpCllback(laundryService.submiRevtOrder(order),callback);
	}
	
	@RequestMapping(value = "order",method = RequestMethod.GET)
	public String getRevOrder(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(laundryService.getOrder(orderId),callback);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "orders",method = RequestMethod.GET)
	public String getRevOrder(HttpServletRequest request,HttpServletResponse response,MyPage page,RevOrder order,String callback){
		return JsonpUtil.jsonpCllback(laundryService.getOrders(page, order),callback);
	}
	
	@RequestMapping(value = "modifystatus",method = RequestMethod.GET)
	public String updaOrderStaus(HttpServletRequest request,HttpServletResponse response,RevOrder order,String callback){
		laundryService.updaOrderStaus(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "removeorder",method = RequestMethod.GET)
	public String deleteOrder(HttpServletRequest request,HttpServletResponse response,RevOrder order,String callback){
		laundryService.removeOrder(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
}
