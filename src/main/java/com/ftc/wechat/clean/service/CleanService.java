package com.ftc.wechat.clean.service;

import java.util.List;

import com.ftc.base.entity.MyPage;
import com.ftc.wechat.clean.bean.Category;
import com.ftc.wechat.clean.bean.NanOrder;
import com.ftc.wechat.clean.bean.Order;
import com.ftc.wechat.clean.bean.OrderDetail;
import com.ftc.wechat.clean.bean.Staff;

public interface CleanService {

	public List<Category> getCleanCategories();
	
	public Category getCategory(Integer categoryId);
	
	@SuppressWarnings("rawtypes")
	public MyPage getStaffs(MyPage page,Integer categoryId);
	
	public Staff getStaff(Integer staffId);
	
	public Order orderSubmit(Order order);
	
	public NanOrder orderSubmit(NanOrder order);
	
	public List<OrderDetail> getStaffTimeOccupancy(Integer detailStaffid);
	
	@SuppressWarnings("rawtypes")
	public MyPage getOrders(MyPage page,Order order);
	
	@SuppressWarnings("rawtypes")
	public MyPage getNanOrders(MyPage page,NanOrder order);
	
	public Order getOrder(Integer orderId);
	
	public NanOrder getNanOrder(Integer orderId);
	
	public void cancelCleOrder(Order order);
	
	public void delateCleOrder(Order order);
	
	public void cancelNanOrder(NanOrder order);
	
	public void delateNanOrder(NanOrder order);
}
