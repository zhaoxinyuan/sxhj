package com.tech.sayo.background.sys.bean;

import java.util.Date;

public class SUser {
    private Integer id;

    private Integer orgId;

    private String userName;

    private String email;

    private String fullname;

    private Integer status;

    private Integer employeeId;

    private String password;

    private Date passwordStartDate;

    private Date passwordExpireDate;

    private Integer passwordExpireDays;

    private Date passwordSetDate;

    private String canUpdatePassword;

    private String comments;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    private Integer deleteFlag;

    private Integer isInterface;

    private Integer isAdmin;

    private Integer isCheckin;

    private String tqNum;
    
    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getPasswordStartDate() {
        return passwordStartDate;
    }

    public void setPasswordStartDate(Date passwordStartDate) {
        this.passwordStartDate = passwordStartDate;
    }

    public Date getPasswordExpireDate() {
        return passwordExpireDate;
    }

    public void setPasswordExpireDate(Date passwordExpireDate) {
        this.passwordExpireDate = passwordExpireDate;
    }

    public Integer getPasswordExpireDays() {
        return passwordExpireDays;
    }

    public void setPasswordExpireDays(Integer passwordExpireDays) {
        this.passwordExpireDays = passwordExpireDays;
    }

    public Date getPasswordSetDate() {
        return passwordSetDate;
    }

    public void setPasswordSetDate(Date passwordSetDate) {
        this.passwordSetDate = passwordSetDate;
    }

    public String getCanUpdatePassword() {
        return canUpdatePassword;
    }

    public void setCanUpdatePassword(String canUpdatePassword) {
        this.canUpdatePassword = canUpdatePassword == null ? null : canUpdatePassword.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getIsInterface() {
        return isInterface;
    }

    public void setIsInterface(Integer isInterface) {
        this.isInterface = isInterface;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Integer isCheckin) {
        this.isCheckin = isCheckin;
    }

    public String getTqNum() {
        return tqNum;
    }

    public void setTqNum(String tqNum) {
        this.tqNum = tqNum == null ? null : tqNum.trim();
    }

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}