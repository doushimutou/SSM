package com.ayt.dto;

import com.ayt.entity.Shop;
import com.ayt.enums.ShopStateEnum;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/12 23:33
 * @Description: Don't worry ,just try
 */
public class ShopExecutionDto {
    //结果状态
    private  int state ;
    //状态标识
    private  String stateInfo;
    //店铺数量
    private  int count ;
    //店铺,增删改shop
    private Shop shop;
    //查询店铺列表
    private List<Shop> shopList;

    public  ShopExecutionDto() {}

    //店铺操作失败的时候的构造器
    public  ShopExecutionDto(ShopStateEnum stateEnum){
        this.state =stateEnum.getState() ;
        this.stateInfo=stateEnum.getStateInfo();
    }
    //店铺操作成功的时候的构造器
    public  ShopExecutionDto(ShopStateEnum stateEnum,Shop shop){
        this.state =stateEnum.getState() ;
        this.stateInfo=stateEnum.getStateInfo();
        this.shop=shop;
    }
    //成功的时候的构造器,一组商家
    public  ShopExecutionDto(ShopStateEnum stateEnum,List<Shop> shopList){
        this.state =stateEnum.getState() ;
        this.stateInfo=stateEnum.getStateInfo();
        this.shopList =shopList;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }



}
