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
import com.ftc.wechat.clean.service.CleanService;
import com.ftc.wechat.util.JsonpUtil;

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
}
