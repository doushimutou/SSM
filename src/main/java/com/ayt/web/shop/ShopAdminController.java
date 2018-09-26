package com.ayt.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: ayt
 * @Date: 2018/9/16 13:45
 * @Description: Don't worry ,just try
 */
@Controller
@RequestMapping(value = "shopadmin",method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "/shopoperation";
    }





}
