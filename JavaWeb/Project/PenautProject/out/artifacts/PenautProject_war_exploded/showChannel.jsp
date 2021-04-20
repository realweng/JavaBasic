<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOC html>
<html>
<head>
    <meta charset="utf-8">
    <title>渠道管理</title>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
        <link rel="stylesheet" type="text/css" href="css/main2.css"/>
        <script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://cdn.bootcdn.net/ajax/libs/element-ui/2.15.1/index.min.js"></script>
    </head>
</head>
<body>
<div id="channel" style="width: 1300px;">
    <%--  添加分类  --%>
    <el-button @click="addDialog = true" type="success" plain>添加渠道</el-button>
    <%--  条件查询的表单  --%>
    <el-form :inline="true" :model="showParams" class="demo-form-inline">

        <el-form-item label="渠道种类">
            <el-cascader v-model="value" :options="options" :props="{ expandTrigger: 'hover' }" @change="handleChange">
            </el-cascader>
        </el-form-item>
        <el-form-item label="渠道号">
            <el-input v-model="showParams.channelNumber" placeholder="渠道号"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="">查询</el-button>
        </el-form-item>
    </el-form>
    <!-- 表格数据 -->
    <el-table :data="channelEntityList" style="width: 1290px" height="300px" stripe border>
        <el-table-column prop="Name" label="分类名称">
        </el-table-column>
        <el-table-column prop="parentName" label="父级">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间">
        </el-table-column>
        <el-table-column label="操作" width="140">
            <template slot-scope="scope">
                <el-button @click="initUpdate(scope.$index)" type="text" size="small">添加下载地址</el-button>
                <el-button type="text" size="small" @click="deleteConfirm = true">删除</el-button>
                <el-dialog title="提示" :visible.sync="deleteConfirm" width="30%" center>
                    <span>你确定删除该条数据吗？</span>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="deleteConfirm = false">取 消</el-button>
                        <el-button type="primary"
                                   @click="deleteConfirm = false;deleteChannel(scope.$index)">确 定</el-button>
                    </span>
                </el-dialog>
            </template>
        </el-table-column>
    </el-table>
    <!-- 分页信息 -->
    <div align="right">
        <!--
        layout：sizes->每页显示几条数据  prev->上一页  pager->页码  next->下一页  jumper->跳转到某一页
     -->
        <el-pagination background @prev-click="currentChange" @next-click="currentChange"
                       @current-change="currentChange" @size-change="sizeChange"
                       layout="sizes, prev, pager, next, jumper"
                       :page-sizes="[3, 6, 9]" :total="pageInfo.total" :page-size="pageInfo.pageSize"
                       :current-page="pageInfo.page">
        </el-pagination>
    </div>

    <%-- 添加渠道种类的对话框 --%>
    <el-dialog width="400px" title="添加渠道" :visible.sync="addDialog">
        <el-form :model="addParams" :rules="rules" ref="addParams">
            <el-form-item label="分类名称" :label-width="formLabelWidth" prop="Name">
                <el-input style="width: 220px" v-model="addParams.Name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="父级" :label-width="formLabelWidth" prop="parentId">
                <el-select style="width: 220px" v-model="addParams.parentId" placeholder="请选择">
                    <el-option key="0" label="无父级" value="0"></el-option>
                    <%--          从数据库中查渠道种类          --%>
                    <el-option v-for="item in channelEntityList" :key="item.id" :label="item.Name"
                               :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="创建时间" :label-width="formLabelWidth">
                <el-date-picker v-model="addParams.createTime" type="datetime" placeholder="选择日期时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="备注" :label-width="formLabelWidth">
                <el-input style="width: 220px" v-model="addParams.note" autocomplete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="addDialog = false">取 消</el-button>
            <el-button type="primary" @click="addChannel(addParams)">确 定</el-button>
        </div>
    </el-dialog>

    <%-- 修改渠道种类的对话框 --%>
    <el-dialog width="400px" title="修改渠道" :visible.sync="updateDialog">
        <el-form :model="updateParams" :rules="rules" ref="updateParams">
            <el-form-item label="分类名称" :label-width="formLabelWidth" prop="Name">
                <el-input style="width: 220px" v-model="updateParams.Name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="父级" :label-width="formLabelWidth" prop="parentId">
                <el-select style="width: 220px" v-model="updateParams.parentId" placeholder="请选择">
                    <el-option label="无父级" value="0"></el-option>
                    <%--          从数据库中查渠道种类          --%>
                    <el-option v-for="item in channelEntityList" :key="item.id" :label="item.Name"
                               :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="创建时间" :label-width="formLabelWidth">
                <el-date-picker readonly="true" v-model="updateParams.createTime" type="datetime"
                                placeholder="选择日期时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="备注" :label-width="formLabelWidth">
                <el-input style="width: 220px" v-model="updateParams.note" autocomplete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="updateDialog = false">取 消</el-button>
            <el-button type="primary" @click="updateChannel(updateParams)">确 定</el-button>
        </div>
    </el-dialog>
</div>

<script type="text/javascript">
    var channel = {
        data() {
            return {
                rules: { // 输入规则
                    Name: [
                        {
                            required: true,
                            message: '请输入渠道名称'
                        }
                    ],
                    parentId: [
                        {
                            required: true,
                            message: '请选择父级渠道'
                        }
                    ]
                },
                formLabelWidth: "120px", //对话框宽度
                addDialog: false,// 添加操作弹出的对话框
                updateDialog: false,// 添加操作弹出的对话框
                deleteConfirm: false, // 确认是否执行删除操作
                channelEntityList: [], //渠道种类列表
                allTypeList:[], //所有渠道的列表
                showParams: { // 查询要用到的参数
                    type: "showChannel",
                    typeId:"",
                    channelNumber:"",
                    nowPage: "1",//当前页
                    pageNum: "3",// 每页显示几条数据
                },
                findAllParams:{
                    type: "findAllChannelType",
                },
                addParams: {
                    type: "addChannel",// 请求类型
                    Name: "",  //渠道种类名称
                    parentId: '',  //父级id
                    note: "",// 备注
                    state: 1,// 状态
                    createTime: "" //创建时间
                },
                updateParams: {
                    type: "updateChannel",// 请求类型
                    id: "",// 类型id
                    Name: "",  //渠道种类名称
                    parentId: '',  //父级id
                    note: "",// 备注
                    state: 1,// 状态
                    createTime: "" //创建时间
                },
                deleteParams: {
                    type: "deleteChannel", //请求类型
                    id: ""
                },
                pageInfo: {// 分页信息
                    total: 0, // 总条数
                    pageSize: 3, // 每页显示几条数据
                    page: 1 // 当前页
                }
            }

        },
        methods: {
            sizeChange(value) {// 修改每页显示的数据量时触发
                // console.log(value);
                this.showParams.pageNum = value;
                this.queryAll(this.showParams);
            },
            currentChange(val) {// 当前页改变时触发
                // console.log(val);
                this.showParams.nowPage = val;
                this.queryAll(this.showParams);
            },
            findAllTypes(params){ // 查询所有数据（不分页的）
                var vm = this;
                axios({
                    method: "get",
                    url: "/channelType.do",
                    params: params
                }).then(function (response) {
                    // console.log(response.data);
                    var json = eval(response.data);
                    // 将serlvet中查询到的channelType数据赋值:channelTypeEntityList、pageInfo
                    vm.allTypeList = json;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            queryAll(params) { //查询所有的渠道种类
                var vm = this;
                axios({
                    method: "get",
                    url: "/channel.do",
                    params: params
                }).then(function (response) {
                    // console.log(response.data);
                    var json = eval(response.data);
                    // 将serlvet中查询到的channel数据赋值:channelEntityList、pageInfo
                    vm.channelEntityList = json.data;
                    vm.pageInfo = {
                        total: json.total, //总条数
                        pageSize: json.pageNum,// 每页显示几条数据
                        page: json.nowPage // 当前页
                    };
                }).catch(function (error) {
                    console.log(error);
                });
            },
            addChannel(params) { // 增加渠道种类
                var vm = this;
                console.log(params)
                axios({
                    method: "post",
                    url: "/channel.do",
                    params: params
                }).then(function (response) {
                    console.log(response.data);
                    var json = eval(response.data);
                    if (json != '添加成功') {
                        vm.$notify.error({
                            title: '提示',
                            message: json
                        });
                    } else {
                        // 关闭对话框
                        vm.addDialog = false;
                        vm.$notify({
                            title: '成功',
                            message: json,
                            type: 'success'
                        });
                        // 查询所有，刷新数据
                        vm.queryAll(vm.showParams);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            },
            initUpdate(index) { // 初始化修改(确定选中的是哪一条数据)
                var channel = this.channelEntityList[index];
                this.updateParams = {
                    type: "updateChannel",// 请求类型
                    id: channel.id, //类型的id
                    Name: channel.Name,  //渠道种类名称
                    parentId: channel.parentId,  //父级id
                    note: channel.note,// 备注
                    state: 1,// 状态
                    createTime: channel.createTime //创建时间
                };
                // 打开修改对话框
                this.updateDialog = true;
            },
            updateChannel(params) { //修改数据 提交数据到服务器
                var vm = this;
                axios({
                    method: "post",
                    url: "/channel.do",
                    params: params
                }).then(function (response) {
                    console.log(response.data);
                    var json = eval(response.data);
                    if (json != '修改成功') {
                        vm.$notify.error({
                            title: '提示',
                            message: json
                        });
                    } else {
                        // 关闭对话框
                        vm.updateDialog = false;
                        vm.$notify({
                            title: '成功',
                            message: json,
                            type: 'success'
                        });
                        // 查询所有，刷新数据
                        vm.queryAll(vm.showParams);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            },
            deleteChannel(index) { // 删除选中的一条数据
                var vm = this;
                var channel = this.channelEntityList[index];
                this.deleteParams.id = channel.id;
                axios({
                    method: "post",
                    url: "/channel.do",
                    params: vm.deleteParams
                }).then(function (response) {
                    console.log(response.data);
                    var json = eval(response.data);
                    if (json != '删除成功') {
                        vm.$notify.error({
                            title: '提示',
                            message: json
                        });
                    } else {
                        vm.$notify({
                            title: '成功',
                            message: json,
                            type: 'success'
                        });
                        // 查询所有，刷新数据
                        vm.queryAll(vm.showParams);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted: function () {
            // 查询渠道种类列表中的数据
            this.queryAll(this.showParams);
            this.findAllTypes(this.findAllParams);
        }
    };

    var vueChannel = Vue.extend(channel);
    new vueChannel().$mount("#channel");
</script>
</body>
</html>