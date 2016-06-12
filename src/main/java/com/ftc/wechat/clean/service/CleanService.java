package com.ftc.wechat.clean.service;

import java.util.List;

import com.ftc.base.entity.MyPage;
import com.ftc.wechat.clean.bean.Category;
import com.ftc.wechat.clean.bean.DifOrder;
import com.ftc.wechat.clean.bean.NanOrder;
import com.ftc.wechat.clean.bean.CleOrder;
import com.ftc.wechat.clean.bean.CleOrderDetail;
import com.ftc.wechat.clean.bean.Staff;

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
	
	public NanOrder getNanOrder(Integer orderId);
	
	public void cancelCleOrder(CleOrder order);
	
	public void delateCleOrder(CleOrder order);
	
	public void cancelNanOrder(NanOrder order);
	
	public void delateNanOrder(NanOrder order);
	
	public DifOrder orderSubmit(DifOrder order);
	
	public DifOrder getDifOrder(Integer orderId);
}
