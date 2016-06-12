package com.tech.sayo.wechat.entity;

public class WechatJSConfig {

	private String appId;
	private String timestamp;
	private String nonceStr;
	private String signature;
	private String[] jsApiList = new String[] { "onMenuShareTimeline", "onMenuShareAppMessage", "onMenuShareQQ",
			"onMenuShareWeibo", "onMenuShareQZone", "startRecord", "stopRecord", "onVoiceRecordEnd", "playVoice",
			"pauseVoice", "stopVoice", "onVoicePlayEnd", "uploadVoice", "downloadVoice", "chooseImage", "previewImage",
			"uploadImage", "downloadImage", "translateVoice", "getNetworkType", "openLocation", "getLocation",
			"hideOptionMenu", "showOptionMenu", "hideMenuItems", "showMenuItems", "hideAllNonBaseMenuItem",
			"showAllNonBaseMenuItem", "closeWindow", "scanQRCode", "chooseWXPay", "openProductSpecificView", "addCard",
			"chooseCard", "openCard" };

	private String title = "零元汇";

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String[] getJsApiList() {
		return jsApiList;
	}

	public void setJsApiList(String[] jsApiList) {
		this.jsApiList = jsApiList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
