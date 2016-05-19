package com.ftc.wechat.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.base.controller.BaseAction;
import com.ftc.wechat.account.bean.UserAddress;
import com.ftc.wechat.account.service.UserAddressService;

import com.ftc.wechat.util.JsonpUtil;

@Controller 
@ResponseBody
@Scope("prototype")
@RequestMapping("/accountAddressAction")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AddressAction extends BaseAction{

	@Autowired
	private UserAddressService addressService;
	
	@RequestMapping(value = "addresses",method = RequestMethod.GET)
	public String getAddressList(HttpServletRequest request,HttpServletResponse response,Integer addressUserid,String callback){
		return JsonpUtil.jsonpCllback(addressService.getAddresses(addressUserid),callback);
	}
	
	@RequestMapping(value = "address",method = RequestMethod.GET)
	public String getAddress(HttpServletRequest request,HttpServletResponse response,Integer addressId,String callback){
		return JsonpUtil.jsonpCllback(addressService.getAddress(addressId),callback);
	}
	
	@RequestMapping(value = "saveAddress",method = RequestMethod.GET)
	public String saveAddress(HttpServletRequest request,HttpServletResponse response,UserAddress address,String callback){
		return JsonpUtil.jsonpCllback(addressService.saveAddress(address),callback);
	}
	
	@RequestMapping(value = "modifyaAddressDefault",method = RequestMethod.GET)
	public String updateAddressDefault(HttpServletRequest request,HttpServletResponse response,UserAddress address,String callback){
		addressService.updateAddressDefault(address);
		return JsonpUtil.jsonpCllback(super.backSuccess(),callback);
	}
	
	@RequestMapping(value = "modifyAddress",method = RequestMethod.GET)
	public String updateAddress(HttpServletRequest request,HttpServletResponse response,UserAddress address,String callback){
		addressService.updateAddress(address);
		return JsonpUtil.jsonpCllback(super.backSuccess(),callback);
	}
	
	@RequestMapping(value = "removeAddress",method = RequestMethod.GET)
	public String deleteAddress(HttpServletRequest request,HttpServletResponse response,UserAddress address,String callback){
		addressService.deleteAddress(address);
		return JsonpUtil.jsonpCllback(super.backSuccess(),callback);
	}
}
