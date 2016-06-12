package com.tech.sayo.wechat.clean.bean;

import java.util.List;

import com.tech.sayo.background.sys.bean.Status;

public class CleOrder {
    private Integer orderId;

    private String orderNo;
    
    private Category orderCategory;

    private Integer orderCategoryId;

    private String orderDatetime;

    private Integer orderServiceNumber;
    
    private Status orderStatus;

    private Integer orderStatusid;

    private Double orderPayableamount;

    private Double orderRealpayamount;

    private Double orderDiscountamount;

    private String orderDiscountinfo;

    private Integer orderPaytype;

    private Integer orderPayid;

    private Integer orderUserid;

    private Integer orderAddressid;

    private String orderAddressprovince;

    private String orderAddresscity;

    private String orderAddresscounty;

    private String orderAddressstreet;

    private String orderAddressconsignee;

    private String orderAddressmobile;

    private Integer orderDeleted;
    
    private Staff staff;
    
    private Integer orderStaffid;
    
    private List<CleOrderDetail> orderDetail;
    
    private DifOrder order;
    
    private String statusCode;

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

    public Category getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(Category orderCategory) {
		this.orderCategory = orderCategory;
	}

	public Integer getOrderCategoryId() {
		return orderCategoryId;
	}

	public void setOrderCategoryId(Integer orderCategoryId) {
		this.orderCategoryId = orderCategoryId;
	}

	public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime == null ? null : orderDatetime.trim();
    }

    public Integer getOrderServiceNumber() {
        return orderServiceNumber;
    }

    public void setOrderServiceNumber(Integer orderServiceNumber) {
        this.orderServiceNumber = orderServiceNumber;
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

    public Double getOrderPayableamount() {
        return orderPayableamount;
    }

    public void setOrderPayableamount(Double orderPayableamount) {
        this.orderPayableamount = orderPayableamount;
    }

    public Double getOrderRealpayamount() {
        return orderRealpayamount;
    }

    public void setOrderRealpayamount(Double orderRealpayamount) {
        this.orderRealpayamount = orderRealpayamount;
    }

    public Double getOrderDiscountamount() {
        return orderDiscountamount;
    }

    public void setOrderDiscountamount(Double orderDiscountamount) {
        this.orderDiscountamount = orderDiscountamount;
    }

    public String getOrderDiscountinfo() {
        return orderDiscountinfo;
    }

    public void setOrderDiscountinfo(String orderDiscountinfo) {
        this.orderDiscountinfo = orderDiscountinfo == null ? null : orderDiscountinfo.trim();
    }

    public Integer getOrderPaytype() {
        return orderPaytype;
    }

    public void setOrderPaytype(Integer orderPaytype) {
        this.orderPaytype = orderPaytype;
    }

    public Integer getOrderPayid() {
        return orderPayid;
    }

    public void setOrderPayid(Integer orderPayid) {
        this.orderPayid = orderPayid;
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
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

	public List<CleOrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<CleOrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Integer getOrderStaffid() {
		return orderStaffid;
	}

	public void setOrderStaffid(Integer orderStaffid) {
		this.orderStaffid = orderStaffid;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public DifOrder getOrder() {
		return order;
	}

	public void setOrder(DifOrder order) {
		this.order = order;
	}
}