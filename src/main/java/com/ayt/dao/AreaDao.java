package com.ayt.dao;

import java.util.List;
import com.ayt.entity.Area;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 14:15
 * @Description: Don't worry ,just try
 */
public interface AreaDao {
    /**
     * 查询区域列表
     * @return
     */
    List<Area> queryArea();
}
