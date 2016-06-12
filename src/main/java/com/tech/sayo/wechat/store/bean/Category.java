package com.tech.sayo.wechat.store.bean;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private Integer categoryStoreid;

    private String categoryUpdatetime;

    private Integer categoryIndex;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getCategoryStoreid() {
        return categoryStoreid;
    }

    public void setCategoryStoreid(Integer categoryStoreid) {
        this.categoryStoreid = categoryStoreid;
    }

    public String getCategoryUpdatetime() {
        return categoryUpdatetime;
    }

    public void setCategoryUpdatetime(String categoryUpdatetime) {
        this.categoryUpdatetime = categoryUpdatetime == null ? null : categoryUpdatetime.trim();
    }

    public Integer getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(Integer categoryIndex) {
        this.categoryIndex = categoryIndex;
    }
}