package com.java.wxg.service;

import com.java.wxg.bean.ProductType;
import com.java.wxg.bean.vo.RankVO;
import com.java.wxg.dao.RankStatisticsDao;
import com.java.wxg.dao.impl.RankStatisticsDaoImpl;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-23:34
 * @Since:jdk1.8
 * @Description:排行统计业务处理层
 */
public class RankStatisticsService {
    RankStatisticsDao rankStatisticsDao = new RankStatisticsDaoImpl();
    /**
     * 根据月份进行销量排行
     * @param month
     * @return
     */
    public List<RankVO> rankByMonth(Integer month){
        return rankStatisticsDao.rankByMonth(month);
    }

    /**
     * 根据商品种类进行排行
     * @param productTypeId 商品种类的id
     * @return
     */
    public List<RankVO> rankByProductType(Integer productTypeId){
        return rankStatisticsDao.rankByProductType(productTypeId);
    }

    /**
     * 查询订单表中存在商品的商品种类
     *
     * @return
     */
    public List<ProductType> findTypeInOrder() {
        return rankStatisticsDao.findTypeInOrder();
    }
}