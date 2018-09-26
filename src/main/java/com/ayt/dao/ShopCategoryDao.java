package com.ayt.dao;

import com.ayt.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ayt
 * @Date: 2018/9/16 23:31
 * @Description: Don't worry ,just try
 */
public interface ShopCategoryDao {
    /**
     * 查询店铺种类
     * @param shopCategoryConditon
     * @return
     */
    List<ShopCategory>  queryShopCategory(@Param("shopCategoryConditon") ShopCategory shopCategoryConditon);





}
