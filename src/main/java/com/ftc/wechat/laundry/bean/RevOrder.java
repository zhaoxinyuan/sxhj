package com.ftc.wechat.laundry.bean;

import com.ftc.background.sys.bean.Status;

public class RevOrder {
    private Integer orderId;

    private String orderNo;

    private String orderDatetime;

    private Status orderStatus;
    
    private Integer orderStatusid;

    private Integer orderUserid;

    private String orderHometime;

    private Integer orderAddressid;

    private String orderAddressprovince;

    private String orderAddresscity;

    private String orderAddresscounty;

    private String orderAddressstreet;

    private String orderAddressconsignee;

    private String orderAddressmobile;

    private Integer orderDeleted;
    
    private String statusCode;
    
    private LadOrder order;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime == null ? null : orderDatetime.trim();
    }

    public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatusid() {
        return orderStatusid;
    }

    public void setOrderStatusid(Integer orderStatusid) {
        this.orderStatusid = orderStatusid;
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public String getOrderHometime() {
        return orderHometime;
    }

    public void setOrderHometime(String orderHometime) {
        this.orderHometime = orderHometime == null ? null : orderHometime.trim();
    }

    public Integer getOrderAddressid() {
        return orderAddressid;
    }

    public void setOrderAddressid(Integer orderAddressid) {
        this.orderAddressid = orderAddressid;
    }

    public String getOrderAddressprovince() {
        return orderAddressprovince;
    }

    public void setOrderAddressprovince(String orderAddressprovince) {
        this.orderAddressprovince = orderAddressprovince == null ? null : orderAddressprovince.trim();
    }

    public String getOrderAddresscity() {
        return orderAddresscity;
    }

    public void setOrderAddresscity(String orderAddresscity) {
        this.orderAddresscity = orderAddresscity == null ? null : orderAddresscity.trim();
    }

    public String getOrderAddresscounty() {
        return orderAddresscounty;
    }

    public void setOrderAddresscounty(String orderAddresscounty) {
        this.orderAddresscounty = orderAddresscounty == null ? null : orderAddresscounty.trim();
    }

    public String getOrderAddressstreet() {
        return orderAddressstreet;
    }

    public void setOrderAddressstreet(String orderAddressstreet) {
        this.orderAddressstreet = orderAddressstreet == null ? null : orderAddressstreet.trim();
    }

    public String getOrderAddressconsignee() {
        return orderAddressconsignee;
    }

    public void setOrderAddressconsignee(String orderAddressconsignee) {
        this.orderAddressconsignee = orderAddressconsignee == null ? null : orderAddressconsignee.trim();
    }

    public String getOrderAddressmobile() {
        return orderAddressmobile;
    }

    public void setOrderAddressmobile(String orderAddressmobile) {
        this.orderAddressmobile = orderAddressmobile == null ? null : orderAddressmobile.trim();
    }

    public Integer getOrderDeleted() {
        return orderDeleted;
    }

    public void setOrderDeleted(Integer orderDeleted) {
        this.orderDeleted = orderDeleted;
    }

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public LadOrder getOrder() {
		return order;
	}

	public void setOrder(LadOrder order) {
		this.order = order;
	}
}