package com.ftc.wechat.clean.bean;

import com.ftc.background.sys.bean.Status;

public class NanOrder {
    private Integer orderId;

    private String orderNo;

    private String orderDatetime;
    
    private Category orderCategory;

    private Integer orderCategoryid;

    private Status orderStatus;
    
    private Integer orderStatusid;

    private Staff staff;
    
    private Integer orderStaffid;

    private String orderInterviewtime;

    private Integer orderUserid;

    private Integer orderUseraddressid;

    private String orderAddressprovince;

    private String orderAddresscity;

    private String orderAddresscounty;

    private String orderAddressstreet;

    private String orderAddressconsignee;

    private String orderAddressmobile;

    private Integer orderDeleted;

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

    public Category getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(Category orderCategory) {
		this.orderCategory = orderCategory;
	}

	public Integer getOrderCategoryid() {
        return orderCategoryid;
    }

    public void setOrderCategoryid(Integer orderCategoryid) {
        this.orderCategoryid = orderCategoryid;
    }

    public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Integer getOrderStatusid() {
        return orderStatusid;
    }

    public void setOrderStatusid(Integer orderStatusid) {
        this.orderStatusid = orderStatusid;
    }

    public Integer getOrderStaffid() {
        return orderStaffid;
    }

    public void setOrderStaffid(Integer orderStaffid) {
        this.orderStaffid = orderStaffid;
    }

    public String getOrderInterviewtime() {
        return orderInterviewtime;
    }

    public void setOrderInterviewtime(String orderInterviewtime) {
        this.orderInterviewtime = orderInterviewtime == null ? null : orderInterviewtime.trim();
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public Integer getOrderUseraddressid() {
        return orderUseraddressid;
    }

    public void setOrderUseraddressid(Integer orderUseraddressid) {
        this.orderUseraddressid = orderUseraddressid;
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
}