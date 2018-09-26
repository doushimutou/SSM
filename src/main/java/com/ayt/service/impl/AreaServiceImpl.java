package com.ayt.service.impl;

import com.ayt.dao.AreaDao;
import com.ayt.entity.Area;
import com.ayt.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 16:24
 * @Description: Don't worry ,just try
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
