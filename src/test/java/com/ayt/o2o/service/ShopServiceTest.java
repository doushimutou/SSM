package com.ayt.o2o.service;

import com.ayt.BaseTest;
import com.ayt.entity.Area;
import com.ayt.entity.PersonInfo;
import com.ayt.entity.Shop;
import com.ayt.entity.ShopCategory;
import com.ayt.enums.ShopStateEnum;
import com.ayt.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * @Author: ayt
 * @Date: 2018/9/13 01:01
 * @Description: Don't worry ,just try
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    ShopService shopService;
    @Test
    public  void addShop() throws FileNotFoundException {
        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo personInfo = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        area.setAreaId(2);
        personInfo.setUserId(1L);


        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setPersonInfo(personInfo);
        shop.setshopName("沙县小吃test");
        shop.setAdvice("正在审核test");
        shop.setshopDesc("沙县小吃很好吃test");
        shop.setenableStatus(ShopStateEnum.CHECK.getState());
        shop.setcreateTime(new Date());
        shop.setlastEditTime(new Date());
        shop.setPhone("13212344321");
        shop.setshopAddr("testaddr1");
        shop.setAdvice("审核中");

       // File file = new File("F:\\springboot\\img\\shuiyin.jpg");
        String shopimg ="F:\\springboot\\img\\xiao.jpg";

//        shopService.addShop(shop,shopimg);
    }
}
