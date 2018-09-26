package com.ayt.service.impl;

import com.ayt.dao.ShopCategoryDao;
import com.ayt.entity.ShopCategory;
import com.ayt.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/17 22:45
 * @Description: Don't worry ,just try
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> queryShopCategory(ShopCategory shopCategoryCondition) {

        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
