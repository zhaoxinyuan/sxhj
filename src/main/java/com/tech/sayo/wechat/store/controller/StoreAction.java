package com.tech.sayo.wechat.store.controller;

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
import com.tech.sayo.wechat.store.bean.Product;
import com.tech.sayo.wechat.store.service.StoreService;
import com.tech.sayo.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/storeAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class StoreAction {
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value = "store",method = RequestMethod.GET)
	public String getStore(HttpServletRequest request,HttpServletResponse response,Integer storeId,String callback){
		return JsonpUtil.jsonpCllback(storeService.getStore(1),callback);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "products",method = RequestMethod.GET)
	public String getProducts(HttpServletRequest request,HttpServletResponse response,Product product,MyPage page,String callback){
		return JsonpUtil.jsonpCllback(storeService.getProducts(page, product),callback);
	}

	@RequestMapping(value = "cartproducts",method = RequestMethod.GET)
	public String cartProducts(HttpServletRequest request,HttpServletResponse response,String productIds,String callback){
		return JsonpUtil.jsonpCllback(storeService.getProducts(productIds),callback);
	}
	
	@RequestMapping(value = "product",method = RequestMethod.GET)
	public String getProduct(HttpServletRequest request,HttpServletResponse response,Integer productId,String callback){
		return JsonpUtil.jsonpCllback(storeService.getProduct(productId),callback);
	}
}
