package com.ftc.wechat.laundry.bean;

import com.ftc.background.sys.bean.Status;

public class LadOrder {
    private Integer orderId;

    private String orderNo;

    private String orderDatetime;

    private Integer orderRevorderid;

    private String orderOrderno;

    private Double orderAmount;

    private Integer orderQty;

    private String orderFinished;

    private Status orderStatus;
    
    private Integer orderStatusid;
    
    private String statusCode;
    
    private Integer orderPaytype;

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

    public Integer getOrderRevorderid() {
        return orderRevorderid;
    }

    public void setOrderRevorderid(Integer orderRevorderid) {
        this.orderRevorderid = orderRevorderid;
    }

    public String getOrderOrderno() {
        return orderOrderno;
    }

    public void setOrderOrderno(String orderOrderno) {
        this.orderOrderno = orderOrderno == null ? null : orderOrderno.trim();
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderFinished() {
        return orderFinished;
    }

    public void setOrderFinished(String orderFinished) {
        this.orderFinished = orderFinished == null ? null : orderFinished.trim();
    }

    public Integer getOrderStatusid() {
        return orderStatusid;
    }

    public void setOrderStatusid(Integer orderStatusid) {
        this.orderStatusid = orderStatusid;
    }

	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Integer getOrderPaytype() {
		return orderPaytype;
	}

	public void setOrderPaytype(Integer orderPaytype) {
		this.orderPaytype = orderPaytype;
	}
	
}