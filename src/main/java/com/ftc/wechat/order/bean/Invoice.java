package com.ftc.wechat.order.bean;

public class Invoice {
    private Integer invoiceId;

    private String invoiceDatetime;

    private String invoiceTitle;

    private String invoiceContent;

    private Double invoiceAmount;
    
    private String tempid;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDatetime() {
        return invoiceDatetime;
    }

    public void setInvoiceDatetime(String invoiceDatetime) {
        this.invoiceDatetime = invoiceDatetime == null ? null : invoiceDatetime.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getInvoiceContent() {
        return invoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent == null ? null : invoiceContent.trim();
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

	public String getTempid() {
		return tempid;
	}

	public void setTempid(String tempid) {
		this.tempid = tempid;
	}
}