package com.ftc.wechat.clean.bean;

public class DifOrder {
    private Integer orderId;

    private String orderNo;

    private String orderDatetime;

    private Integer orderCleOrderid;

    private String orderCleOrderno;

    private Double orderAmount;

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

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}