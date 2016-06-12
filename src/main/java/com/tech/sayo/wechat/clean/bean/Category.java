package com.tech.sayo.wechat.clean.bean;

public class Category {
    private Integer categoryId;

    private String categoryCode;

    private String categoryName;

    private Double categoryPrice;

    private Integer categoryPriceUnit;

    private String categoryImage;

    private String categoryServicetimeFrom;

    private String categoryServicetimeTo;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Double getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(Double categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    public Integer getCategoryPriceUnit() {
        return categoryPriceUnit;
    }

    public void setCategoryPriceUnit(Integer categoryPriceUnit) {
        this.categoryPriceUnit = categoryPriceUnit;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage == null ? null : categoryImage.trim();
    }

    public String getCategoryServicetimeFrom() {
        return categoryServicetimeFrom;
    }

    public void setCategoryServicetimeFrom(String categoryServicetimeFrom) {
        this.categoryServicetimeFrom = categoryServicetimeFrom == null ? null : categoryServicetimeFrom.trim();
    }

    public String getCategoryServicetimeTo() {
        return categoryServicetimeTo;
    }

    public void setCategoryServicetimeTo(String categoryServicetimeTo) {
        this.categoryServicetimeTo = categoryServicetimeTo == null ? null : categoryServicetimeTo.trim();
    }
}