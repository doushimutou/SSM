package com.ayt.dao;

import com.ayt.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/20 23:18
 * @Description: Don't worry ,just try
 */

public interface ProductCategoryDao {
    /**
     * 通过商家ID查询商品类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryByShopId(Integer shopId);

    /**
     *批量添加商品类别
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory (List<ProductCategory> productCategoryList);

    /**
     * 删除商品类别
     * @param productCategory
     * @param shopId
     * @return
     */
    int deleteProductCategory(
            @Param("productCategory") int productCategory ,@Param("shopId") int shopId);


}
