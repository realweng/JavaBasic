package com.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/1-11:34
 * @Since:jdk1.8
 * @Description:分页工具类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> {
    private Integer nowPage; // 当前页
    private Integer pageNum; // 每页显示的数据条数
    private Integer countPage; // 总页数
    private Integer total; //数据总行数
    private Integer startIndex; // 起始下标

    private Integer startPage;// 起始页码
    private Integer endPage;// 结束的页码

    private List<T> data;// 分页数据

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageInfo(String nowPageStr, String pageNumStr, Integer total) {
        Integer nowPage = nowPageStr == null || "".equals(nowPageStr) ? 1 : Integer.valueOf(nowPageStr);
        Integer pageNum = pageNumStr == null || "".equals(pageNumStr) ? 6 : Integer.valueOf(pageNumStr);
        // 当前页
        this.nowPage = nowPage < 1 ? 1 : nowPage;
        // 每页显示的数据量
        this.pageNum = pageNum;
        this.total = total;
        // 总页数
        this.countPage = this.total % this.pageNum == 0 ? this.total / this.pageNum : this.total / this.pageNum + 1;

        // 计算当前页的值是否超过总页数
        this.nowPage = this.nowPage > this.countPage ? this.countPage : this.nowPage;
        // 起始下标
        this.startIndex = (this.nowPage - 1) * this.pageNum;

        // 计算起始页，如果nowPage-2小于1，起始页=1 如果nowPage-2大于1，起始页=nowPage-2
        this.startPage = this.nowPage - 3 < 1 ? 1 : this.nowPage - 2;
        // 计算结束页，如果nowPage+2大于总页数，结束=总页数。如果nowPage+2小于总页数，结束=nowPage+2
        this.endPage = this.nowPage + 2 > this.countPage ? this.countPage : this.nowPage + 2;
        // 起始页不足以减2
        if (this.endPage - this.startPage < 4 && this.endPage != this.countPage) {
            this.endPage = 5;
            this.endPage = this.endPage > this.countPage ? this.countPage : this.endPage;
        }
        //  结束页不足以加2
        if (this.endPage == this.countPage && this.endPage - this.startPage < 4) {
            this.startPage = this.endPage - 4;
            this.startPage = this.startPage < 1 ? 1 : this.startPage;
        }
    }
}