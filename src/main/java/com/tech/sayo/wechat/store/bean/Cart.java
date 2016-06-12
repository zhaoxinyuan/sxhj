package com.tech.sayo.wechat.store.bean;

public class Cart {
    private Integer cartId;

    private Integer cartProductid;

    private Integer cartQty;

    private String cartProductname;

    private Double cartProductprice;

    private String cartProductimage;

    private String cartProductSpec;

    private Integer cartUserid;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartProductid() {
        return cartProductid;
    }

    public void setCartProductid(Integer cartProductid) {
        this.cartProductid = cartProductid;
    }

    public Integer getCartQty() {
        return cartQty;
    }

    public void setCartQty(Integer cartQty) {
        this.cartQty = cartQty;
    }

    public String getCartProductname() {
        return cartProductname;
    }

    public void setCartProductname(String cartProductname) {
        this.cartProductname = cartProductname == null ? null : cartProductname.trim();
    }

    public Double getCartProductprice() {
        return cartProductprice;
    }

    public void setCartProductprice(Double cartProductprice) {
        this.cartProductprice = cartProductprice;
    }

    public String getCartProductimage() {
        return cartProductimage;
    }

    public void setCartProductimage(String cartProductimage) {
        this.cartProductimage = cartProductimage == null ? null : cartProductimage.trim();
    }

    public String getCartProductSpec() {
        return cartProductSpec;
    }

    public void setCartProductSpec(String cartProductSpec) {
        this.cartProductSpec = cartProductSpec == null ? null : cartProductSpec.trim();
    }

    public Integer getCartUserid() {
        return cartUserid;
    }

    public void setCartUserid(Integer cartUserid) {
        this.cartUserid = cartUserid;
    }
}