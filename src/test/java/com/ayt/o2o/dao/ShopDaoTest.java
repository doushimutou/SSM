package com.ayt.o2o.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ayt.BaseTest;
import com.ayt.dao.ShopDao;
import com.ayt.entity.Area;
import com.ayt.entity.PersonInfo;
import com.ayt.entity.Shop;
import com.ayt.entity.ShopCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Auther: ayt
 * @Date: 2018/9/11 00:30
 * @Description: Don't worry ,just try
 */

public class ShopDaoTest extends BaseTest {
    Logger logger = LoggerFactory.getLogger(ShopDaoTest.class);
    @Autowired(required = false)
    ShopDao shopDao;

    @Test
    @Ignore
    public void InsertShopTest() {

        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo personInfo = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        area.setAreaId(2);
        personInfo.setUserId(1L);

        shop.setshopName("沙县小吃");
        shop.setAdvice("正在审核");
        shop.setshopDesc("沙县小吃很好吃");
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setenableStatus(1);
        shop.setcreateTime(new Date());
        shop.setlastEditTime(new Date());
        shop.setPersonInfo(personInfo);
        shop.setPhone("13212344321");
        shop.setshopAddr("testaddr1");
        shop.setshopImg("test1");

        shopDao.insertShop(shop);
        // logger.info(String.valueOf(shopDao.insertShop(shop)));
    }

    @Test
    @Ignore
    public void updateShop() {
        Shop shop = new Shop();
        shop.setShopId(1);

        shop.setshopName("沙县小吃更新");
        shop.setAdvice("正在审核ing");
        shop.setshopDesc("沙县小吃很好吃,试试");

        shopDao.updateShop(shop);
    }

    @Test
    public void queryByShopID() {
        Shop shop = shopDao.queryByShopId(1);
        String shop1 = JSONObject.toJSONString(shop);
        logger.info(shop1);
    }
}
