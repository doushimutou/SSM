package com.ayt.dto;

import com.ayt.entity.ProductCategory;
import com.ayt.enums.ProductCategoryStateEnum;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/23 22:02
 * @Description: Don't worry ,just try
 */
public class ProductCategoryExecution {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //批量添加商品种类
    private List<ProductCategory> productCategoryList;

    public ProductCategoryExecution(ProductCategoryStateEnum success){

    }
    //失败的时候使用的构造器
    public ProductCategoryExecution(int state,String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }
    //操作成功的时候返回的构造器
    public ProductCategoryExecution (ProductCategoryStateEnum stateEnum,List<ProductCategory> productCategoryList){

        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.productCategoryList=productCategoryList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
