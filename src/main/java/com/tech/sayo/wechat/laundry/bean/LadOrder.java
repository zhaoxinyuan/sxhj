package com.tech.sayo.wechat.laundry.bean;

import com.tech.sayo.background.sys.bean.SDictionary;

public class LadOrder {
    private Integer orderId;

    private String orderNo;

    private String orderDatetime;

    private Integer orderRevorderid;

    private String orderOrderno;

    private Double orderAmount;

    private Integer orderQty;

    private String orderFinished;

    private SDictionary orderStatus;
    
    private Integer orderStatusval;
    
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

	public Integer getOrderStatusval() {
		return orderStatusval;
	}

	public void setOrderStatusval(Integer orderStatusval) {
		this.orderStatusval = orderStatusval;
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

	public SDictionary getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(SDictionary orderStatus) {
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