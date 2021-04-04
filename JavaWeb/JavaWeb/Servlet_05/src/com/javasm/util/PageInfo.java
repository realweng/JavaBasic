package com.javasm.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/4/1-10:02
 * @Since:jdk1.8
 * @Description:TODO
 */
@NoArgsConstructor
@Getter
public class PageInfo<T> {

    private Integer nowPage;//  当前页
    private Integer pageNum;// 每页显示几条数据
    private Integer countPge;// 总页数
    private Integer total;// 总条数
    private Integer startIndex;// 起始下标

    private Integer startPage;// 起始页码
    private Integer endPage;// 结束的页码


    private List<T> data;// 分页数据

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageInfo(Integer nowPage, Integer pageNum, Integer total) {
        // 当前页
        this.nowPage = nowPage < 1 ? 1 : nowPage;
        // 每页显示的数据量
        this.pageNum = pageNum < 3 ? 3 : pageNum;
        this.total = total;
        // 总页数
        this.countPge = this.total % this.pageNum == 0 ? this.total / this.pageNum : this.total / this.pageNum + 1;

        // 计算当前页的值是否超过总页数
        this.nowPage = this.nowPage > this.countPge ? this.countPge : this.nowPage;
        // 起始下标
        this.startIndex = (this.nowPage - 1) * this.pageNum;

        // 计算起始页，如果nowPage-2小于1，起始页=1 如果nowPage-2大于1，起始页=nowPage-2
        this.startPage = this.nowPage - 3 < 1 ? 1 : this.nowPage - 2;
        // 计算结束页，如果nowPage+2大于总页数，结束=总页数。如果nowPage+2小于总页数，结束=nowPage+2
        this.endPage = this.nowPage + 2 > this.countPge ? this.countPge : this.nowPage + 2;
        // 起始页不足以减2
        if (this.endPage - this.startPage < 4 && this.endPage != this.countPge) {
            this.endPage = 5;
            this.endPage = this.endPage > this.countPge ? this.countPge : this.endPage;
        }
        //  结束页不足以加2
        if (this.endPage == this.countPge && this.endPage - this.startPage < 4) {
            this.startPage = this.endPage - 4;
        }


    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "nowPage=" + nowPage +
                ", pageNum=" + pageNum +
                ", countPge=" + countPge +
                ", total=" + total +
                ", startIndex=" + startIndex +
                '}';
    }
}
