package com.ftc.wechat.store.entity;

public class ShoppingCartTemp {

	private Integer productId;
	private String productName;
	private String productImage;
	private Double productPrice;
	private Integer productQty;
	private Double productAmt;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public Double getProductAmt() {
		return productAmt;
	}

	public void setProductAmt(Double productAmt) {
		this.productAmt = productAmt;
	}
}
