package com.ayt.web.shop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ayt.dto.ProductCategoryExecution;
import com.ayt.entity.ProductCategory;
import com.ayt.enums.ProductCategoryStateEnum;
import com.ayt.service.ProductCategoryService;
import com.ayt.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ayt
 * @Date: 2018/9/21 00:03
 * @Description: Don't worry ,just try
 */
@Controller
@RequestMapping(value = "/pc")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = "/pclist")
    @ResponseBody
    public Map<String, Object> queryProductCategoryList(HttpServletRequest httpServletRequest) {
        Map<String, Object> modelmap = new HashMap<>();

        try {
            Integer shopId = HttpServletRequestUtil.getInt(httpServletRequest, "shopId");
            List<ProductCategory> productCategoryList = productCategoryService.queryProductCategoryList(shopId);
            modelmap.put("success", true);
            modelmap.put("productcategory", productCategoryList);
        } catch (Exception e) {
            modelmap.put("success", false);
            modelmap.put("errmsg", e.toString());
        }
        return modelmap;
    }

    @RequestMapping(value = "addproductcategory" ,method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public  Map<String ,Object> addProductCategorys(@RequestBody String json
    , HttpServletRequest request){
        List<ProductCategory> productCategoryList = JSONObject.parseArray(json,ProductCategory.class);
        Map<String, Object> modelMap= new HashMap<>();
        Integer shopId = HttpServletRequestUtil.getInt(request,"shopId");

        ProductCategoryExecution pe = productCategoryService.addProductCategoryList(productCategoryList);
        if(pe.getState()== ProductCategoryStateEnum.SUCCESS.getState()){
            modelMap.put("success",true);
        }else
        {
            modelMap.put("success",false);
            modelMap.put("errMsg",pe.getStateInfo());
        }
        return  modelMap;
    }
    @RequestMapping(value = "remove",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> removeProductCategory(Integer productCategoryId,Integer shopId){
        Map<String,Object> modelMap = new HashMap<>();
        ProductCategoryExecution pe= productCategoryService.deleteProductCategory(productCategoryId,shopId);

        if(pe.getState()==ProductCategoryStateEnum.SUCCESS.getState()){
            modelMap.put("success",true);
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg",pe.getStateInfo());
        }
        return modelMap;
    }
}
