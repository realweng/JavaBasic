<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/17
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
        <link rel="stylesheet" type="text/css" href="css/main2.css" />
        <script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="https://cdn.bootcdn.net/ajax/libs/element-ui/2.15.1/index.min.js"></script>
        <style>
            .el-dropdown-link {
                cursor: pointer;
                color: #409EFF;
            }
            .el-icon-arrow-down {
                font-size: 12px;
            }
        </style>
    </head>
</head>
<body>
<div id="main" style="margin: 0px auto;">
    <el-container>
        <!-- 导航头部 -->
        <el-header style="height: 50px;background-color:#0074D9;">
            <a href="main.jsp">
                <img align="left" src="./img/logo_c.png"/>
            </a>
            <!-- 导航条右侧显示用户信息 修改密码 退出登录-->
            <div align="right" id="userControl">
                <el-dropdown :hide-on-click="false">
						  <span style="color: white; width: 100px; font-size: medium;" class="el-dropdown-link">
						    个人中心<i class="el-icon-arrow-down el-icon--right"></i>
						  </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item @click.native="updatePwdDialog = true">修改密码</el-dropdown-item>
<%--                        <el-dropdown-item @click.native="visible = true">退出登录</el-dropdown-item>--%>
                        <%--  是否退出登录判断  --%>
                        <el-popover placement="top" width="160" v-model="visible">
                            <p>你确定退出登录吗？</p>
                            <div style="text-align: right; margin: 0">
                                <el-button size="mini" type="text" @click="visible = false">取消</el-button>
                                <el-button type="primary" size="mini" @click="visible = false;logOut()">确定</el-button>
                            </div>
                            <el-dropdown-item slot="reference">退出登录</el-dropdown-item>
                        </el-popover>

                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </el-header>
        <!-- 页面主体 -->
        <el-container>
            <el-aside width="200px">
                <!-- 菜单列表 -->
                <el-menu default-active="1" class="el-menu-vertical-demo" background-color="whitesmoke"
                         text-color="#0074D9" active-text-color="#0034aa" >
                    <template v-for="menu in menuList">
                        <el-submenu :index="menu.mid" v-if="menu.sonList!=null">
                            <template slot="title">
                                <i style="color: #0074D9;" :class="menu.menuIcon"></i>
                                <span>{{menu.menuName}}</span>
                            </template>
                            <!-- <template slot="title">{{childrenMenu.menuName}}</template> -->
                            <el-menu-item v-for="childrenMenu in menu.sonList" @click="addTab(childrenMenu)" :index="childrenMenu.mid">
                                <div align="right">
                                    <i style="color: #0074D9;" :class="childrenMenu.menuIcon"></i>
                                    <span>{{childrenMenu.menuName}}</span>
                                </div>
                            </el-menu-item>
                        </el-submenu>
                        <el-menu-item v-if="menu.sonList==null" @click="addTab(menu)" :index="menu.mid">
                            <i style="color: #0074D9;" :class="menu.menuIcon"></i>
                            <span slot="title">{{menu.menuName}}</span>
                        </el-menu-item>
                    </template>
                </el-menu>
            </el-aside>

            <el-main>
                <el-tabs v-model="activeTab" @tab-remove="removeTab">
                    <el-tab-pane v-for="tab in tabArray" :closable="tab.closable" :label="tab.tabName"
                                 :name="tab.tabName">
                        <span slot="label"><i :class="tab.icon"> {{tab.tabName}}</i></span>
                        <iframe name="child" id="child" :src="tab.path" width="1420" height="860"
                                frameborder="0" scrolling="no"
                                style="position:relative; top: 2.8px;left: 0px;"></iframe>
                        <!-- <div v-html="showHtml"></div> -->
                    </el-tab-pane>
                </el-tabs>

            </el-main>
        </el-container>
    </el-container>

    <%-- 更改密码的对话框 --%>
    <el-dialog title="更改密码" :visible.sync="updatePwdDialog">
        <el-form :model="form">
            <el-form-item label="用户名" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off" :readonly="true"></el-input>
            </el-form-item>
            <el-form-item label="密码" :label-width="formLabelWidth">
                <el-input type="password" v-model="form.pwd" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="新密码" :label-width="formLabelWidth">
                <el-input type="password" v-model="form.newPwd" autocomplete="off"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="updatePwdDialog = false">取 消</el-button>
            <el-button type="primary" @click="updatePwdDialog = false;updatePwd()">确 定</el-button>
        </div>
    </el-dialog>

</div>

<script type="text/javascript">
    var mainData = {
        data() {
            return {
                menuList: '',
                tabArray: [{
                    tabName: "主页",
                    path: "hello.html",
                    icon: "el-icon-house",
                    closable: false
                }],
                activeTab: "主页",
                showHtml: "",
                visible: false,
                updatePwdDialog: false,
                form: {
                    type: 'updatePassword',
                    name: '${sessionScope.user.userName}',
                    pwd: '',
                    newPwd: ''
                },
                formLabelWidth: '80px'
            }
        },
        methods: {
            // 点击菜单，添加选项卡
            addTab: function(menu) {
                // 菜单名称
                let menuName = menu.menuName;
                // 菜单url
                let url = menu.menuUrl;
                // 图标
                let menuIcon = menu.menuIcon;

                // 是否需要新建tab
                let flag = false;
                this.tabArray.forEach((tab, index) => {
                    if (tab.tabName == menuName) {
                        flag = true;
                    }
                })

                if (!flag) {
                    // 修改tabArray数组，添加选项卡元素
                    this.tabArray.push({
                        tabName: menuName,
                        path: url,
                        icon: menuIcon,
                        closable: true // 是否可以关闭
                    });
                    // console.log(this.tabArray);
                    // 设置tab选中的选项卡
                    this.activeTab = menuName;
                } else {
                    // 设置tab选中的选项卡
                    this.activeTab = menuName;
                }
            },
            // 删除选中的选项卡
            removeTab: function(targetName) {
                var tabsArray = this.tabArray;
                let activeName = this.activeTab;
                if (activeName === targetName) {
                    tabsArray.forEach((tab, index) => {
                        if (tab.tabName === targetName) {
                            var nextTab = tabsArray[index + 1] || tabsArray[index - 1];
                            if (nextTab) {
                                activeName = nextTab.tabName;
                            }
                        }
                    });
                }
                this.activeTab = activeName;
                this.tabArray = tabsArray.filter(tab => tab.tabName !== targetName);
            },
            // 退出登录
            logOut:function (){
                location.href = '/adminUser.do?type=adminUserLogout';
            },
            // 修改用户密码
            updatePwd:function (){
                var vm = this;
                if(this.form.pwd != null && this.form.newPwd != null){
                    axios({
                        method: "post",
                        url: "/adminUser.do",
                        params: this.form
                    }).then(function (response) {
                        var json = eval(response.data);
                        // console.log(json);
                        if(json!='修改成功'){
                            vm.$notify({
                                title: '提示',
                                message: json
                            });
                        }else{
                            location.href = '/adminUser.do?type=adminUserLogout';
                        }
                    }).catch(function (error) {
                        console.log(error);
                    });
                }
            }
        },
        mounted(){
            this.$message({
                showClose: true,
                message: '欢迎${sessionScope.user.userName}'+'，登录成功！',
                type: 'success'
            });
            // 查询用户登录的菜单,从session中取菜单信息
            var menuList = '${sessionScope.menuList}';
            var menuListJson = eval(menuList);
            // console.log(menuListJson);
            this.menuList = menuListJson;
            // console.log(this.updatePwdDialog);
        }
    }

    var mainObject = Vue.extend(mainData);
    new mainObject().$mount("#main");
</script>
</body>
</html>

