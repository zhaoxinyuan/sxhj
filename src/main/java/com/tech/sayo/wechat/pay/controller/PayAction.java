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

import com.tech.sayo.wechat.clean.service.CleanService;
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
	
	@RequestMapping(value = "storeorder", method = RequestMethod.GET)
	public String storeOrder(HttpServletRequest request, HttpServletResponse response, Integer orderId,String wechatId, String callback) {
		return JsonpUtil.jsonpCllback(payService.PayStoreByWechat(request, response, strService.getOrder(orderId), wechatId), callback);
	}
	
	@RequestMapping(value = "storeordercallback", method = RequestMethod.POST)
	public String storeOrderCallBack(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map =  payService.wechatPayCallback(request, response);
		if(map != null){
			StrOrder order = strService.getOrder(map.get("out_trade_no").toString());
			order.setStatusCode("str_002");
			strService.updateOrderStatus(order);
			payService.insertPayDetailForWechat(map,order.getOrderId());
		}
		return null;
	}

}
