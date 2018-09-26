package com.ayt.o2o.service;

import com.ayt.BaseTest;
import com.ayt.entity.Area;
import com.ayt.service.AreaService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 16:32
 * @Description: Don't worry ,just try
 */
public class AreaServiceTest extends BaseTest {
    @Autowired
    AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> list=areaService.getAreaList();
        list.get(0).getAreaName();
    }
}
