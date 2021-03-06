package com.tech.sayo.wechat.clean.controller;

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
import com.tech.sayo.background.sys.service.SMessageService;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.CleTipOrder;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.clean.bean.NanOrder;
import com.tech.sayo.wechat.clean.service.CleanService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/cleanAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CleanAction {
	@Autowired
	private CleanService cleanService;
	
	@Autowired
	private SMessageService messageService;		
	
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
		return JsonpUtil.jsonpCllback(cleanService.orderSubmit(new Gson().fromJson(order, CleOrder.class)),callback);
	}
	
	@RequestMapping(value = "nanordersubmit",method = RequestMethod.GET)
	public String nannyOrderSubmit(HttpServletRequest request,HttpServletResponse response,String order,String callback){
		messageService.insertNannyOrderMessage();
		return JsonpUtil.jsonpCllback(cleanService.orderSubmit(new Gson().fromJson(order, NanOrder.class)),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "cleorders",method = RequestMethod.GET)
	public String getCleOrders(HttpServletRequest request,HttpServletResponse response,MyPage page,CleOrder order,String callback){
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
	
	@RequestMapping(value = "modifyclestatus",method = RequestMethod.GET)
	public String modifyCleStatus(HttpServletRequest request,HttpServletResponse response,CleOrder order,String callback){
		cleanService.updateCleOrderStatus(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
	
	@RequestMapping(value = "cleorderbydiff",method = RequestMethod.GET)
	public String cleOrderByDiff(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getOrderByDiff(orderId),callback);
	}
	
	@RequestMapping(value = "removelecleorder",method = RequestMethod.GET)
	public String removeCleOrder(HttpServletRequest request,HttpServletResponse response,CleOrder order,String callback){
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
	
	@RequestMapping(value = "difordersubmit",method = RequestMethod.GET)
	public String diforderSubmit(HttpServletRequest request,HttpServletResponse response,DifOrder order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.orderSubmit(order),callback);
	}
	
	@RequestMapping(value = "diforder",method = RequestMethod.GET)
	public String getDifOrder(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getDifOrder(orderId),callback);
	}
	
	@RequestMapping(value = "modifydifstatus",method = RequestMethod.GET)
	public String modifyDifstatus(HttpServletRequest request,HttpServletResponse response,DifOrder order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.updateDifOrderStatus(order),callback);
	}
	
	@RequestMapping(value = "tiporder",method = RequestMethod.GET)
	public String getTipOrder(HttpServletRequest request,HttpServletResponse response,Integer orderId,String callback){
		return JsonpUtil.jsonpCllback(cleanService.getOrderByTip(orderId),callback);
	}
	
	@RequestMapping(value = "tipordersubmit",method = RequestMethod.GET)
	public String tipOrderSubmit(HttpServletRequest request,HttpServletResponse response,CleTipOrder order,String callback){
		return JsonpUtil.jsonpCllback(cleanService.orderSubmit(order),callback);
	}
	
	@RequestMapping(value = "modifytipstatus",method = RequestMethod.GET)
	public String modifyTipstatus(HttpServletRequest request,HttpServletResponse response,CleTipOrder order,String callback){
		cleanService.updateCleTipOrderStatus(order);
		return JsonpUtil.jsonpCllback(new MyStatus().MyStatusSuccess(),callback);
	}
}
