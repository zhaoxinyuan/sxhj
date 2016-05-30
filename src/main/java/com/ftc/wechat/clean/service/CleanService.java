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
	public List<Staff> getStaffs(MyPage page,Integer categoryId);
	
	public Staff getStaff(Integer staffId);
	
	public Order orderSubmit(Order order);
	
	public NanOrder orderSubmit(NanOrder order);
	
	public List<OrderDetail> getStaffTimeOccupancy(Integer detailStaffid);
}
