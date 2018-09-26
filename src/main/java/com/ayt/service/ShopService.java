package com.ayt.service;

import com.ayt.dto.ShopExecutionDto;
import com.ayt.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/13 00:02
 * @Description: Don't worry ,just try
 */
public interface ShopService {
    /**
     * 根据用户信息查询用户创建的店铺列表
     * @param userId
     */
    List<Shop> queryByOwnerId(Integer userId);


    /**
     * 添加店铺，包括更新图片
     * @param shop
     * @param ShopImg
     * @return
     */
    ShopExecutionDto addShop(Shop shop, CommonsMultipartFile ShopImg);

    /**
     * 通过商家ID查询店铺
     * @param shopId
     * @return
     */
    Shop getByShopId (Integer shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     * @param shop
     * @param ShopImg
     * @return
     */
    ShopExecutionDto modifyShop(Shop shop,CommonsMultipartFile ShopImg);



}
