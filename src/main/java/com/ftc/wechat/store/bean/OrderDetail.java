package com.ftc.wechat.store.bean;

public class OrderDetail {
    private Integer detailId;

    private Integer detailOrderid;

    private String detailOrderno;

    private Integer detailProductid;

    private Integer detailQty;

    private Double detailAmount;

    private String detailProductname;

    private Double detailProductprice;

    private String detailProductimage;

    private String detailProductspec;
    
    private Product detailProduct;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailOrderid() {
        return detailOrderid;
    }

    public void setDetailOrderid(Integer detailOrderid) {
        this.detailOrderid = detailOrderid;
    }

    public String getDetailOrderno() {
        return detailOrderno;
    }

    public void setDetailOrderno(String detailOrderno) {
        this.detailOrderno = detailOrderno == null ? null : detailOrderno.trim();
    }

    public Integer getDetailProductid() {
        return detailProductid;
    }

    public void setDetailProductid(Integer detailProductid) {
        this.detailProductid = detailProductid;
    }

    public Integer getDetailQty() {
        return detailQty;
    }

    public void setDetailQty(Integer detailQty) {
        this.detailQty = detailQty;
    }

    public Double getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(Double detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getDetailProductname() {
        return detailProductname;
    }

    public void setDetailProductname(String detailProductname) {
        this.detailProductname = detailProductname == null ? null : detailProductname.trim();
    }

    public Double getDetailProductprice() {
        return detailProductprice;
    }

    public void setDetailProductprice(Double detailProductprice) {
        this.detailProductprice = detailProductprice;
    }

    public String getDetailProductimage() {
        return detailProductimage;
    }

    public void setDetailProductimage(String detailProductimage) {
        this.detailProductimage = detailProductimage == null ? null : detailProductimage.trim();
    }

    public String getDetailProductspec() {
        return detailProductspec;
    }

    public void setDetailProductspec(String detailProductspec) {
        this.detailProductspec = detailProductspec == null ? null : detailProductspec.trim();
    }

	public Product getDetailProduct() {
		return detailProduct;
	}

	public void setDetailProduct(Product detailProduct) {
		this.detailProduct = detailProduct;
	}
}