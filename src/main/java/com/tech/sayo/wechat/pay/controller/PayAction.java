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

import com.tech.sayo.wechat.pay.service.PayService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/payAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PayAction {
	@Autowired
	private PayService payService;
	
	@RequestMapping(value = "platform",method = RequestMethod.GET)
	public String platform(HttpServletRequest request,HttpServletResponse response,String callback){
		return JsonpUtil.jsonpCllback(payService.getPlatforms(),callback);
	}
}
