package com.ftc.wechat.laundry.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.background.sys.bean.Status;
import com.ftc.base.dao.BaseDao;
import com.ftc.base.entity.MyPage;
import com.ftc.base.util.OrderNoUtil;
import com.ftc.wechat.account.bean.UserAddress;
import com.ftc.wechat.laundry.bean.Order;
import com.ftc.wechat.laundry.bean.RevOrder;
import com.ftc.wechat.laundry.service.LaundryService;
import com.github.pagehelper.PageHelper;

@Service
public class LaundyServiceImpl implements LaundryService{
	private static final String LAD_REV_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.laundry.dao.RevOrderMapper.";
	private static final String LAD_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.laundry.dao.OrderMapper.";
	private static final String ORDER_STATUS_NAMESPACE_INFOUSER = "com.ftc.background.sys.bean.StatusMapper.";
	private static final String ADDRESS_NAMESPACE_INFOUSER = "com.ftc.wechat.account.bean.mapper.UserAddressMapper.";
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public RevOrder submiRevtOrder(RevOrder order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "lad_001");
		UserAddress address = baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",order.getOrderAddressid());
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("LAD"));
		order.setOrderStatusid(orderStatus.getStatusId());
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderAddressprovince(address.getAddressProvince());
		order.setOrderAddresscity(address.getAddressCity());
		order.setOrderAddresscounty(address.getAddressCounty());
		order.setOrderAddressstreet(address.getAddressStreet());
		order.setOrderAddressconsignee(address.getAddressConsignee());
		order.setOrderAddressmobile(address.getAddressMobile());
		
		baseDao.insert(LAD_REV_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		return baseDao.selectOne(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", order.getOrderNo());
	}

	@Override
	public RevOrder getRevOrder(Integer orderId) {	
		return baseDao.selectOne(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getRevOrders(MyPage page, RevOrder order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount());
		return new MyPage().init(baseDao.selectList(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectByOrderStatus", order));
	}

	@Override
	public void cancleRevOrder(RevOrder order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "odr_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		baseDao.modify(LAD_REV_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}


	@Override
	public Order getOrder(Integer orderId) {
		return baseDao.selectOne(LAD_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getOrders(MyPage page, Order order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount());
		return new MyPage().init(baseDao.selectList(LAD_ORDER_NAMESPACE_INFOUSER + "selectByOrderStatus", order));
	}

	@Override
	public void updaOrderStaus(Order order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", order.getStatusCode());
		order.setOrderStatusid(orderStatus.getStatusId());
		baseDao.modify(LAD_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	
}
