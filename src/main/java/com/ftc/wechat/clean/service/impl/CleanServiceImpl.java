package com.ftc.wechat.clean.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.background.sys.bean.Status;
import com.ftc.base.dao.BaseDao;
import com.ftc.base.entity.MyPage;
import com.ftc.base.util.OrderNoUtil;
import com.ftc.wechat.account.bean.UserAddress;
import com.ftc.wechat.clean.bean.Category;
import com.ftc.wechat.clean.bean.NanOrder;
import com.ftc.wechat.clean.bean.Order;
import com.ftc.wechat.clean.bean.OrderDetail;
import com.ftc.wechat.clean.bean.Staff;
import com.ftc.wechat.clean.service.CleanService;
import com.github.pagehelper.PageHelper;

@Service
public class CleanServiceImpl implements CleanService{
	private static final String CLEAN_CATEGORY_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.CategoryMapper.";
	private static final String CLEAN_STAFF_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.StaffMapper.";
	private static final String CLEAN_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.OrderMapper.";
	private static final String CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.OrderDetailMapper.";
	private static final String CLEAN_ORDER_STATUS_NAMESPACE_INFOUSER = "com.ftc.background.sys.bean.StatusMapper.";
	private static final String ADDRESS_NAMESPACE_INFOUSER = "com.ftc.wechat.account.bean.mapper.UserAddressMapper.";
	private static final String NAN_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.NanOrderMapper.";

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<Category> getCleanCategories() {
		return baseDao.selectList(CLEAN_CATEGORY_NAMESPACE_INFOUSER + "selectByAll");
	}

	@Override
	public Category getCategory(Integer categoryId) {
		return baseDao.selectOne(CLEAN_CATEGORY_NAMESPACE_INFOUSER + "selectByPrimaryKey", categoryId);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Staff> getStaffs(MyPage page,Integer categoryId) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount());
		return baseDao.selectList(CLEAN_STAFF_NAMESPACE_INFOUSER + "selectByCategory", categoryId);
	}

	@Override
	public Staff getStaff(Integer staffId) {
		return baseDao.selectOne(CLEAN_STAFF_NAMESPACE_INFOUSER + "selectByPrimaryKey", staffId);
	}

	@Override
	public Order orderSubmit(Order order) {
		Status orderStatus = baseDao.selectOne(CLEAN_ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "cle_001");
		UserAddress address = baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",order.getOrderAddressid());
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("CLE"));
		order.setOrderStatusid(orderStatus.getStatusId());
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderServiceNumber(order.getOrderDetail().size());
		order.setOrderAddressprovince(address.getAddressProvince());
		order.setOrderAddresscity(address.getAddressCity());
		order.setOrderAddresscounty(address.getAddressCounty());
		order.setOrderAddressstreet(address.getAddressStreet());
		order.setOrderAddressconsignee(address.getAddressConsignee());
		order.setOrderAddressmobile(address.getAddressMobile());
		
		baseDao.insert(CLEAN_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		List<OrderDetail> detailList = order.getOrderDetail();
		order = baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo",order.getOrderNo());
		
		for (OrderDetail detail : detailList) {
			detail.setDetailOrderid(order.getOrderId());
			detail.setDetailOrderno(order.getOrderNo());
		}
		baseDao.insert(CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER + "insertByBatch", detailList);
		return order;
	}

	@Override
	public NanOrder orderSubmit(NanOrder order) {
		Status orderStatus = baseDao.selectOne(CLEAN_ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "nan_001");
		UserAddress address = baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",order.getOrderUseraddressid());
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(NAN_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("CLE"));
		order.setOrderStatusid(orderStatus.getStatusId());
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderAddressprovince(address.getAddressProvince());
		order.setOrderAddresscity(address.getAddressCity());
		order.setOrderAddresscounty(address.getAddressCounty());
		order.setOrderAddressstreet(address.getAddressStreet());
		order.setOrderAddressconsignee(address.getAddressConsignee());
		order.setOrderAddressmobile(address.getAddressMobile());
		
		baseDao.insert(NAN_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		return order;
	}

	@Override
	public List<OrderDetail> getStaffTimeOccupancy(Integer detailStaffid) {
		return baseDao.selectList(CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER + "selectStaffTimeOccupancy", detailStaffid);
	}

}