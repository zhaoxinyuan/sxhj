package com.tech.sayo.wechat.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.wechat.account.service.AccountService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/accountAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AccountAction {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "amount",method = RequestMethod.GET)
	public String getUserAmount(HttpServletRequest request,HttpServletResponse response,Integer accountUserid,String callback){
		return JsonpUtil.jsonpCllback(accountService.getUserAmount(accountUserid),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "details",method = RequestMethod.GET)
	public String getUserDetail(HttpServletRequest request,HttpServletResponse response, MyPage myPage,Integer accountUserid,String callback){
		return JsonpUtil.jsonpCllback(accountService.getUserAccount(myPage, accountUserid),callback);
	}
	
}
