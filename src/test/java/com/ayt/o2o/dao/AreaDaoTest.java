package com.ayt.o2o.dao;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ayt.BaseTest;
import com.ayt.dao.AreaDao;
import com.ayt.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 14:31
 * @Description: Don't worry ,just try
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        String jsonString = JSONObject.toJSONString(areaList);
        System.out.println(jsonString);

    }

}
