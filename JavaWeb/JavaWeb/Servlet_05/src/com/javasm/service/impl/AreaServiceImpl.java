package com.javasm.service.impl;

import com.javasm.dao.AreaDao;
import com.javasm.dao.impl.AreaDaoImpl;
import com.javasm.entity.Area;
import com.javasm.service.AreaService;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/4/2-17:01
 * @Since:jdk1.8
 * @Description:TODO
 */
public class AreaServiceImpl implements AreaService {

    private AreaDao areaDao = new AreaDaoImpl();

    @Override
    public List<Area> showAreaByLevel(Integer level) {
        return areaDao.findAreaByLevel(level);
    }

    @Override
    public List<Area> showAreaByParentId(Integer parentId) {
        return areaDao.findAreaByParentId(parentId);
    }
}
