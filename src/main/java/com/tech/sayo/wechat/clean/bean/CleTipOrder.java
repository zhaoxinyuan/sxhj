package com.tech.sayo.wechat.clean.bean;

import java.util.Date;

import com.tech.sayo.background.sys.bean.SDictionary;

public class CleTipOrder {
    private Integer orderId;

    private String orderNo;

    private Integer orderCleOrderid;

    private String orderCleOrderno;

    private String orderDatetime;

    private Integer orderStatusval;

    private Double orderAmount;

    private Integer orderPaytype;

    private Integer orderUserid;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    private Integer deleteFlag;
    
    private SDictionary orderStatus;

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

    public Integer getOrderCleOrderid() {
        return orderCleOrderid;
    }

    public void setOrderCleOrderid(Integer orderCleOrderid) {
        this.orderCleOrderid = orderCleOrderid;
    }

    public String getOrderCleOrderno() {
        return orderCleOrderno;
    }

    public void setOrderCleOrderno(String orderCleOrderno) {
        this.orderCleOrderno = orderCleOrderno == null ? null : orderCleOrderno.trim();
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public Integer getOrderStatusval() {
        return orderStatusval;
    }

    public void setOrderStatusval(Integer orderStatusval) {
        this.orderStatusval = orderStatusval;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderPaytype() {
        return orderPaytype;
    }

    public void setOrderPaytype(Integer orderPaytype) {
        this.orderPaytype = orderPaytype;
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public SDictionary getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(SDictionary orderStatus) {
		this.orderStatus = orderStatus;
	}
}