package com.tech.sayo.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNoUtil {

	private Integer serial;
	private String orderNo;

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String createOrderNo(String business) {
		this.orderNo = business + new SimpleDateFormat("yyyyMMdd").format(new Date()) + (int)(Math.random()*99);
		for (int i = 0; i < 4 - serial.toString().length(); i++) {
			this.orderNo += "0";
		}
		return this.orderNo + this.serial;
	}
}
