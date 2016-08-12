package com.tech.sayo.wechat.clean.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tech.sayo.background.sys.bean.Status;
import com.tech.sayo.base.dao.BaseDao;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.util.OrderNoUtil;
import com.tech.sayo.wechat.account.bean.UserAddress;
import com.tech.sayo.wechat.clean.bean.Category;
import com.tech.sayo.wechat.clean.bean.CleNanOrderStaff;
import com.tech.sayo.wechat.clean.bean.CleOrder;
import com.tech.sayo.wechat.clean.bean.CleOrderDetail;
import com.tech.sayo.wechat.clean.bean.CleTipOrder;
import com.tech.sayo.wechat.clean.bean.DifOrder;
import com.tech.sayo.wechat.clean.bean.NanOrder;
import com.tech.sayo.wechat.clean.bean.Staff;
import com.tech.sayo.wechat.clean.service.CleanService;

@Service
public class CleanServiceImpl implements CleanService{
	private static final String CLEAN_CATEGORY_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.CategoryMapper.";
	private static final String CLEAN_STAFF_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.StaffMapper.";
	private static final String CLEAN_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.OrderMapper.";
	private static final String CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.OrderDetailMapper.";
	private static final String ORDER_STATUS_NAMESPACE_INFOUSER = "com.tech.sayo.background.sys.bean.StatusMapper.";
	private static final String ADDRESS_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.account.bean.mapper.UserAddressMapper.";
	private static final String NAN_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.NanOrderMapper.";
	private static final String NAN_STAFF_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.account.dao.CleNanOrderStaffMapper.";
	private static final String DIF_ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.clean.dao.DifOrderMapper.";
	private static final String TIP_ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.account.dao.CleTipOrderMapper.";

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
	public CleOrder orderSubmit(CleOrder order) {
		UserAddress address = baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",order.getOrderAddressid());
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("CLE"));
		order.setOrderStatusval(1);
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderServiceNumber(order.getOrderDetail().size());
		order.setOrderAddressprovince(address.getAddressProvince());
		order.setOrderAddresscity(address.getAddressCity());
		order.setOrderAddresscounty(address.getAddressCounty());
		order.setOrderAddressstreet(address.getAddressStreet());
		order.setOrderAddressconsignee(address.getAddressConsignee());
		order.setOrderAddressmobile(address.getAddressMobile());
		
		baseDao.insert(CLEAN_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		List<CleOrderDetail> detailList = order.getOrderDetail();
		order = baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo",order.getOrderNo());
		
		for (CleOrderDetail detail : detailList) {
			detail.setDetailOrderid(order.getOrderId());
			detail.setDetailOrderno(order.getOrderNo());
		}
		baseDao.insert(CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER + "insertByBatch", detailList);
		return order;
	}
	
	@Override
	public CleTipOrder orderSubmit(CleTipOrder order) {
		CleTipOrder temp = baseDao.selectOne(TIP_ORDER_NAMESPACE_INFOUSER + "selectByCleId", order.getOrderCleOrderid());
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		if(temp != null){
			temp.setOrderNo(uuid.toString());
			temp.setOrderAmount(order.getOrderAmount());
			temp.setOrderPaytype(order.getOrderPaytype());
			baseDao.modify(TIP_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective",temp);
			return temp;
		}else{
			order.setOrderNo(uuid.toString());
			order.setOrderStatusval(1);
			order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));		
			baseDao.insert(TIP_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
			return order;
		}
	}

	@Override
	public NanOrder orderSubmit(NanOrder order) {
		Status orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "nan_001");
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(NAN_ORDER_NAMESPACE_INFOUSER + "selectSerial");
		
		order.setOrderNo(orderNoUtil.createOrderNo("CLE"));
		order.setOrderStatusid(orderStatus.getStatusId());
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		if(order.getOrderInterviewtype() == 0){
			//上门
			UserAddress address = baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",order.getOrderUseraddressid());
			order.setOrderAddressprovince(address.getAddressProvince());
			order.setOrderAddresscity(address.getAddressCity());
			order.setOrderAddresscounty(address.getAddressCounty());
			order.setOrderAddressstreet(address.getAddressStreet());
			order.setOrderAddressconsignee(address.getAddressConsignee());
			order.setOrderAddressmobile(address.getAddressMobile());
		}else{
			order.setOrderInterviewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
		
		baseDao.insert(NAN_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		
		List<CleNanOrderStaff> list = new ArrayList<CleNanOrderStaff>();
		String[] array = order.getStaffIds().split(",");
		for (int i = 0; i < array.length; i++) {
			CleNanOrderStaff staff = new CleNanOrderStaff();
			staff.setOrderId(order.getOrderId());
			staff.setOrderStaffid(Integer.parseInt(array[i]));
			list.add(staff);
		}
		
		baseDao.insert(NAN_STAFF_ORDER_NAMESPACE_INFOUSER + "insertByBatch", list);
		return order;
	}

	@Override
	public List<CleOrderDetail> getStaffTimeOccupancy(Integer detailStaffid) {
		return baseDao.selectList(CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER + "selectStaffTimeOccupancy", detailStaffid);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getOrders(MyPage page, CleOrder order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount()).setOrderBy("order_id desc");
		MyPage myPage = new MyPage().init(baseDao.selectList(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByOrderStatus", order));
		if(myPage.getRows().size() >= 1){
			List<CleOrderDetail> details = baseDao.selectList(CLEAN_ORDER_DETAIL_NAMESPACE_INFOUSER + "selectByOrderIds", myPage.getRows());
			for (Object obj : myPage.getRows()) {
				CleOrder odr = (CleOrder)obj;
				for (CleOrderDetail det : details) {
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
	public CleOrder getOrder(Integer orderId) {
		return baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public NanOrder getNanOrder(Integer orderId) {
		return baseDao.selectOne(NAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public void updateCleOrderStatus(CleOrder order) {
		baseDao.modify(CLEAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void delateCleOrder(CleOrder order) {
		order.setOrderDeleted(1);
		baseDao.modify(CLEAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void cancelNanOrder(NanOrder order) {
		baseDao.modify(NAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void delateNanOrder(NanOrder order) {
		order.setOrderDeleted(1);
		baseDao.modify(NAN_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public DifOrder orderSubmit(DifOrder order) {
		DifOrder odr = baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByCleanId", order.getOrderCleOrderid());
		if(odr != null){
			odr.setOrderAmount(order.getOrderAmount());
			baseDao.modify(DIF_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", odr);
			return odr;
		}else{
			OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectSerial");
			
			order.setOrderNo(orderNoUtil.createOrderNo("DIF"));
			order.setOrderStatusval(1);
			order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			baseDao.insert(DIF_ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
			return baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", order.getOrderNo());
		}
	}

	@Override
	public DifOrder getDifOrder(Integer orderId) {
		return baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public CleOrder getOrderByDiff(Integer orderId) {
		DifOrder order = baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
		return baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", order.getOrderCleOrderid());
	}

	@Override
	public CleOrder getOrder(String orderNo) {
		return baseDao.selectOne(CLEAN_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", orderNo);
	}

	@Override
	public DifOrder updateDifOrderStatus(DifOrder order) {
		baseDao.modify(DIF_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
		return null;
	}

	@Override
	public DifOrder getDifOrder(String orderNo) {
		return baseDao.selectOne(DIF_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", orderNo);
	}

	@Override
	public CleTipOrder getOrderByTip(Integer orderId) {
		return baseDao.selectOne(TIP_ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public CleTipOrder getOrderByTip(String orderNo) {
		return baseDao.selectOne(TIP_ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", orderNo);
	}

	@Override
	public void updateCleTipOrderStatus(CleTipOrder order) {
		baseDao.modify(TIP_ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective",order);
	}
}
