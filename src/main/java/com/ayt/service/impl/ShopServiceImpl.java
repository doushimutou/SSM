package com.ayt.service.impl;

import com.ayt.dao.ShopDao;
import com.ayt.dto.ShopExecutionDto;
import com.ayt.entity.Shop;
import com.ayt.enums.ShopStateEnum;
import com.ayt.service.ShopService;
import com.ayt.utils.ImageUtil;
import com.ayt.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/13 00:04
 * @Description: Don't worry ,just try
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired(required = false)
    ShopDao shopDao;

    @Override
    public List<Shop> queryByOwnerId(Integer userId) {
        return shopDao.queryByOwnerId(userId);
    }

    @Override
    @Transactional
    public ShopExecutionDto addShop(Shop shop, CommonsMultipartFile shopImg) {
        //判断非空
        if (shop == null) {
            return new ShopExecutionDto(ShopStateEnum.NULL_SHOP);
        }

        try {
            //给shop赋初始值
            shop.setenableStatus(0);
            shop.setcreateTime(new Date());
            shop.setlastEditTime(new Date());
            //添加店铺信息
            int effctedNum = shopDao.insertShop(shop);
            //当创建失败时
            if (effctedNum <= 0) {
                throw new RuntimeException("店铺创建失败");
            } else {
                if (shopImg != null) {
                    try {
                        //存储图片
                        addShopImg(shop, shopImg);
                        //shop.getshopImg();

                    } catch (Exception e) {
                        throw new RuntimeException("图片存储失败" + e.getMessage());
                    }
                    //更新店铺的图片的地址
                    effctedNum = shopDao.updateShop(shop);
                    if (effctedNum <= 0) {
                        throw new RuntimeException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("addShop error" + e.getMessage());
        }
        return new ShopExecutionDto(ShopStateEnum.SUCCESS);
    }

    @Override
    public Shop getByShopId(Integer shopId) {

        return shopDao.queryByShopId(shopId);
    }

    @Override
    public ShopExecutionDto modifyShop(Shop shop, CommonsMultipartFile shopImg) {
        //判断是否需要处理图片
        try {
            if (shop == null || shop.getShopId() == null) {
                return new ShopExecutionDto(ShopStateEnum.NULL_SHOP);
            } else {
                if (shopImg != null) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getshopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getshopImg());
                    }
                    addShopImg(shop, shopImg);
                }
            }
            //更新店铺信息
            shop.setlastEditTime(new Date());
            int effectidNum = shopDao.updateShop(shop);
            if (effectidNum <= 0) {
                return new ShopExecutionDto(ShopStateEnum.INNER_ERROR);
            } else {
                shop = shopDao.queryByShopId(shop.getShopId());
                return new ShopExecutionDto(ShopStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw  e;
        }
    }


    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        //获取shop图片目录的相对子路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.gererateThumbnail(shopImg, dest);
        shop.setshopImg(shopImgAddr);

    }
}
