package com.tech.sayo.wechat.laundry.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tech.sayo.base.dao.BaseDao;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.util.OrderNoUtil;
import com.tech.sayo.wechat.account.bean.UserAddress;
import com.tech.sayo.wechat.laundry.bean.LadOrder;
import com.tech.sayo.wechat.laundry.bean.Laundry;
import com.tech.sayo.wechat.laundry.bean.RevOrder;
import com.tech.sayo.wechat.laundry.service.LaundryService;

@Service
public class LaundyServiceImpl implements LaundryService{
	
	private static final String LAUNDRY_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.laundry.dao.LaundryMapper.";
	private static final String LAD_REV_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.laundry.dao.RevOrderMapper.";
	private static final String LAD_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.laundry.dao.OrderMapper.";
	private static final String ADDRESS_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.account.bean.mapper.UserAddressMapper.";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Laundry getLaundry() {
		return baseDao.selectOne(LAUNDRY_ORDER_NAMESPACE_INFOUSER + "selectByTop1");
	}

	@Override
	public RevOrder submiRevtOrder(RevOrder order) {
		UserAddress address = baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",order.getOrderAddressid());
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("REVLAD"));
		order.setOrderStatusval(5);
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
	public RevOrder getOrder(Integer orderId) {
		return baseDao.selectOne(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getOrders(MyPage page, RevOrder order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount()).setOrderBy("a.order_id desc");
		return new MyPage().init(baseDao.selectList(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectByOrderStatus", order));
	}

	@Override
	public void updaOrderStaus(RevOrder order) {
		baseDao.modify(LAD_REV_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		LadOrder o = new LadOrder();
		o.setOrderStatusval(order.getOrderStatusval());
		o.setOrderRevorderid(order.getOrderId());
		baseDao.modify(LAD_ORDER_NAMESPACE_INFOUSER + "updateByRevOrderIdSelective", o);
	}

	@Override
	public void removeOrder(RevOrder order) {
		order.setOrderDeleted(1);
		baseDao.modify(LAD_REV_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public RevOrder getOrder(String orderNo) {
		return baseDao.selectOne(LAD_REV_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", orderNo);
	}

}
