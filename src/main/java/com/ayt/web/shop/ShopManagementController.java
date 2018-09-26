package com.ayt.web.shop;

import com.alibaba.fastjson.JSON;
import com.ayt.dto.ShopExecutionDto;
import com.ayt.entity.Area;
import com.ayt.entity.PersonInfo;
import com.ayt.entity.Shop;
import com.ayt.entity.ShopCategory;
import com.ayt.enums.ShopStateEnum;
import com.ayt.service.AreaService;
import com.ayt.service.ShopCategoryService;
import com.ayt.service.ShopService;
import com.ayt.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ayt
 * @Date: 2018/9/16 13:49
 * @Description: Don't worry ,just try
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshoplist",method = RequestMethod.GET)
    @ResponseBody
    /**
     * 根据用户信息显示用户创建的店铺列表
     */
    public Map<String,Object> getShopList(HttpServletRequest httpServletRequest){
            Map<String,Object> modelMap = new HashMap<>();
            Integer userId =HttpServletRequestUtil.getInt(httpServletRequest,"userId");
           try {
               List<Shop> shopList = shopService.queryByOwnerId(userId);
               modelMap.put("success", true);
               modelMap.put("shops", shopList);
           }catch (Exception e){
               modelMap.put("success",false);
               modelMap.put("errMsg",e.toString());
           }

     return  modelMap;
    }

    @RequestMapping(value = "/getshopbyid",method =RequestMethod.GET )
    @ResponseBody
    public Map<String ,Object> getShopById(HttpServletRequest httpServletRequest){
        Map<String ,Object> modelMap= new HashMap<String,Object>();
        Integer shopId =HttpServletRequestUtil.getInt(httpServletRequest,"shopId");
        try {
            Shop shop=shopService.getByShopId(shopId);
            modelMap.put("shop",shop);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("errMsg",e.toString());
        }


        return  modelMap;
    }


    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getShopInitInfo(){
        Map<String ,Object> modelMap = new HashMap<String,Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area>  areaList = new ArrayList<Area>();
       try{
           shopCategoryList=shopCategoryService.queryShopCategory(new ShopCategory());
           areaList=areaService.getAreaList();
           modelMap.put("shopCategoryList",shopCategoryList);
           modelMap.put("areaList",areaList);
           modelMap.put("success",true);

       }catch (Exception e){
           modelMap.put("success",false);
           modelMap.put("errMsg",e.getMessage());
           return modelMap;

       }
        return modelMap;
    }





    @RequestMapping(value = "/registershop" ,method = RequestMethod.POST)
    @ResponseBody
    /**
     * httpserletRequest  包含通过http协议请求的信息
     */
    public Map<String,Object> registerShop(HttpServletRequest httpRequest){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        //接受并转换参数，店铺信息，图片信息
        String shopStr=HttpServletRequestUtil.getString(httpRequest,"shopStr");
        //JSON转POJO
        Shop shop = JSON.parseObject(shopStr,Shop.class);
        //获取前段传的文件流
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver =new CommonsMultipartResolver(httpRequest.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(httpRequest)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpRequest;
            shopImg= (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else {
            modelMap.put("success" ,false);
            modelMap.put("errMsg" ,"上传图片不能为空");
            return  modelMap;
        }
        //注册店铺
        if(shop!=null && shopImg!=null){
            PersonInfo personInfo=new PersonInfo();
            personInfo.setUserId(1L);
            ShopExecutionDto shopExecutionDto =shopService.addShop(shop,shopImg);
            if (shopExecutionDto.getState()== ShopStateEnum.CHECK.getState()){
                //返回结果
                modelMap.put("sucess",true);
            }
            return modelMap;

        }else {
            modelMap.put("success" ,false);
            modelMap.put("errMsg" ,"情输入店铺信息");
            return  modelMap;
        }


    }

    private  static  void inputStreamToFile(InputStream ins ,File file){
        FileOutputStream os=null;
        try {
            os = new FileOutputStream(file);
            int bytesRead=0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = ins.read(buffer))!=-1){
                os.write(buffer,0,bytesRead);
            }
        } catch (Exception e){
            throw  new RuntimeException("调用inputStreamToFile异常"+ e.getMessage());
        }
        finally {
            try{
            if (os!=null){
                os.close();
            }
            if(ins !=null){
                ins.close();
            }}catch (Exception e){
                throw  new RuntimeException("关闭IO异常"+ e.getMessage());
            }
        }


    }





}
