package com.ayt.web;

import com.ayt.entity.Area;
import com.ayt.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.CacheAwareContextLoaderDelegate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 18:11
 * @Description: Don't worry ,just try
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private  AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listArea(){
        Logger logger = LoggerFactory.getLogger(AreaController.class);


        Map<String,Object> modelMap= new HashMap<String, Object>();
        List<Area> list = new ArrayList<Area>();
        try{
            list=areaService.getAreaList();
            modelMap.put("rows",list);
            modelMap.put("total",list.size());

        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }

    return  modelMap;



    }








}
