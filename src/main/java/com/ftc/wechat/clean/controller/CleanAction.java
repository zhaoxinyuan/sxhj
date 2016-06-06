package com.ftc.wechat.clean.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.base.entity.MyPage;
import com.ftc.base.entity.MyStatus;
import com.ftc.wechat.clean.bean.NanOrder;
import com.ftc.wechat.clean.bean.Order;
import com.ftc.wechat.clean.service.CleanService;
import com.ftc.wechat.util.JsonpUtil;
import com.google.gson.Gson;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/cleanAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CleanAction {
	@Autowired
	private CleanService cleanService;
	
	@RequestMapping(value = "categories",method = RequestMethod.GET)
	public String getCleanCategorise(HttpServletRequest request,HttpServletResponse response,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getCleanCategories(),callback);
	}
	
	@RequestMapping(value = "category",method = RequestMethod.GET)
	public String getCleanCategory(HttpServletRequest request,HttpServletResponse response,Integer categoryId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getCategory(categoryId),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "staffs",method = RequestMethod.GET)
	public String getStaffs(HttpServletRequest request,HttpServletResponse response,MyPage page,Integer categoryId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getStaffs(page, categoryId),callback);
	}
	
	@RequestMapping(value = "staff",method = RequestMethod.GET)
	public String getStaff(HttpServletRequest request,HttpServletResponse response,Integer staffId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getStaff(staffId),callback);
	}
	
	@RequestMapping(value = "cleordersubmit",method = RequestMethod.GET)
	public String cleanOrderSubmit(HttpServletRequest request,HttpServletResponse response,String order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.orderSubmit(new Gson().fromJson(order, Order.class)),callback);
	}
	
	@RequestMapping(value = "nanordersubmit",method = RequestMethod.GET)
	public String nannyOrderSubmit(HttpServletRequest request,HttpServletResponse response,String order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.orderSubmit(new Gson().fromJson(order, NanOrder.class)),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "cleorders",method = RequestMethod.GET)
	public String getCleOrders(HttpServletRequest request,HttpServletResponse response,MyPage page,Order order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getOrders(page, order),callback);
	}
	
	@RequestMapping(value = "cleorder",method = RequestMethod.GET)
	public String getCleOrder(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getOrder(orderId),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "nanorders",method = RequestMethod.GET)
	public String getNanOrders(HttpServletRequest request,HttpServletResponse response,MyPage page,NanOrder order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getNanOrders(page, order),callback);
	}
	
	@RequestMapping(value = "nanorder",method = RequestMethod.GET)
	public String getNanOrder(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getNanOrder(orderId),callback);
	}
	
	@RequestMapping(value = "stafftimes",method = RequestMethod.GET)
	public String stafftimes(HttpServletRequest request,HttpServletResponse response,Integer staffId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getStaffTimeOccupancy(staffId),callback);
	}
	
	@RequestMapping(value = "canclecleorder",method = RequestMethod.GET)
	public String cancleCleOrder(HttpServletRequest request,HttpServletResponse response,Order order,String callback){
		cleanService.cancelCleOrder(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "removelecleorder",method = RequestMethod.GET)
	public String removeCleOrder(HttpServletRequest request,HttpServletResponse response,Order order,String callback){
		cleanService.delateCleOrder(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "canclenanorder",method = RequestMethod.GET)
	public String cancleNanOrder(HttpServletRequest request,HttpServletResponse response,NanOrder order,String callback){
		cleanService.cancelNanOrder(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "removelenanorder",method = RequestMethod.GET)
	public String removeNanOrder(HttpServletRequest request,HttpServletResponse response,NanOrder order,String callback){
		cleanService.delateNanOrder(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
}
