package com.ayt.o2o.dao;

import com.alibaba.fastjson.JSONObject;
import com.ayt.BaseTest;
import com.ayt.dao.AreaDao;
import com.ayt.dao.ShopCategoryDao;
import com.ayt.entity.Area;
import com.ayt.entity.ShopCategory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/16 23:42
 * @Description: Don't worry ,just try
 */

public class ShopCategoryDaoTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(ShopDaoTest.class);
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setParentId(1l);
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(shopCategory);
        String jsonString = JSONObject.toJSONString(shopCategories);
        logger.info(jsonString);

    }
}
