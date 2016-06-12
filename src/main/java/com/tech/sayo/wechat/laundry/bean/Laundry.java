package com.tech.sayo.wechat.laundry.bean;

public class Laundry {
    private Integer laundryId;

    private String laundryName;

    private String laundryNumber;

    private String laundryAddress;

    private String laundryServicetimeFrom;

    private String laundryServicetimeTo;

    public Integer getLaundryId() {
        return laundryId;
    }

    public void setLaundryId(Integer laundryId) {
        this.laundryId = laundryId;
    }

    public String getLaundryName() {
        return laundryName;
    }

    public void setLaundryName(String laundryName) {
        this.laundryName = laundryName == null ? null : laundryName.trim();
    }

    public String getLaundryNumber() {
        return laundryNumber;
    }

    public void setLaundryNumber(String laundryNumber) {
        this.laundryNumber = laundryNumber == null ? null : laundryNumber.trim();
    }

    public String getLaundryAddress() {
        return laundryAddress;
    }

    public void setLaundryAddress(String laundryAddress) {
        this.laundryAddress = laundryAddress == null ? null : laundryAddress.trim();
    }

    public String getLaundryServicetimeFrom() {
        return laundryServicetimeFrom;
    }

    public void setLaundryServicetimeFrom(String laundryServicetimeFrom) {
        this.laundryServicetimeFrom = laundryServicetimeFrom == null ? null : laundryServicetimeFrom.trim();
    }

    public String getLaundryServicetimeTo() {
        return laundryServicetimeTo;
    }

    public void setLaundryServicetimeTo(String laundryServicetimeTo) {
        this.laundryServicetimeTo = laundryServicetimeTo == null ? null : laundryServicetimeTo.trim();
    }
}