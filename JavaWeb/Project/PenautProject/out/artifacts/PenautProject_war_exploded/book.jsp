<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/13
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta charset="utf-8">
    <title>权限管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <!-- Title and other stuffs -->
    <title>表格页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="">
    <!-- Stylesheets -->
    <link href="style/bootstrap.css" rel="stylesheet">
    <!-- Font awesome icon -->
    <link rel="stylesheet" href="style/font-awesome.css">
    <!-- jQuery UI -->
    <link rel="stylesheet" href="style/jquery-ui.css">
    <!-- Calendar -->
    <link rel="stylesheet" href="style/fullcalendar.css">
    <!-- prettyPhoto -->
    <link rel="stylesheet" href="style/prettyPhoto.css">
    <!-- Star rating -->
    <link rel="stylesheet" href="style/rateit.css">
    <!-- Date picker -->
    <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
    <!-- CLEditor -->
    <link rel="stylesheet" href="style/jquery.cleditor.css">

    <link rel="stylesheet" href="style/bootstrap-switch.css">
    <!-- Main stylesheet -->
    <link href="style/style.css" rel="stylesheet">
    <!-- Widgets stylesheet -->
    <link href="style/widgets.css" rel="stylesheet">


    <!-- HTML5 Support for IE -->
    <!--[if lt IE 9]>
    <script src="js/html5shim.js"></script>
    <![endif]-->

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon/favicon.png">

    <%--Vue--%>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!--element 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>


                        <div  id="bookTable">

                            <div >
                                <div class="row">
                                    <div class="col-xs-2 col-lg-offset-1">
                                        <input type="text" class="form-control" placeholder="书籍ID"  v-model="selectParams.bookId">
                                    </div>
                                    <div class="col-xs-2">
                                        <input type="text" class="form-control" placeholder="名称"  v-model="selectParams.bookName">
                                    </div>
                                    <div class="col-xs-2">
                                        <select class="form-control"  v-model="selectParams.firstTypeId" @change="theSecondType">
                                            <option value="">一级分类</option>
                                            <option v-for="fT in fTs" :value="fT.firstTypeId" >{{fT.firstTypeName}}</option>
                                        </select>
                                        <span>Selected: {{ selectParams.firstTypeId }}</span>

                                    </div>
                                    <div class="col-xs-2">
                                        <select class="form-control" v-model="selectParams.secondTypeId">
                                            <option value="">二级分类</option>
                                            <option v-for="sT in sTs" :value="sT.secondTypeId">{{sT.secondTypeName}}</option>
                                        </select>
                                        <span>Selected: {{ selectParams.secondTypeId }}</span>

                                    </div>
                                    <div class="col-xs-2" >
                                        <el-button type="primary" icon="el-icon-search" @click="bookShow(selectParams)" size="medium" round>搜索</el-button>
                                            <el-button type="info" @click="addDialog=true" size="small" >添加</el-button>
                                    </div>
                                </div>
                            </div>

                            <div >

                                <div >
                                    <el-table :data="tableData" height="500" border style="width: 100%">
                                        <el-table-column prop="bookId" label="书籍ID" width="180">
                                        </el-table-column>
                                        <el-table-column prop="bookName" label="书籍名称" width="180">
                                        </el-table-column>
                                        <el-table-column prop="authorName" label="作者" width="180" >
                                        </el-table-column>
                                        <el-table-column prop="firstTypeId" label="一级分类ID" width="180">
                                        </el-table-column>
                                        <el-table-column prop="firstTypeName" label="一级分类名称" width="180">
                                        </el-table-column>
                                        <el-table-column prop="secondTypeId" label="二级分类ID" width="180">
                                        </el-table-column>
                                        <el-table-column prop="secondTypeName" label="二级分类名称" width="180">
                                        </el-table-column>
                                        <el-table-column prop="isCompletion" label="更新状态" width="180">
                                            <template slot-scope="scope">{{scope.row.isCompletion==1?"连载":"完结"}}</template>
                                        </el-table-column>
                                        <el-table-column prop="update" label="操作" fixed="right" width="180">
                                            <template slot-scope="scope">
                                                <el-button @click="handleClick(scope.row)" size="small" type="info">修改</el-button>
                                                <el-button @click="remove(scope.row)" size="small" type="danger">删除</el-button>
                                            </template>
                                        </el-table-column>
                                    </el-table>
                                </div>

                                <el-pagination
                                        @prev-click="currentChange" @next-click="currentChange"
                                        @current-change="currentChange"
                                        @size-change="sizeChange"
                                        layout="total, sizes, prev, pager, next, jumper"
                                        :page-sizes="[3, 6, 10]"
                                        :total="pageInfo.total"
                                        :page-size="pageInfo.pageSize"
                                        :current-page="pageInfo.page">
                                </el-pagination>

                            </div>

                            <el-dialog  title="添加新书" :visible.sync="addDialog">
                                <el-form :model="abookInfo" :rules="rules" ref="addform" class="demo-ruleForm">
                                    <el-form-item label="书名" :label-width="formLabelWidth" prop="bookName">
                                        <el-input v-model="abookInfo.bookName" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="作者名" :label-width="formLabelWidth" prop="authorName">
                                        <el-input v-model="abookInfo.authorName" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="属性" :label-width="formLabelWidth" prop="attribution">
                                        <el-select v-model="abookInfo.attribution" >
                                            <el-option label="男频" value="1"></el-option>
                                            <el-option label="女频" value="2"></el-option>
                                            <el-option label="出版" value="3"></el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="一级分类" :label-width="formLabelWidth" prop="firstTypeId">
                                        <el-select  v-model="abookInfo.firstTypeId" @change="theSecondType_add">
                                            <el-option v-for="fT in fTs" :key="fT.index" :value="fT.firstTypeId" :label="fT.firstTypeName"></el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="二级分类" :label-width="formLabelWidth" prop="secondTypeId">
                                        <el-select v-model="abookInfo.secondTypeId" >
                                            <el-option v-for="sT in sTs" :key="sT.index" :value="sT.secondTypeId" :label="sT.secondTypeName"></el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="描述" :label-width="formLabelWidth" prop="description">
                                        <el-input type="textarea" :rows="2" placeholder="请输入书籍描述" v-model="abookInfo.description"></el-input>
                                    </el-form-item>
                                    <el-form-item label="状态" :label-width="formLabelWidth" prop="isCompletion">
                                        <el-select v-model="abookInfo.isCompletion" >
                                            <el-option label="连载" value="1"></el-option>
                                            <el-option label="完结" value="0"></el-option>
                                        </el-select>
                                    </el-form-item>
                                </el-form>
                                <div slot="footer" class="dialog-footer">
                                    <el-button type="primary" @click="submitForm('addform')">确 定</el-button>
                                    <el-button @click="addDialog = false">取 消</el-button>
                                    <el-button @click="resetForm('addform')">重置</el-button>
                                </div>
                            </el-dialog>

                            <el-dialog  title="修改图书信息" :visible.sync="updateDialog">
                                <el-form :model="bookInfo" :rules="rules" ref="updataform" class="demo-ruleForm">
                                    <el-form-item label="书名" :label-width="formLabelWidth" prop="bookName">
                                        <el-input v-model="bookInfo.bookName" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="作者名" :label-width="formLabelWidth" prop="authorName">
                                        <el-input v-model="bookInfo.authorName" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="一级分类" :label-width="formLabelWidth" prop="firstTypeId">
                                        <el-select  v-model="bookInfo.firstTypeId" @change="theSecondType_up">
                                            <el-option v-for="fT in fTs" :key="fT.index" :value="fT.firstTypeId" :label="fT.firstTypeName"></el-option>
                                        </el-select>
                                    </el-form-item>
                                    <el-form-item label="二级分类" :label-width="formLabelWidth" prop="secondTypeId">
                                        <el-select v-model="bookInfo.secondTypeId" >
                                            <el-option v-for="sT in sTs" :key="sT.index" :value="sT.secondTypeId" :label="sT.secondTypeName"></el-option>
                                        </el-select>
                                        <span>Selected: {{ bookInfo.secondTypeId }}</span>
                                    </el-form-item>
                                    <el-form-item label="描述" :label-width="formLabelWidth" prop="description">
                                        <el-input type="textarea" :rows="2" placeholder="请输入书籍描述" v-model="bookInfo.description"></el-input>
                                    </el-form-item>
                                    <el-form-item label="状态" :label-width="formLabelWidth" prop="isCompletion">
                                        <el-select v-model="bookInfo.isCompletion" >
                                            <el-option label="连载" value="1"></el-option>
                                            <el-option label="完结" value="0"></el-option>
                                        </el-select>
                                    </el-form-item>
                                </el-form>
                                <div slot="footer" class="dialog-footer">
                                    <el-button type="primary" @click="submitForm('updataform')">确 定</el-button>
                                    <el-button @click="updateDialog = false">取 消</el-button>
                                    <el-button @click="resetForm('updataform')">重置</el-button>
                                </div>
                            </el-dialog>

                        </div>


</body>
<!-- JS -->
<script src="js/jquery.js"></script> <!-- jQuery -->
<script src="js/bootstrap.js"></script> <!-- Bootstrap -->
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->
<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
<script src="js/jquery.rateit.min.js"></script> <!-- RateIt - Star rating -->
<script src="js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->
<!-- jQuery Flot -->
<script src="js/excanvas.min.js"></script>
<script src="js/jquery.flot.js"></script>
<script src="js/jquery.flot.resize.js"></script>
<script src="js/jquery.flot.pie.js"></script>
<script src="js/jquery.flot.stack.js"></script>

<!-- jQuery Notification - Noty -->
<script src="js/jquery.noty.js"></script> <!-- jQuery Notify -->
<script src="js/themes/default.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/bottom.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/topRight.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/top.js"></script> <!-- jQuery Notify -->
<!-- jQuery Notification ends -->

<script src="js/sparklines.js"></script> <!-- Sparklines -->
<script src="js/jquery.cleditor.min.js"></script> <!-- CLEditor -->
<script src="js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->
<%--<script src="js/jquery.uniform.min.js"></script> <!-- jQuery Uniform -->--%>
<script src="js/bootstrap-switch.min.js"></script> <!-- Bootstrap Toggle -->
<script src="js/filter.js"></script> <!-- Filter for support page -->
<script src="js/custom.js"></script> <!-- Custom codes -->
<script src="js/charts.js"></script> <!-- Charts & Graphs -->

<script src="https://unpkg.com/axios/dist/axios.min.js"></script><!-- axios -->

<script type="text/javascript">
    var vm = new Vue({
        el: "#bookTable",
        data(){
            return {
                tableData: [],
                fTs: [],
                sTs:[],
                selectParams: {
                    type:"findBookByPage",
                    firstTypeId: "",
                    secondTypeId: "",
                    bookId:null,
                    bookName:"",
                    nowPage:1,
                    pageNum:6
                },
                pageInfo: {// 分页信息
                    total: 0, //总条数
                    pageSize: 3,// 每页显示几条数据
                    page: 1 // 当前页
                },
                addDialog: false,
                updateDialog:false,
                abookInfo: {// 新增图书时，需要提交到服务器的数据
                    type: "addBook",// servlet中调用方法
                    bid:"",
                    bookId:"",
                    bookName: "",
                    authorName: "",
                    attribution: "",
                    firstTypeId: "",
                    secondTypeId:"",
                    description: "",
                    coverUrl: "",
                    isCompletion: "",
                    state: "",
                    lastupChapter: "",
                    wordCount: ""
                },
                bookInfo: {// 添加图书时，需要提交到服务器的数据
                    type: "updateBook",// servlet中调用方法
                    bid:"",
                    bookId:"",
                    bookName: "",
                    authorName: "",
                    attribution: "",
                    firstTypeId: "",
                    secondTypeId:"",
                    description: "",
                    coverUrl: "",
                    isCompletion: "",
                    state: "",
                    lastupChapter: "",
                    wordCount: ""
                },
                formLabelWidth: '120px',
                rules: {
                    bookName: [
                        { required: true, message: '请输入小说名称', trigger: 'blur' },
                        { min: 2,  message: '长度在最少 2 个字符', trigger: 'blur' }
                    ],
                    authorName: [
                        { required: true, message: '请输入作者名称', trigger: 'blur' },
                        { min: 2,  message: '长度在最少 2 个字符', trigger: 'blur' }
                    ],
                    attribution: [
                        {  required: true, message: '请选择属性', trigger: 'change' }
                    ],
                    firstTypeId: [
                        { required: true, message: '请选择一级分类', trigger: 'change' }
                    ],
                    secondTypeId: [
                        {  required: true, message: '请选择二级分类', trigger: 'change' }
                    ],
                    description: [
                        { required: true, message: '描述不能为空', trigger: 'blur' }
                    ],
                    isCompletion: [
                        { required: true, message: '请选择连载状态', trigger: 'change' }
                    ]
                }


            }
        },

        mounted: function(){
            this.theFirstType();
            this.bookShow(this.selectParams);
        },
        methods: {
            sizeChange(value) {// 修改每页显示的数据量时触发
                // console.log(value);
                this.selectParams.pageNum = value;
                this.bookShow(this.selectParams);
            },
            currentChange(val) {// 当前页改变时触发
                // console.log(val);
                this.selectParams.nowPage = val;
                this.bookShow(this.selectParams);
            },
            theFirstType(){
                axios.get("/bookServlet.do", {
                    params: {
                        type:"showFirstType"
                    }
                })
                    .then(function (response) {
                        // response.data.forEach(function (value, index) {
                        //     vm.fTs.push({ "firstTypeId": value.firstTypeId,"firstTypeName": value.firstTypeName});
                        //     // console.log(value);
                        // })
                        console.log(response.data);
                        vm.fTs=response.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            theSecondType(){
                axios.get("/bookServlet.do", {
                    params: {
                        type:"findSecondTypeByFirstTypeId",
                        firstTypeId:this.selectParams.firstTypeId
                    }
                })
                    .then(function (response) {

                        vm.sTs=response.data;
                        vm.selectParams.secondTypeId="";
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            theSecondType_up0(){
                axios.get("/bookServlet.do", {
                    params: {
                        type:"findSecondTypeByFirstTypeId",
                        firstTypeId:this.bookInfo.firstTypeId
                    }
                })
                    .then(function (response) {

                        vm.sTs=response.data;
                        // vm.bookInfo.secondTypeId="";
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            theSecondType_up(){
                axios.get("/bookServlet.do", {
                    params: {
                        type:"findSecondTypeByFirstTypeId",
                        firstTypeId:this.bookInfo.firstTypeId
                    }
                })
                    .then(function (response) {

                        vm.sTs=response.data;
                        vm.bookInfo.secondTypeId="";
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            theSecondType_add(){
                axios.get("/bookServlet.do", {
                    params: {
                        type:"findSecondTypeByFirstTypeId",
                        firstTypeId:this.abookInfo.firstTypeId
                    }
                })
                    .then(function (response) {

                        vm.sTs=response.data;
                        vm.abookInfo.secondTypeId="";
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            bookShow(params){
                axios.get("/bookServlet.do", {
                    params:params
                })
                    .then(function (response) {
                        console.log(response.data);
                        vm.tableData=response.data.data;
                        vm.pageInfo = {
                            total: response.data.total, //总条数
                            pageSize: response.data.pageNum,// 每页显示几条数据
                            page: response.data.nowPage // 当前页
                        };
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            addBook() {
                console.log(vm.abookInfo);
                // 将数据提交到服务器
                axios({
                    method: "post",
                    url: "/bookServlet.do",
                    params:vm.abookInfo
                }).then(function (response) {
                    // var json = eval(response.data);
                    console.log(response.data);
                    if (response.data=="添加成功") {
                        vm.addDialog = false;// 关闭模态框
                        // 查询游戏列表
                        vm.bookShow(vm.selectParams);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid)=>{
                    if (valid) {
                        // alert('submit!');
                        if(formName=='addform'){
                            this.addBook();
                        }
                        if (formName=='updataform'){
                            this.updataBook();
                        }

                    }else{
                        console.log('error submit!!');
                return false;
            }
            });
            },
            resetForm(formName){
                this.$refs[formName].resetFields();
                this.$refs[formName].resetFields();
            },
            handleClick(row) {
                console.log(row);

                this.bookInfo.type= "updateBook";
                this.bookInfo.bid= row.bid;
                this.bookInfo.bookId= row.bookId;
                this.bookInfo.bookName= row.bookName;
                this.bookInfo.authorName= row.authorName;
                this.bookInfo.attribution= row.attribution;
                this.bookInfo.firstTypeId= row.firstTypeId;
                this.bookInfo.secondTypeId= row.secondTypeId;
                this.bookInfo.description= row.description;
                this.bookInfo.coverUrl= row.coverUrl;
                this.bookInfo.isCompletion= row.isCompletion;
                this.bookInfo.state= row.state;
                this.bookInfo.lastupChapter= row.lastupChapter;
                this.bookInfo.wordCount= row.wordCount;
                this.theSecondType_up0();
                this.updateDialog = true;// 显示模态框

            },
            updataBook(){
                axios({
                    method: "post",
                    url: "/bookServlet.do",
                    params:vm.bookInfo
                }).then(function (response) {
                    // var json = eval(response.data);
                    console.log(response.data);
                    if (response.data=="修改成功") {
                        vm.updateDialog = false;// 关闭模态框
                        // 查询图书列表
                        vm.bookShow(vm.selectParams);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            },
            remove(row){
                axios({
                    method: "post",
                    url: "/bookServlet.do",
                    params:{type: "removeBook",
                    bid:row.bid}
                }).then(function (response) {
                    if (response.data=="删除成功") {
                        alert("删除成功");
                        // 查询游戏列表
                        vm.bookShow(vm.selectParams);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },

    });

    // $(function () {
    // $.get("/bookServlet.do","type=showFirstType",function (data) {
    //     data.forEach(function (value, index) {
    //         // var $option =$("<option value="+value.firstTypeId+">"+value.firstTypeName+"</option>");
    //         // $("#firstTypeId").append($option)
    //         vm.fTs.push({ "firstTypeId": value.firstTypeId,"firstTypeName": value.firstTypeName})
    //     })
    // },"json");

    // $("#firstTypeId").change(function () {
    //     $("#secondTypeId").children("option:not(:first)").remove();
    //     var $firstTypeId = $(this).val();
    //     if ($firstTypeId!=""){
    //         $.get("/bookServlet.do","type=findSecondTypeByFirstTypeId&firstTypeId="+$firstTypeId,function (data) {
    //             data.forEach(function (value, index) {
    //                 var $option =$("<option value="+value.secondTypeId+">"+value.secondTypeName+"</option>");
    //                 $("#secondTypeId").append($option)
    //             })
    //         },"json")
    //     }
    // })
    // });
</script>
</html>
