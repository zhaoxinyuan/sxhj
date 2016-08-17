package com.tech.sayo.wechat.pay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.sayo.background.sys.service.SMessageService;
import com.tech.sayo.wechat.pay.service.PayService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/payAccountAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PayAccountAction {
	@Autowired
	private PayService payService;
	
	@Autowired
	private SMessageService messageService;
	
	@RequestMapping(value = "paystore",method = RequestMethod.GET)
	public String PayStoreByAccount(HttpServletRequest request,HttpServletResponse response,Integer orderId, Integer accountUserid,String callback){
		messageService.insertStoreOrderMessage();
		return JsonpUtil.jsonpCllback(payService.PayStoreByAccount(orderId, accountUserid),callback);
	}
	
	@RequestMapping(value = "payclean",method = RequestMethod.GET)
	public String PayCleanByAccount(HttpServletRequest request,HttpServletResponse response,Integer orderId, Integer accountUserid,String callback){
		messageService.insertCleanOrderMessage();
		return JsonpUtil.jsonpCllback(payService.PayCleanByAccount(orderId, accountUserid),callback);
	}
	
	@RequestMapping(value = "paylaundry",method = RequestMethod.GET)
	public String PayLaundryByAccount(HttpServletRequest request,HttpServletResponse response,Integer orderId, Integer accountUserid,String callback){
		return JsonpUtil.jsonpCllback(payService.PayLaundryByAccount(orderId, accountUserid),callback);
	}
	
	@RequestMapping(value = "paydifference",method = RequestMethod.GET)
	public String PayDifferenceByAccount(HttpServletRequest request,HttpServletResponse response,Integer orderId, Integer accountUserid,String callback){
		return JsonpUtil.jsonpCllback(payService.PayDifferenceByAccount(orderId, accountUserid),callback);
	}
	
	@RequestMapping(value = "paytip",method = RequestMethod.GET)
	public String PayTipByAccount(HttpServletRequest request,HttpServletResponse response,Integer orderId, Integer accountUserid,String callback){
		return JsonpUtil.jsonpCllback(payService.PayTipByAccount(orderId, accountUserid),callback);
	}
}
