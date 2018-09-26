package com.ayt.dao;

import com.ayt.entity.Shop;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/11 00:09
 * @Description: Don't worry ,just try
 */
public interface ShopDao {
    /**
     * 插入一条商家
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新商家
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 通过商家ID查询商家信息
     * @param shopId
     * @return
     */
    Shop queryByShopId(Integer shopId);
    /**
     * 根据用户信息查询用户创建的店铺列表
     */
    List<Shop> queryByOwnerId(Integer userId);


}
