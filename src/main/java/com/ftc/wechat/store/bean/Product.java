package com.ftc.wechat.store.bean;

public class Product {
    private Integer productId;

    private Integer productStoreId;

    private String productName;

    private Double productPrice;

    private Double productCostprice;

    private String productBrand;

    private String productSpec;

    private String productInfo;

    private String productImage;

    private Integer productCategoryid;

    private Integer productShelves;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(Integer productStoreId) {
        this.productStoreId = productStoreId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductCostprice() {
        return productCostprice;
    }

    public void setProductCostprice(Double productCostprice) {
        this.productCostprice = productCostprice;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand == null ? null : productBrand.trim();
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec == null ? null : productSpec.trim();
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo == null ? null : productInfo.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public Integer getProductCategoryid() {
        return productCategoryid;
    }

    public void setProductCategoryid(Integer productCategoryid) {
        this.productCategoryid = productCategoryid;
    }

    public Integer getProductShelves() {
        return productShelves;
    }

    public void setProductShelves(Integer productShelves) {
        this.productShelves = productShelves;
    }
}