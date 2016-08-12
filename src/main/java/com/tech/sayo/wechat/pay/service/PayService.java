package com.tech.sayo.wechat.pay.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.sayo.base.entity.MyStatus;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.CleTipOrder;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.laundry.bean.RevOrder;
import com.tech.sayo.wechat.pay.bean.Platform;
import com.tech.sayo.wechat.pay.entity.BaseOrder;
import com.tech.sayo.wechat.pay.entity.UnifiedWeChatOrder;
import com.tech.sayo.wechat.store.bean.StrOrder;

public interface PayService {

	public List<Platform> getPlatforms();

	public MyStatus PayStoreByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayCleanByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayLaundryByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayDifferenceByAccount(Integer orderId, Integer accountUserid);
	
	public MyStatus PayTipByAccount(Integer orderId, Integer accountUserid);
	
	public UnifiedWeChatOrder PayStoreByWechat(HttpServletRequest request, HttpServletResponse response,StrOrder order,String wechatId);
	
	public UnifiedWeChatOrder PayCleanByWechat(HttpServletRequest request, HttpServletResponse response,CleOrder order,String wechatId);
	
	public UnifiedWeChatOrder PayLaundryByWechat(HttpServletRequest request, HttpServletResponse response,RevOrder revOrder,String wechatId);
	
	public UnifiedWeChatOrder PayDifferenceByWechat(HttpServletRequest request, HttpServletResponse response,DifOrder order,String wechatId);
	
	public UnifiedWeChatOrder createWechatOrder(BaseOrder order,HttpServletRequest request,HttpServletResponse response,String wechatId);
	
	public Map<String, Object> wechatPayCallback(HttpServletRequest request,HttpServletResponse response);
	
	public void insertPayDetailForWechat(Map<String, Object> map,Integer orderId);
	
	public UnifiedWeChatOrder refillAccountWechat(HttpServletRequest request, HttpServletResponse response,double amount,String wechatId);
	
	public UnifiedWeChatOrder PayTipByWechat(HttpServletRequest request, HttpServletResponse response,CleTipOrder order,String wechatId);
	
	public void insertAccountForWechat(Map<String, Object> map);
}
