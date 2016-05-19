package com.ftc.wechat.account.bean;

public class UserAddress {
    private Integer addressId;

    private Integer addressUserid;

    private String addressConsignee;

    private String addressMobile;

    private String addressProvince;

    private String addressCity;

    private String addressCounty;

    private String addressStreet;

    private Integer addressDefault;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getAddressUserid() {
        return addressUserid;
    }

    public void setAddressUserid(Integer addressUserid) {
        this.addressUserid = addressUserid;
    }

    public String getAddressConsignee() {
        return addressConsignee;
    }

    public void setAddressConsignee(String addressConsignee) {
        this.addressConsignee = addressConsignee == null ? null : addressConsignee.trim();
    }

    public String getAddressMobile() {
        return addressMobile;
    }

    public void setAddressMobile(String addressMobile) {
        this.addressMobile = addressMobile == null ? null : addressMobile.trim();
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty == null ? null : addressCounty.trim();
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet == null ? null : addressStreet.trim();
    }

    public Integer getAddressDefault() {
        return addressDefault;
    }

    public void setAddressDefault(Integer addressDefault) {
        this.addressDefault = addressDefault;
    }
    
}