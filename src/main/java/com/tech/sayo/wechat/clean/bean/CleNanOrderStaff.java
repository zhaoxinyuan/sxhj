package com.tech.sayo.wechat.clean.bean;

public class CleNanOrderStaff {
    private Integer id;

    private Integer orderId;

    private Integer orderStaffid;
    
    private Staff staff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStaffid() {
        return orderStaffid;
    }

    public void setOrderStaffid(Integer orderStaffid) {
        this.orderStaffid = orderStaffid;
    }

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}