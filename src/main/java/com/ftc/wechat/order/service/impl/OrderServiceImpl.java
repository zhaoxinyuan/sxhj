package com.ftc.wechat.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftc.base.dao.BaseDao;
import com.ftc.base.util.OrderNoUtil;
import com.ftc.wechat.account.bean.UserAddress;
import com.ftc.wechat.order.bean.Invoice;
import com.ftc.wechat.order.bean.Order;
import com.ftc.wechat.order.bean.OrderDetail;
import com.ftc.wechat.order.bean.OrderStatus;
import com.ftc.wechat.order.entity.OrderTemp;
import com.ftc.wechat.order.entity.ShoppingCartTemp;
import com.ftc.wechat.order.service.OrderService;
import com.ftc.wechat.store.bean.Store;

@Service
public class OrderServiceImpl implements OrderService{
	
	private static final String ADDRESS_NAMESPACE_INFOUSER = "com.ftc.wechat.account.bean.mapper.UserAddressMapper.";
	private static final String ORDER_NAMESPACE_INFOUSER = "com.ftc.wechat.order.dao.OrderMapper.";
	private static final String ORDER_STATUS_NAMESPACE_INFOUSER = "com.ftc.wechat.order.dao.OrderStatusMapper.";
	private static final String ORDER_DETAIL_NAMESPACE_INFOUSER = "com.ftc.wechat.order.dao.OrderDetailMapper.";
	private static final String INVOICE_NAMESPACE_INFOUSER = "com.ftc.wechat.order.dao.InvoiceMapper.";
	
	
	@Autowired
	private BaseDao baseDao;

	@Override
	public OrderTemp creatOrder(List<ShoppingCartTemp> cart, Integer userId,Store store,Integer addressId) {
		OrderTemp order = new OrderTemp(); 
		order.setCart(cart);
		order.setProductAmount(order.getProductAmount());
		order.setDeliveryAmount(store.getStoreDeliveryamount());
		order.setAddress(addressId == null ? (UserAddress)baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByUserDefault",userId) : (UserAddress)baseDao.selectOne(ADDRESS_NAMESPACE_INFOUSER + "selectByPrimaryKey",addressId));
		order.setOrderAmount(order.getOrderAmount());
		return order;
	}

	@Override
	public Order submitOrder(OrderTemp orderTemp,Order order,String invoiceTitle) {
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
		
		OrderStatus orderStatus = baseDao.selectOne(ORDER_STATUS_NAMESPACE_INFOUSER + "selectByStatusCode", "status_001") ;
		
		OrderNoUtil orderNoUtil = (OrderNoUtil)baseDao.selectOne(ORDER_NAMESPACE_INFOUSER + "selectSerial");
		order.setOrderNo(orderNoUtil.createOrderNo("MKT"));
		order.setOrderDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setOrderStatusid(orderStatus.getStatusId());
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
		
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		
		for (ShoppingCartTemp cart : orderTemp.getCart()) {
			OrderDetail detail = new OrderDetail();
			detail.setDetailOrderid(order.getOrderId());
			detail.setDetailOrderno(order.getOrderNo());
			detail.setDetailProductid(cart.getProductId());
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

}