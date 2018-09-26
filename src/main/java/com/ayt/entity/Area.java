package com.ayt.entity;

import java.util.Date;

/**
 * @Auther: ayt
 * @Date: 2018/9/7 23:31
 * @Description: Don't worry ,just try
 * 区域实体类
 */
public class Area {
    //区域名称
    private Integer areaId;
    //区域名称
    private String areaName;
    //区域权重
    private  Integer priority;
    //创建时间
    private Date createTime;
    //最后更新时间
    private  Date lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }





}
