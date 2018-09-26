package com.ayt.entity;

import java.util.Date;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 00:13
 * @Description: Don't worry ,just try
 * 店铺表
 */
public class Shop {
    private Integer shopId;
    private  PersonInfo personInfo;
    private Area area;
    private ShopCategory shopCategory;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private Integer enableStatus;
    private String advice;


    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getshopName() {
        return shopName;
    }

    public void setshopName(String shopName) {
        this.shopName = shopName;
    }

    public String getshopDesc() {
        return shopDesc;
    }

    public void setshopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getshopAddr() {
        return shopAddr;
    }

    public void setshopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getshopImg() {
        return shopImg;
    }

    public void setshopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getcreateTime() {
        return createTime;
    }

    public void setcreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getlastEditTime() {
        return lastEditTime;
    }

    public void setlastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Integer getenableStatus() {
        return enableStatus;
    }

    public void setenableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
