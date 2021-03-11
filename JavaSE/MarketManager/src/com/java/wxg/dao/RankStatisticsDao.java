package com.java.wxg.dao;

import com.java.wxg.bean.ProductType;
import com.java.wxg.bean.vo.RankVO;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-23:33
 * @Since:jdk1.8
 * @Description:排行统计的接口
 */
public interface RankStatisticsDao {
    /**
     * 根据月份进行销量排行
     * @param month
     * @return
     */
    public List<RankVO> rankByMonth(Integer month);

    /**
     * 根据商品种类进行排行
     * @param productTypeId 商品种类的id
     * @return
     */
    public List<RankVO> rankByProductType(Integer productTypeId);

    /**
     * 查询订单表中存在商品的商品种类
     * @return
     */
    public List<ProductType> findTypeInOrder();
}
