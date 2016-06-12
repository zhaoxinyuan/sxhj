package com.ftc.wechat.store.bean;

import java.util.List;

import com.ftc.background.sys.bean.Status;

public class StrOrder {
    private Integer orderId;

    private String orderNo;

    private String orderDatetime;
    
    private Integer orderStatusid;
    
    private Status orderStatus;

    private Double orderPayableamount;

    private Double orderRealpayamount;

    private Double orderAmount;

    private Double orderDiscountamount;

    private String orderDiscountinfo;

    private Integer orderPaytype;

    private Integer orderPayid;

    private String orderDeliverytime;

    private Double orderDeliveryamount;

    private Integer orderInvoiceid;
    
    private Invoice orderInvoice;

    private Integer orderUserid;

    private Integer orderAddressid;

    private String orderAddressprovince;

    private String orderAddresscity;

    private String orderAddresscounty;

    private String orderAddressstreet;

    private String orderAddressconsignee;

    private String orderAddressmobile;

    private Integer orderDeleted;
    
    private List<StrOrderDetail> orderDetail;
    
    private String statusCode;
    
    private Integer orderStoreId;
    
    private Store orderStore;

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

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
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

    public String getOrderDeliverytime() {
        return orderDeliverytime;
    }

    public void setOrderDeliverytime(String orderDeliverytime) {
        this.orderDeliverytime = orderDeliverytime == null ? null : orderDeliverytime.trim();
    }

    public Double getOrderDeliveryamount() {
        return orderDeliveryamount;
    }

    public void setOrderDeliveryamount(Double orderDeliveryamount) {
        this.orderDeliveryamount = orderDeliveryamount;
    }

    public Integer getOrderInvoiceid() {
        return orderInvoiceid;
    }

    public void setOrderInvoiceid(Integer orderInvoiceid) {
        this.orderInvoiceid = orderInvoiceid;
    }
    
    public Invoice getOrderInvoice() {
		return orderInvoice;
	}

	public void setOrderInvoice(Invoice orderInvoice) {
		this.orderInvoice = orderInvoice;
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

	public List<StrOrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<StrOrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Integer getOrderStoreId() {
		return orderStoreId;
	}

	public void setOrderStoreId(Integer orderStoreId) {
		this.orderStoreId = orderStoreId;
	}

	public Store getOrderStore() {
		return orderStore;
	}

	public void setOrderStore(Store orderStore) {
		this.orderStore = orderStore;
	}
}