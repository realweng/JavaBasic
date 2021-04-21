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
    <%--  条件查询的表单  --%>
    <el-form :inline="true" :model="showParams" class="demo-form-inline">
        <el-form-item label="渠道种类">
            <el-cascader
                v-model="selectedTypeId"
                :options="allTypeList"
                expand-trigger="hover"
                :props="cascaderProps"
                clearable
                change-on-select
                @change="parentTypeChange"
            ></el-cascader>
        </el-form-item>
        <el-form-item label="渠道号">
            <el-input v-model="showParams.channelNumber" placeholder="渠道号"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="queryAll(showParams)">查询</el-button>
            <el-button @click="addDialog = true" type="success" plain>添加渠道</el-button>
        </el-form-item>
    </el-form>
    <!-- 表格数据 -->
    <el-table :data="channelEntityList" style="width: 1290px" height="300px" stripe border>
        <el-table-column prop="parentName" label="一级分类" width="120px">
        </el-table-column>
        <el-table-column prop="typeName" label="二级分类" width="120px">
        </el-table-column>
        <el-table-column prop="channelNumber" label="渠道号">
        </el-table-column>
        <el-table-column prop="channelPath" label="渠道下载地址">
        </el-table-column>
        <el-table-column prop="productName" label="产品名称">
        </el-table-column>
        <el-table-column prop="showName" label="显示名称">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间">
        </el-table-column>
        <el-table-column label="操作" width="140px">
            <template slot-scope="scope">
                <el-button @click="initUpdate(scope.$index)" type="text" size="small">添加下载地址</el-button>
                <el-button type="text" size="small" @click="deleteConfirm = true">删除</el-button>
                <el-dialog title="提示" :visible.sync="deleteConfirm" width="30%" center>
                    <span>你确定删除该条数据吗？</span>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="deleteConfirm = false">取 消</el-button>
                        <el-button type="primary"
                                   @click="deleteConfirm = false;initDelete(scope.$index)">确 定</el-button>
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
            <el-form-item label="渠道号" :label-width="formLabelWidth" prop="channelNumber">
                <el-input style="width: 220px" v-model="addParams.channelNumber" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="产品名称" :label-width="formLabelWidth" prop="productName">
                <el-input style="width: 220px" v-model="addParams.productName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="显示名称" :label-width="formLabelWidth" prop="showName">
                    <el-input style="width: 220px" v-model="addParams.showName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="地区" :label-width="formLabelWidth" prop="area">
                <el-input style="width: 220px" v-model="addParams.area" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="发布时间" :label-width="formLabelWidth">
                <el-date-picker v-model="addParams.createTime" type="datetime" placeholder="选择日期时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="平台" :label-width="formLabelWidth" prop="platform">
                <el-select style="width: 220px" v-model="addParams.platform" placeholder="请选择">
                    <el-option label="全部" value="0"></el-option>
                    <el-option label="iOS" value="1"></el-option>
                    <el-option label="安卓" value="2"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="渠道种类" :label-width="formLabelWidth">
                <el-cascader style="width: 220px"
                        v-model="addSelectedTypeId"
                        :options="allTypeList"
                        expand-trigger="hover"
                        :props="cascaderProps"
                        clearable
                        change-on-select
                        @change="addParentTypeChange"
                ></el-cascader>
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

    <%-- 修改渠道下载地址的对话框 --%>
    <el-dialog width="500px" title="添加下载地址" :visible.sync="updateDialog">
        <el-form :model="updateParams" :rules="rules" ref="updateParams">
            <el-form-item label="地址" :label-width="formLabelWidth" prop="channelPath">
                <el-input style="width: 220px" v-model="updateParams.channelPath" autocomplete="off"></el-input>
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
                    channelNumber:[
                        {
                            required: true,
                            message: '请输入渠道号'
                        }
                    ],//渠道号
                    productName: [
                        {
                            required: true,
                            message: '请输入产品名称'
                        }
                    ],  //产品名称
                    showName:[
                        {
                            required: true,
                            message: '请输入显示名称'
                        }
                    ], //显示名称
                    platform:[
                        {
                            required: true,
                            message: '请选择平台'
                        }
                    ], //平台
                    channelPath:[
                        {
                            required: true,
                            message: '请输入下载地址'
                        }
                    ]
                },
                cascaderProps:{// 级联选择器的参数
                    value:'id',
                    label:'typeName',
                    children:'sonList'
                },
                formLabelWidth: "120px", //对话框宽度
                selectedTypeId:[], // 查询级联选择的值
                addSelectedTypeId:[], // 新增级联选择的值
                addDialog: false,// 添加操作弹出的对话框
                updateDialog: false,// 添加操作弹出的对话框
                deleteConfirm: false, // 确认是否执行删除操作
                channelEntityList: [], //渠道种类列表
                allTypeList: [], //所有渠道类型的列表
                showParams: { // 查询要用到的参数
                    type: "findAllChannelByPage", // 操作类型
                    typeId: "", // 选中的种类类型
                    channelNumber: "", // form表单中填写的渠道号（模糊查询）
                    nowPage: "1",//当前页
                    pageNum: "3",// 每页显示几条数据
                },
                findAllParams: {
                    type: "findAllChannelType",
                },
                addParams: {
                    type: "addChannel",// 请求类型
                    typeId :"",
                    channelNumber:"",//渠道号
                    productName: "",  //产品名称
                    showName:"", //显示名称
                    platform:"", //平台
                    area: '',  //地区
                    note: "",// 备注
                    state: 1,// 状态
                    createTime: "" //创建时间
                },
                updateParams: {
                    type: "updateChannel",// 请求类型
                    id:"",//更改数据对应的
                    channelPath:"", //下载地址
                    typeId :"",
                    channelNumber:"",//渠道号
                    productName: "",  //产品名称
                    showName:"", //显示名称
                    platform:"", //平台
                    area: '',  //地区
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
            parentTypeChange(){// 级联选择器选中的值
                if(this.selectedTypeId.length>1){
                    this.selectedTypeId = this.selectedTypeId[this.selectedTypeId.length-1];
                }
                var str = JSON.stringify(this.selectedTypeId);
                if(str.length>1){
                    str = str.slice(1,2);
                }
                this.showParams.typeId = str;
                // console.log(str)
            },
            addParentTypeChange(){// 级联选择器选中的值
                if(this.addSelectedTypeId.length>1){
                    this.addSelectedTypeId = this.addSelectedTypeId[this.addSelectedTypeId.length-1];
                }
                var str = JSON.stringify(this.addSelectedTypeId);
                if(str.length>1){
                    str = str.slice(1,2);
                }
                this.addParams.typeId = str;
                // console.log(str)
            },
            findAllTypes(params) { // 查询所有数据（不分页的）
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
                console.log(params);
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
                    id : channel.id,
                    channelPath : channel.channelPath,
                    typeId :channel.typeId,
                    channelNumber:channel.channelNumber,//渠道号
                    productName: channel.productName,  //产品名称
                    showName:channel.showName, //显示名称
                    platform:channel.platform, //平台
                    area: channel.area,  //地区
                    note: channel.note,// 备注
                    state: 1,// 状态
                    createTime: channel.createTime //创建时间
                };
                // 打开修改对话框
                this.updateDialog = true;
            },
            initDelete(index){
                var channel = this.channelEntityList[index];
                this.deleteParams = {
                    type:"deleteChannel",
                    id:channel.id
                };
                console.log(this.deleteParams.id)
                this.deleteChannel(this.deleteParams);
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
                    if (json != '地址添加成功') {
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
            deleteChannel(params) { // 删除选中的一条数据
                var vm = this;
                axios({
                    method: "post",
                    url: "/channel.do",
                    params: params
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