package com.ayt.service;

import com.ayt.entity.ShopCategory;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/17 22:43
 * @Description: Don't worry ,just try
 */
public interface ShopCategoryService {
    List<ShopCategory> queryShopCategory (ShopCategory shopCategoryCondition);
}
