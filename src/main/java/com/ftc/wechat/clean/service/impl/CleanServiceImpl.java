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
import com.ftc.wechat.clean.bean.DifOrder;
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
	private static final String ORDER_STATUS_NAMESPACE_INFOUSER = "com.ftc.background.sys.bean.StatusMapper.";
	private static final String ADDRESS_NAMESPACE_INFOUSER = "com.ftc.wechat.account.bean.mapper.UserAddressMapper.";
	private static final String NAN_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.NanOrderMapper.";
	private static final String DIF_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.clean.dao.DifOrderMapper.";

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getStaffs(MyPage page,Integer categoryId) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount());
		return new MyPage().init(baseDao.selectList(CLEAN_STAFF_NAMESPACE_INFOUSER + "selectByCategory", categoryId));
	}

	@Override
	public Staff getStaff(Integer staffId) {
		return baseDao.selectOne(CLEAN_STAFF_NAMESPACE_INFOUSER + "selectByPrimaryKey", staffId);
	}

	@Override
	public Order orderSubmit(Order order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "cle_001");
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
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "nan_001");
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getOrders(MyPage page, Order order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount()).setOrderBy("order_id desc");;
		MyPage myPage = new MyPage().init(baseDao.selectList(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByOrderStatus", order));
		if(myPage.getRows().size() >= 1){
			List<OrderDetail> details = baseDao.selectList(CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER + "selectByOrderIds", myPage.getRows());
			for (Object obj : myPage.getRows()) {
				Order odr = (Order)obj;
				for (OrderDetail det : details) {
					if(odr.getOrderId() == det.getDetailOrderid()){
						odr.getOrderDetail().add(det);
					}
				}
			}
		}
		return myPage;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getNanOrders(MyPage page, NanOrder order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount());
		return new MyPage().init(baseDao.selectList(NAN_ORDER_NAMESPACE_INFOUSER + "selectOrders", order));
	}

	@Override
	public Order getOrder(Integer orderId) {
		return baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public NanOrder getNanOrder(Integer orderId) {
		return baseDao.selectOne(NAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public void cancelCleOrder(Order order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "odr_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		baseDao.modify(CLEAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void delateCleOrder(Order order) {
		order.setOrderDeleted(1);
		baseDao.modify(CLEAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void cancelNanOrder(NanOrder order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "odr_002");
		order.setOrderStatusid(orderStatus.getStatusId());
		baseDao.modify(NAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void delateNanOrder(NanOrder order) {
		order.setOrderDeleted(1);
		baseDao.modify(NAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public DifOrder orderSubmit(DifOrder order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "dif_001");
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("DIF"));
		order.setOrderStatusid(orderStatus.getStatusId());
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		baseDao.insert(DIF_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		return baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", order.getOrderNo());
	}

	@Override
	public DifOrder getDifOrder(Integer orderId) {
		return baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

}
