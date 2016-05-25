package com.ftc.wechat.clean.bean;

public class OrderDetail {
    private Integer detailId;

    private Integer detailOrderid;

    private String detailOrderno;

    private Double detaiAmount;

    private Double detailServicePrice;

    private Integer detailServiceHours;

    private Integer detailServiceMetre;

    private String detailServiceFrom;

    private String detailServiceTo;

    private Integer detailType;

    private Integer detailStaffid;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailOrderid() {
        return detailOrderid;
    }

    public void setDetailOrderid(Integer detailOrderid) {
        this.detailOrderid = detailOrderid;
    }

    public String getDetailOrderno() {
        return detailOrderno;
    }

    public void setDetailOrderno(String detailOrderno) {
        this.detailOrderno = detailOrderno == null ? null : detailOrderno.trim();
    }

    public Double getDetaiAmount() {
        return detaiAmount;
    }

    public void setDetaiAmount(Double detaiAmount) {
        this.detaiAmount = detaiAmount;
    }

    public Double getDetailServicePrice() {
        return detailServicePrice;
    }

    public void setDetailServicePrice(Double detailServicePrice) {
        this.detailServicePrice = detailServicePrice;
    }

    public Integer getDetailServiceHours() {
        return detailServiceHours;
    }

    public void setDetailServiceHours(Integer detailServiceHours) {
        this.detailServiceHours = detailServiceHours;
    }

    public Integer getDetailServiceMetre() {
        return detailServiceMetre;
    }

    public void setDetailServiceMetre(Integer detailServiceMetre) {
        this.detailServiceMetre = detailServiceMetre;
    }

    public String getDetailServiceFrom() {
        return detailServiceFrom;
    }

    public void setDetailServiceFrom(String detailServiceFrom) {
        this.detailServiceFrom = detailServiceFrom == null ? null : detailServiceFrom.trim();
    }

    public String getDetailServiceTo() {
        return detailServiceTo;
    }

    public void setDetailServiceTo(String detailServiceTo) {
        this.detailServiceTo = detailServiceTo == null ? null : detailServiceTo.trim();
    }

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public Integer getDetailStaffid() {
        return detailStaffid;
    }

    public void setDetailStaffid(Integer detailStaffid) {
        this.detailStaffid = detailStaffid;
    }
}