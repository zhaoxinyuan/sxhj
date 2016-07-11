package com.tech.sayo.wechat.clean.bean;

public class Staff {
    private Integer staffId;

    private String staffCode;

    private String staffName;

    private Integer staffAge;

    private String staffImage;

    private String staffNativeplace;

    private String staffIdcode;

    private String staffMobile;

    private Integer staffStatusVal;
    
    private Integer staffServceQty;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }

    public String getStaffImage() {
        return staffImage;
    }

    public void setStaffImage(String staffImage) {
        this.staffImage = staffImage == null ? null : staffImage.trim();
    }

    public String getStaffNativeplace() {
        return staffNativeplace;
    }

    public void setStaffNativeplace(String staffNativeplace) {
        this.staffNativeplace = staffNativeplace == null ? null : staffNativeplace.trim();
    }

    public String getStaffIdcode() {
        return staffIdcode;
    }

    public void setStaffIdcode(String staffIdcode) {
        this.staffIdcode = staffIdcode == null ? null : staffIdcode.trim();
    }

    public String getStaffMobile() {
        return staffMobile;
    }

    public void setStaffMobile(String staffMobile) {
        this.staffMobile = staffMobile == null ? null : staffMobile.trim();
    }

	public Integer getStaffStatusVal() {
		return staffStatusVal;
	}

	public void setStaffStatusVal(Integer staffStatusVal) {
		this.staffStatusVal = staffStatusVal;
	}

	public Integer getStaffServceQty() {
		return staffServceQty;
	}

	public void setStaffServceQty(Integer staffServceQty) {
		this.staffServceQty = staffServceQty;
	}
}