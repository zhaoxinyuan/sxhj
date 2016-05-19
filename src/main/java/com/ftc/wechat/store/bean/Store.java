package com.ftc.wechat.store.bean;

import java.util.List;

public class Store {
	private Integer storeId;

	private String storeName;

	private String storeServicetimeFrom;
	
	private String storeServicetimeTo;

	private String storeAddress;

	private String storeNumber;

	private Double storeMinimums;

	private Double storeDeliveryamount;

	private String storeImage;

	private String storeBmapLng;

	private String storeBmapLat;

	private List<Category> categories;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName == null ? null : storeName.trim();
	}

	public String getStoreServicetimeFrom() {
		return storeServicetimeFrom;
	}

	public void setStoreServicetimeFrom(String storeServicetimeFrom) {
		this.storeServicetimeFrom = storeServicetimeFrom == null ? null : storeServicetimeFrom.trim();
	}

	public String getStoreServicetimeTo() {
		return storeServicetimeTo;
	}

	public void setStoreServicetimeTo(String storeServicetimeTo) {
		this.storeServicetimeTo = storeServicetimeTo == null ? null : storeServicetimeTo.trim();
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress == null ? null : storeAddress.trim();
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber == null ? null : storeNumber.trim();
	}

	public Double getStoreMinimums() {
		return storeMinimums;
	}

	public void setStoreMinimums(Double storeMinimums) {
		this.storeMinimums = storeMinimums;
	}

	public Double getStoreDeliveryamount() {
		return storeDeliveryamount;
	}

	public void setStoreDeliveryamount(Double storeDeliveryamount) {
		this.storeDeliveryamount = storeDeliveryamount;
	}

	public String getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage == null ? null : storeImage.trim();
	}

	public String getStoreBmapLng() {
		return storeBmapLng;
	}

	public void setStoreBmapLng(String storeBmapLng) {
		this.storeBmapLng = storeBmapLng == null ? null : storeBmapLng.trim();
	}

	public String getStoreBmapLat() {
		return storeBmapLat;
	}

	public void setStoreBmapLat(String storeBmapLat) {
		this.storeBmapLat = storeBmapLat == null ? null : storeBmapLat.trim();
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}