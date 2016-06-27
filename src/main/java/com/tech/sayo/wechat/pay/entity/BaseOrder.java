package com.tech.sayo.wechat.pay.entity;

import com.tech.sayo.base.entity.MyStatus;

public class BaseOrder {

	private Integer OrderId;// 订单id
	private String orderBusiness;// 订单类型
	private String body; // 支付标题
	private int total;// 支付金额 单位:分
	private String orderNo;// 订单号
	private String callback;
	private MyStatus status;

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public String getOrderBusiness() {
		return orderBusiness;
	}

	public void setOrderBusiness(String orderBusiness) {
		this.orderBusiness = orderBusiness;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public MyStatus getStatus() {
		return status;
	}

	public void setStatus(MyStatus status) {
		this.status = status;
	}

}
