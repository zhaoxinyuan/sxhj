package com.ftc.wechat.pay.bean;

public class PayDetail {
    private Integer payId;

    private String payDatetime;

    private Integer payOrderid;

    private String payOrderno;

    private Integer payPlatformid;

    private Double payAmount;

    private String payPlatformTradeno;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(String payDatetime) {
        this.payDatetime = payDatetime == null ? null : payDatetime.trim();
    }

    public Integer getPayOrderid() {
        return payOrderid;
    }

    public void setPayOrderid(Integer payOrderid) {
        this.payOrderid = payOrderid;
    }

    public String getPayOrderno() {
        return payOrderno;
    }

    public void setPayOrderno(String payOrderno) {
        this.payOrderno = payOrderno == null ? null : payOrderno.trim();
    }

    public Integer getPayPlatformid() {
        return payPlatformid;
    }

    public void setPayPlatformid(Integer payPlatformid) {
        this.payPlatformid = payPlatformid;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayPlatformTradeno() {
        return payPlatformTradeno;
    }

    public void setPayPlatformTradeno(String payPlatformTradeno) {
        this.payPlatformTradeno = payPlatformTradeno == null ? null : payPlatformTradeno.trim();
    }
}