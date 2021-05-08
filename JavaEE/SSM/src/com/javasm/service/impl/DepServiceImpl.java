package com.javasm.service.impl;

import com.javasm.dao.DepDao;
import com.javasm.entity.Emp;
import com.javasm.service.DepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:24
 * @Since:jdk1.8
 * @Description:TODO
 */
@Service
public class DepServiceImpl implements DepService {
    @Resource
    private DepDao depDao;
    /**
     * 联表查询 通过部门id获取该部门下的所有员工
     *
     * @param depId
     * @return
     */
    @Override
    public List<Emp> getDepEmps(Integer depId) {
        return depDao.getDepEmps(depId);
    }
}