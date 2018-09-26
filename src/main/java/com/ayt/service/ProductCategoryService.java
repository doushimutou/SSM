package com.ayt.service;

import com.ayt.dto.ProductCategoryExecution;
import com.ayt.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/20 23:51
 * @Description: Don't worry ,just try
 */
public interface ProductCategoryService {
    /**
     * 通过shopid 查询商家的商品种类
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(Integer shopId);

    /**
     * 批量添加商品类别
     * @param productCategoryList
     * @return
     */
    ProductCategoryExecution addProductCategoryList(List<ProductCategory> productCategoryList);

    /**
     * 批量删除商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    ProductCategoryExecution deleteProductCategory(@Param("productCategoryId") Integer productCategoryId ,@Param("shopId") Integer shopId);
}
