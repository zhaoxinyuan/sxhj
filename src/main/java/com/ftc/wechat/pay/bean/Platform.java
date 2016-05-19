package com.ftc.wechat.pay.bean;

public class Platform {
    private Integer platformId;

    private String platformName;

    private String platformCode;

    private String platformImage;

    private String platformPayurl;

    private Integer platformEnable;

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode == null ? null : platformCode.trim();
    }

    public String getPlatformImage() {
        return platformImage;
    }

    public void setPlatformImage(String platformImage) {
        this.platformImage = platformImage == null ? null : platformImage.trim();
    }

    public String getPlatformPayurl() {
        return platformPayurl;
    }

    public void setPlatformPayurl(String platformPayurl) {
        this.platformPayurl = platformPayurl == null ? null : platformPayurl.trim();
    }

    public Integer getPlatformEnable() {
        return platformEnable;
    }

    public void setPlatformEnable(Integer platformEnable) {
        this.platformEnable = platformEnable;
    }
}