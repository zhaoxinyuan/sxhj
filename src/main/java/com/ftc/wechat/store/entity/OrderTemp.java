package com.ftc.wechat.store.entity;

import java.util.List;

import com.ftc.wechat.account.bean.UserAddress;

public class OrderTemp {
	
	private UserAddress address;
	private List<ShoppingCartTemp> cart;
	private Double productAmount;
	private Double deliveryAmount;
	private Double orderAmount;
	
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	public List<ShoppingCartTemp> getCart() {
		return cart;
	}
	public void setCart(List<ShoppingCartTemp> cart) {
		this.cart = cart;
	}
	public Double getProductAmount() {
		if(this.productAmount == null){
			for (ShoppingCartTemp cart : cart) {
				this.productAmount = (this.productAmount == null ? 0 : this.productAmount) + cart.getProductAmt();
			}
		}
		return productAmount;
	}
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
	public Double getDeliveryAmount() {
		return deliveryAmount;
	}
	public void setDeliveryAmount(Double deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}
	public Double getOrderAmount() {
		orderAmount = this.productAmount + this.deliveryAmount;
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
}
