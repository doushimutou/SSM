package com.ayt.service.impl;

import com.ayt.dao.ProductCategoryDao;
import com.ayt.dto.ProductCategoryExecution;
import com.ayt.entity.ProductCategory;
import com.ayt.enums.ProductCategoryStateEnum;
import com.ayt.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/20 23:53
 * @Description: Don't worry ,just try
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired(required = false)
    ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> queryProductCategoryList(Integer shopId) {
        return productCategoryDao.queryByShopId(shopId);
    }

    /**
     * 批量添加商品类别
     *
     * @param productCategoryList
     * @return
     */
    @Override
    public ProductCategoryExecution addProductCategoryList(List<ProductCategory> productCategoryList) {

        if (productCategoryList != null && productCategoryList.size() > 0) {
            try {
                int state = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (state <= 0) {
                    System.out.println("插入数据库失败");
                    return  new ProductCategoryExecution(ProductCategoryStateEnum.FAILED);
                } else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }
            } catch (Exception e) {
                return new ProductCategoryExecution(ProductCategoryStateEnum.FAILED);
            }
        } else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.NULL_PRODUCTCATEGORY);
        }
    }

    /**
     * 批量删除商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     */
    @Override
    public ProductCategoryExecution deleteProductCategory(Integer productCategoryId, Integer shopId) {

        try{
        int effectNum =productCategoryDao.deleteProductCategory(productCategoryId,shopId);
        if (effectNum<=0){
            throw new RuntimeException("店铺类别删除失败");
        }else {
            return  new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

}
