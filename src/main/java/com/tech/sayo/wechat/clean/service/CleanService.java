package com.tech.sayo.wechat.clean.service;

import java.util.List;

import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.wechat.clean.bean.Category;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.CleOrderDetail;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.clean.bean.NanOrder;
import com.tech.sayo.wechat.clean.bean.Staff;

public interface CleanService {

	public List<Category> getCleanCategories();
	
	public Category getCategory(Integer categoryId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getStaffs(MyPage page,Integer categoryId);
	
	public Staff getStaff(Integer staffId);
	
	public CleOrder orderSubmit(CleOrder order);
	
	public NanOrder orderSubmit(NanOrder order);
	
	public List<CleOrderDetail> getStaffTimeOccupancy(Integer detailStaffid);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,CleOrder order);
	
	@SuppressWarnings("rawtypes")
	public MyPage getNanOrders(MyPage page,NanOrder order);
	
	public CleOrder getOrder(Integer orderId);
	
	public CleOrder getOrder(String orderNo);
	
	public CleOrder getOrderByDiff(Integer orderId);
	
	public NanOrder getNanOrder(Integer orderId);
	
	public void updateCleOrderStatus(CleOrder order);
	
	public void delateCleOrder(CleOrder order);
	
	public void cancelNanOrder(NanOrder order);
	
	public void delateNanOrder(NanOrder order);
	
	public DifOrder orderSubmit(DifOrder order);
	
	public DifOrder getDifOrder(Integer orderId);
	
	public DifOrder getDifOrder(String orderNo);
	
	public DifOrder updateDifOrderStatus(DifOrder order);
}
