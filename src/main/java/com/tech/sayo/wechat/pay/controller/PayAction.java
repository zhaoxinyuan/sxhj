package com.tech.sayo.wechat.pay.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.clean.service.CleanService;
import com.tech.sayo.wechat.laundry.bean.RevOrder;
import com.tech.sayo.wechat.laundry.service.LaundryService;
import com.tech.sayo.wechat.pay.service.PayService;
import com.tech.sayo.wechat.store.bean.StrOrder;
import com.tech.sayo.wechat.store.service.StoreOrderService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller
@ResponseBody
@Scope("prototype")
@RequestMapping("/payAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PayAction {
	@Autowired
	private PayService payService;

	@Autowired
	private StoreOrderService strService;

	@Autowired
	private CleanService cleService;

	@Autowired
	private LaundryService ladService;

	@RequestMapping(value = "platform", method = RequestMethod.GET)
	public String platform(HttpServletRequest request, HttpServletResponse response, String callback) {
		return JsonpUtil.jsonpCllback(payService.getPlatforms(), callback);
	}
	
	@RequestMapping(value = "storeorderwechat", method = RequestMethod.GET)
	public String storeOrderWechat(HttpServletRequest request, HttpServletResponse response, Integer orderId,String wechatId, String callback) {
		return JsonpUtil.jsonpCllback(payService.PayStoreByWechat(request, response, strService.getOrder(orderId), wechatId), callback);
	}
	
	@RequestMapping(value = "storeordercallbackwechat", method = RequestMethod.POST)
	public String storeOrderCallBackWechat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map =  payService.wechatPayCallback(request, response);
		if(map != null){
			StrOrder order = strService.getOrder(map.get("out_trade_no").toString());
			order.setOrderStatusval(2);
			strService.updateOrderStatus(order);
			payService.insertPayDetailForWechat(map,order.getOrderId());
		}
		return null;
	}
	
	@RequestMapping(value = "cleanorderwechat", method = RequestMethod.GET)
	public String cleanOrderWechat(HttpServletRequest request, HttpServletResponse response, Integer orderId,String wechatId, String callback) {
		return JsonpUtil.jsonpCllback(payService.PayCleanByWechat(request, response, cleService.getOrder(orderId), wechatId), callback);
	}
	
	@RequestMapping(value = "cleanordercallbackwechat", method = RequestMethod.POST)
	public String cleanOrderCallBackWechat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map =  payService.wechatPayCallback(request, response);
		if(map != null){
			CleOrder order = cleService.getOrder(map.get("out_trade_no").toString());
			order.setOrderStatusval(2);
			cleService.updateCleOrderStatus(order);
			payService.insertPayDetailForWechat(map,order.getOrderId());
		}
		return null;
	}
	
	@RequestMapping(value = "diforderwechat", method = RequestMethod.GET)
	public String difOrderWechat(HttpServletRequest request, HttpServletResponse response, Integer orderId,String wechatId, String callback) {
		return JsonpUtil.jsonpCllback(payService.PayDifferenceByWechat(request, response, cleService.getDifOrder(orderId), wechatId), callback);
	}
	
	@RequestMapping(value = "difordercallbackwechat", method = RequestMethod.POST)
	public String difOrderCallBackWechat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map =  payService.wechatPayCallback(request, response);
		if(map != null){
			DifOrder order = cleService.getDifOrder(map.get("out_trade_no").toString());
			order.setStatusCode("dif_002");
			cleService.updateDifOrderStatus(order);
			payService.insertPayDetailForWechat(map,order.getOrderId());
		}
		return null;
	}
	
	@RequestMapping(value = "laundryorderwechat", method = RequestMethod.GET)
	public String laundryOrderWechat(HttpServletRequest request, HttpServletResponse response, Integer orderId,String wechatId, String callback) {
		return JsonpUtil.jsonpCllback(payService.PayLaundryByWechat(request, response, ladService.getOrder(orderId), wechatId), callback);
	}
	
	@RequestMapping(value = "laundryordercallbackwechat", method = RequestMethod.POST)
	public String laundryOrderCallBackWechat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map =  payService.wechatPayCallback(request, response);
		if(map != null){
			RevOrder order = ladService.getOrder(map.get("out_trade_no").toString());
			order.setStatusCode("lad_003");
			ladService.updaOrderStaus(order);
			payService.insertPayDetailForWechat(map,order.getOrderId());
		}
		return null;
	}
	
	@RequestMapping(value = "accountwechat", method = RequestMethod.GET)
	public String accountWechat(HttpServletRequest request, HttpServletResponse response, Double amount,String wechatId, String callback) {
		return JsonpUtil.jsonpCllback(payService.refillAccountWechat(request, response, amount, wechatId), callback);
	}
	
	@RequestMapping(value = "accountcallbackwechat", method = RequestMethod.POST)
	public String accountCallbackWechat(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map =  payService.wechatPayCallback(request, response);
		if(map != null){
			payService.insertPayDetailForWechat(map,null);
			payService.insertAccountForWechat(map);
		}
		return null;
	}
}
