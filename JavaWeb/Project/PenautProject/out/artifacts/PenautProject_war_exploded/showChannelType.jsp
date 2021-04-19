<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>渠道分类管理</title>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
        <link rel="stylesheet" type="text/css" href="css/main2.css" />
        <script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://cdn.bootcdn.net/ajax/libs/element-ui/2.15.1/index.min.js"></script>
    </head>
</head>
<body>
<div id="channel" style="width: 1200px;">
    <%--  添加分类  --%>
    <el-button type="success" plain>添加渠道分类</el-button>
        <div><br /></div>
    <!-- 表格数据 -->
    <el-table :data="channelTypeEntityList" style="width: 1260px" height="200px" stripe border>
        <el-table-column prop="userName" label="分类名称">
        </el-table-column>
        <el-table-column prop="pwd" label="父级">
        </el-table-column>
        <el-table-column prop="sex" label="创建时间">
        </el-table-column>
        <el-table-column label="操作" align="center" min-width="100">
            <el-button type="info">修改</el-button>
            <el-button type="info">删除</el-button>
        </el-table-column>
    </el-table>
    <!-- 分页信息 -->
    <div align="right">
        <el-pagination :current-page="pageInfo.currentPage" :page-sizes="pageInfo.pageSizes"
                       :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="pageInfo.total"
                       @size-change="sizeChanger" @current-change="currentChange">
        </el-pagination>
    </div>
</div>

<script type="text/javascript">
    var channelType = {
        data() {
            return {
                data: {
                    channelTypeEntityList: [],
                    pageInfo: {
                        "total": 6, // 总条数
                        "pageSizes": [3, 6, 9, 12], // 当前页的下拉列表
                        "pageSize": 3, // 显示几页
                        "currentPage": 2 // 当前页
                    }
                }
            }
        },
        methods: {
            sizeChanger(value) { // value：每页显示几条数据
                console.log(this.pageInfo.sizeChanger + "，" + value);


                getData("");
            },
            currentChange(value) { // value:当前页
                console.log(this.pageInfo.currentPage + "，" + value);

                getData("");
            },
            getData(param) { // param:传递到服务器的值
                // 通过ajax发送请求到服务，查询用户信息（数据格式json）（当前页）
                // 将服务器放回的数据赋值给data中channelTypeEntityList
                // 将分页数据赋值
            }

        },
        mounted:function() {
            // 查询渠道种类中的数据
            getData("");
        }
    };

    var  vueChannelType = Vue.extend(channelType);
    new vueChannelType().$mount("");
</script>
</body>
</html>