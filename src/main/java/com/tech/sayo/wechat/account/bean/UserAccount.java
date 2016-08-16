package com.tech.sayo.wechat.account.bean;

public class UserAccount {
    private Integer accountId;

    private String accountDatetime;

    private Integer accountTypeid;

    private Double accountAmounts;

    private Integer accountUserid;

    private Integer accountPayid;

    private Integer accountRefundid;

    private String accountOrderno;
    
    private Integer orderid;
    
    private String ordercategory;
    
    private String typeCode;
    
    private String accountRemarks;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountDatetime() {
        return accountDatetime;
    }

    public void setAccountDatetime(String accountDatetime) {
        this.accountDatetime = accountDatetime == null ? null : accountDatetime.trim();
    }

    public Integer getAccountTypeid() {
        return accountTypeid;
    }

    public void setAccountTypeid(Integer accountTypeid) {
        this.accountTypeid = accountTypeid;
    }

    public Double getAccountAmounts() {
        return accountAmounts;
    }

    public void setAccountAmounts(Double accountAmounts) {
        this.accountAmounts = accountAmounts;
    }

    public Integer getAccountUserid() {
        return accountUserid;
    }

    public void setAccountUserid(Integer accountUserid) {
        this.accountUserid = accountUserid;
    }

    public Integer getAccountPayid() {
        return accountPayid;
    }

    public void setAccountPayid(Integer accountPayid) {
        this.accountPayid = accountPayid;
    }

    public Integer getAccountRefundid() {
        return accountRefundid;
    }

    public void setAccountRefundid(Integer accountRefundid) {
        this.accountRefundid = accountRefundid;
    }

    public String getAccountOrderno() {
        return accountOrderno;
    }

    public void setAccountOrderno(String accountOrderno) {
        this.accountOrderno = accountOrderno == null ? null : accountOrderno.trim();
    }

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getOrdercategory() {
		return ordercategory;
	}

	public void setOrdercategory(String ordercategory) {
		this.ordercategory = ordercategory;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getAccountRemarks() {
		return accountRemarks;
	}

	public void setAccountRemarks(String accountRemarks) {
		this.accountRemarks = accountRemarks;
	}
}