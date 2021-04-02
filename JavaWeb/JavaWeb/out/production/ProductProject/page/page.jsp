<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-sm-2">
        <select class="form-control" style="margin: 5px" name="pageNum" id="pageNum">
            <option value="3" ${requestScope.pageNum == 3?"selected":""}>3</option>
            <option value="6" ${requestScope.pageNum == 6?"selected":""}>6</option>
            <option value="9" ${requestScope.pageNum == 9?"selected":""}>9</option>
        </select>
        <input type="hidden" name="nowPage1" id="nowPage1"/>
</div>

<nav aria-label="Page navigation">
    <ul id="pageInfo" class="pager pagination-sm">
        <li data-nowPage="1"><a href="javascript:void(0)">首页</a></li>
        <li data-nowPage="${pageData.nowPage-1}"><a href="javascript:void(0)">上一页</a></li>
        <li> ${pageData.nowPage}/${pageData.countPage} </li>
        <li data-nowPage="${pageData.nowPage+1}"><a href="javascript:void(0)">下一页</a></li>
        <li data-nowPage="${pageData.countPage}"><a href="javascript:void(0)">尾页</a></li>
    </ul>
</nav>