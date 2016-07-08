package com.tech.sayo.wechat.store.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.tech.sayo.base.dao.BaseDao;
import com.tech.sayo.base.entity.MyPage;
import com.tech.sayo.base.util.OrderNoUtil;
import com.tech.sayo.wechat.account.bean.UserAddress;
import com.tech.sayo.wechat.account.service.UserAddressService;
import com.tech.sayo.wechat.store.bean.Invoice;
import com.tech.sayo.wechat.store.bean.Store;
import com.tech.sayo.wechat.store.bean.StrOrder;
import com.tech.sayo.wechat.store.bean.StrOrderDetail;
import com.tech.sayo.wechat.store.entity.OrderTemp;
import com.tech.sayo.wechat.store.entity.ShoppingCartTemp;
import com.tech.sayo.wechat.store.service.StoreOrderService;

@Service
public class StrOrderServiceImpl implements StoreOrderService{
	
	private static final String ORDER_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.store.dao.OrderMapper.";
	private static final String ORDER_DETAIL_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.store.dao.OrderDetailMapper.";
	private static final String INVOICE_NAMESPACE_INFOUSER = "com.tech.sayo.wechat.store.dao.InvoiceMapper.";
	
	
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private UserAddressService addressService;

	@Override
	public OrderTemp creatOrder(List<ShoppingCartTemp> cart, Integer userId,Store store,Integer addressId) {
		OrderTemp order = new OrderTemp(); 
		order.setCart(cart);
		order.setProductAmount(order.getProductAmount());
		order.setDeliveryAmount(store.getStoreDeliveryamount());
		order.setAddress(addressId == null ? (UserAddress)addressService.getDefaultAddress(userId) : (UserAddress)addressService.getAddress(addressId));
		order.setOrderAmount(order.getOrderAmount());
		return order;
	}

	@Override
	public StrOrder submitOrder(OrderTemp orderTemp,StrOrder order,String invoiceTitle) {
		UUID tempId = UUID.randomUUID();
		Invoice invoice = null;
		if(invoiceTitle != null && invoiceTitle != ""){
			invoice = new Invoice();
			invoice.setInvoiceDatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			invoice.setInvoiceTitle(invoiceTitle);
			invoice.setInvoiceContent("舒心惠佳购物");
			invoice.setInvoiceAmount(orderTemp.getOrderAmount());
			invoice.setTempid(tempId.toString());
			baseDao.insert(INVOICE_NAMESPACE_INFOUSER + "insertSelective", invoice);
			invoice = baseDao.selectOne(INVOICE_NAMESPACE_INFOUSER + "selectByTempId",tempId.toString());
		}
		
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(ORDER_NAMESPACE_INFOUSER + "selectSerial");
		order.setOrderNo(orderNoUtil.createOrderNo("MKT"));
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderStatusval(1);
		order.setOrderPayableamount(orderTemp.getOrderAmount());
		order.setOrderRealpayamount(orderTemp.getOrderAmount());
		order.setOrderAmount(orderTemp.getProductAmount());
		order.setOrderDeliveryamount(orderTemp.getDeliveryAmount());
		order.setOrderInvoiceid(invoice != null ? invoice.getInvoiceId() : null);
		
		order.setOrderAddressid(orderTemp.getAddress().getAddressId());
		order.setOrderAddressprovince(orderTemp.getAddress().getAddressProvince());
		order.setOrderAddresscity(orderTemp.getAddress().getAddressCity());
		order.setOrderAddresscounty(orderTemp.getAddress().getAddressCounty());
		order.setOrderAddressstreet(orderTemp.getAddress().getAddressStreet());
		order.setOrderAddressconsignee(orderTemp.getAddress().getAddressConsignee());
		order.setOrderAddressmobile(orderTemp.getAddress().getAddressMobile());
		
		baseDao.insert(ORDER_NAMESPACE_INFOUSER + "insertSelective", order);
		order = baseDao.selectOne(ORDER_NAMESPACE_INFOUSER + "selectByOrderNo",order.getOrderNo());
		
		List<StrOrderDetail> orderDetail = new ArrayList<StrOrderDetail>();
		
		for (ShoppingCartTemp cart : orderTemp.getCart()) {
			StrOrderDetail detail = new StrOrderDetail();
			detail.setDetailOrderid(order.getOrderId());
			detail.setDetailOrderno(order.getOrderNo());
			detail.setDetailProductid(cart.getProductId());
			detail.setDetailProductcode(cart.getProductCode());
			detail.setDetailProductname(cart.getProductName());
			detail.setDetailProductprice(cart.getProductPrice());
			detail.setDetailProductimage(cart.getProductImage());
			detail.setDetailQty(cart.getProductQty());
			detail.setDetailAmount(cart.getProductAmt());
			orderDetail.add(detail);
		}
		order.setOrderDetail(orderDetail);
		baseDao.insert(ORDER_DETAIL_NAMESPACE_INFOUSER + "insertByBatch", orderDetail);
		return order;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public MyPage getOrders(MyPage page, StrOrder order) {
		PageHelper.startPage(page.getCurrent(), page.getRowCount()).setOrderBy("order_id desc");
		MyPage myPage = new MyPage().init(baseDao.selectList(ORDER_NAMESPACE_INFOUSER + "selectByOrderStatus", order));
		if(myPage.getRows().size() >= 1){
			List<StrOrderDetail> details = baseDao.selectList(ORDER_DETAIL_NAMESPACE_INFOUSER + "selectByOrderIds", myPage.getRows());
			for (Object obj : myPage.getRows()) {
				StrOrder odr = (StrOrder)obj;
				for (StrOrderDetail det : details) {
					if(odr.getOrderId().equals(det.getDetailOrderid())){
						odr.getOrderDetail().add(det);
					}
				}
			}
		}
		return myPage;
	}

	@Override
	public StrOrder getOrder(Integer orderId) {
		return baseDao.selectOne(ORDER_NAMESPACE_INFOUSER + "selectByPrimaryKey", orderId);
	}

	@Override
	public void updateOrderStatus(StrOrder order) {
		baseDao.modify(ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public void removeOrderStatus(StrOrder order) {
		baseDao.modify(ORDER_NAMESPACE_INFOUSER + "updateByPrimaryKeySelective", order);
	}

	@Override
	public StrOrder getOrder(String orderNo) {
		return baseDao.selectOne(ORDER_NAMESPACE_INFOUSER + "selectByOrderNo", orderNo);
	}

}
