<%--
  Created by IntelliJ IDEA.
  Menu: Administrator
  Date: 2021/4/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOC html>
<html>
<head>
  <meta charset="utf-8">
  <title>角色管理</title>
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
<div id="Menu" style="width: 1300px;">
  <el-button @click="addDialog = true" type="success" plain>添加菜单</el-button>
  <div><br/></div>
  <!-- 表格数据 -->
  <el-table :data="menuEntityList" style="width: 1290px" height="300px" stripe border>
    <el-table-column prop="mid" label="序号" width="120px">
    </el-table-column>
    <el-table-column prop="menuName" label="菜单名" width="120px">
    </el-table-column>
    <el-table-column prop="parentName" label="父级">
    </el-table-column>
    <el-table-column prop="state" label="状态">
      <template scope="scope">
        <div v-if="scope.row.state == 1" style="color: green;text-align: center">有效</div>
        <div v-else style="color: red;text-align: center">无效</div>
      </template>
    </el-table-column>
    <el-table-column prop="menuIcon" label="图标">
    </el-table-column>

    <el-table-column label="操作" width="140px">
      <template slot-scope="scope">
        <%--    v-if="menuEntityList[scope.$index].state==1"    --%>
        <el-button  @click="initUpdate(scope.$index)" type="text"
                   size="small">修改
        </el-button>
        <el-button v-if="menuEntityList[scope.$index].state==1"
                   type="text" size="small" @click="deleteConfirm=true;deleteIndex=scope.$index">删除
        </el-button>
        <el-dialog title="提示" :visible.sync="deleteConfirm" width="30%" center>
          <span>你确定删除该菜单吗？</span>
          <span slot="footer" class="dialog-footer">
                        <el-button @click="deleteConfirm = false">取 消</el-button>
                        <el-button type="primary"
                                   @click="deleteConfirm = false;initDelete()">确 定</el-button>
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

  <%-- 添加菜单的对话框 --%>
  <el-dialog width="600px" title="添加菜单" :visible.sync="addDialog">
    <%--powerAdmin: {},// 需要授权的用户对象
            pageMenuList: [],// 需要授权用户的所有权限（哪些tree节点需要默认选中）
            menuList: [],// 所有的权限信息--%>
    <el-form :model="addParams" :rules="rules" ref="addParams">
      <el-form-item label="菜单名称" :label-width="formLabelWidth" prop="menuName">
        <el-input style="width: 300px" v-model="addParams.menuName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="菜单地址" :label-width="formLabelWidth" prop="menuUrl">
        <el-input style="width: 300px" v-model="addParams.menuUrl" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="父级" :label-width="formLabelWidth" prop="parentId">
        <el-select style="width: 300px" v-model="addParams.parentId" placeholder="请选择">
          <el-option label="无父级" value="0"></el-option>
          <%--          从数据库中查父级菜单          --%>
          <el-option v-for="item in allParentList" :key="item.mid" :label="item.menuName"
                     :value="item.mid">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="菜单状态" :label-width="formLabelWidth" prop="state">
        <el-select style="width: 300px" v-model="addParams.state" placeholder="请选择">
          <el-option label="有效" value="1"></el-option>
          <el-option label="无效" value="0"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="菜单图标" :label-width="formLabelWidth" prop="menuIcon">
        <el-select style="width: 300px" v-model="addParams.menuIcon" placeholder="请选择">
          <el-option label="el-icon-s-shop" value="el-icon-s-shop"></el-option>
          <el-option label="el-icon-s-home" value="el-icon-s-home"></el-option>
          <el-option label="el-icon-s-marketing" value="el-icon-s-marketing"></el-option>
          <el-option label="el-icon-odometer" value="el-icon-user-solid"></el-option>
          <el-option label="el-icon-s-fold" value="el-icon-s-fold"></el-option>
          <el-option label="el-icon-s-custom" value="el-icon-s-custom"></el-option>
          <el-option label="el-icon-user" value="el-icon-user"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="addDialog = false">取 消</el-button>
      <el-button type="primary" @click="addMenu(addParams)">确 定</el-button>
    </div>
  </el-dialog>

  <%-- 修改菜单的对话框 --%>
  <el-dialog width="600px" title="修改菜单" :visible.sync="updateDialog">
    <el-form :model="updateParams" :rules="rules" ref="updateParams">
      <el-form-item label="菜单名称" :label-width="formLabelWidth" prop="menuName">
        <el-input style="width: 300px" v-model="updateParams.menuName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="菜单地址" :label-width="formLabelWidth" prop="menuUrl">
        <el-input style="width: 300px" v-model="updateParams.menuUrl" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="父级" :label-width="formLabelWidth" prop="parentId">
        <el-select style="width: 300px" v-model="updateParams.parentId" placeholder="请选择">
          <el-option label="无父级" value="0"></el-option>
          <%--          从数据库中查父级菜单          --%>
          <el-option v-for="item in allParentList" :key="item.mid" :label="item.menuName"
                     :value="item.mid">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="菜单状态" :label-width="formLabelWidth" prop="state">
        <el-select disabled style="width: 300px" v-model="updateParams.state" placeholder="请选择">
          <el-option label="有效" value="1"></el-option>
          <el-option label="无效" value="0"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="菜单图标" :label-width="formLabelWidth" prop="menuIcon">
        <el-select style="width: 300px" v-model="updateParams.menuIcon" placeholder="请选择">
          <el-option label="el-icon-s-shop" value="el-icon-s-shop"></el-option>
          <el-option label="el-icon-s-home" value="el-icon-s-home"></el-option>
          <el-option label="el-icon-s-marketing" value="el-icon-s-marketing"></el-option>
          <el-option label="el-icon-odometer" value="el-icon-user-solid"></el-option>
          <el-option label="el-icon-s-fold" value="el-icon-s-fold"></el-option>
          <el-option label="el-icon-s-custom" value="el-icon-s-custom"></el-option>
          <el-option label="el-icon-user" value="el-icon-user"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="updateDialog = false">取 消</el-button>
      <el-button type="primary" @click="updateMenu(updateParams)">确 定</el-button>
    </div>
  </el-dialog>
</div>

<script type="text/javascript">
  var Menu = {
    data() {
      return {
        rules: { // 输入规则
          MenuNumber: [
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
          showName: [
            {
              required: true,
              message: '请输入显示名称'
            }
          ], //显示名称
          platform: [
            {
              required: true,
              message: '请选择平台'
            }
          ], //平台
          MenuPath: [
            {
              required: true,
              message: '请输入下载地址'
            }
          ]
        },
        cascaderProps: {// 级联选择器的参数
          value: 'id',
          label: 'typeName',
          children: 'sonList'
        },

        formLabelWidth: "120px", //对话框宽度
        addDialog: false,// 添加操作弹出的对话框
        updateDialog: false,// 添加操作弹出的对话框
        deleteConfirm: false, // 确认是否执行删除操作
        menuEntityList: [], //渠道种类列表
        allParentList: [], //所有渠道类型的列表
        showParams: { // 查询要用到的参数
          type: "showAllMenu", // 操作类型
          nowPage: "1",//当前页
          pageNum: "3",// 每页显示几条数据
        },
        findAllParams: {
          type: "findAllParent",
        },
        addParams: {
          type: "addMenu",// 请求类型
          menuIcon:'',
          menuName:'',
          menuUrl:'',
          parentId:0,
          state:1
        },
        updateParams: {
          type: "updateMenu",// 请求类型
          id:0,
          menuIcon:'',
          menuName:'',
          menuUrl:'',
          parentId:0,
          state:1
        },
        deleteParams: {
          type: "deleteAdminMenu", //请求类型
          id: ""
        },
        pageInfo: {// 分页信息
          total: 0, // 总条数
          pageSize: 3, // 每页显示几条数据
          page: 1 // 当前页
        },
        deleteIndex: 0
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
      findAllParent(params) { // 查询所有父级菜单
        var vm = this;
        axios({
          method: "get",
          url: "/menu.do",
          params: params
        }).then(function (response) {
          // console.log(response.data);
          var json = eval(response.data);
          // 将serlvet中查询到的MenuType数据赋值:MenuTypeEntityList、pageInfo
          vm.allParentList = json;
        }).catch(function (error) {
          console.log(error);
        });
      },
      queryAll(params) { //查询所有
        // console.log(params);
        var vm = this;
        axios({
          method: "get",
          url: "/menu.do",
          params: params
        }).then(function (response) {
          console.log("----数据---"+response.data);
          var json = eval(response.data);
          // 将serlvet中查询到的Menu数据赋值:menuEntityList、pageInfo
          vm.menuEntityList = json.data;
          vm.pageInfo = {
            total: json.total, //总条数
            pageSize: json.pageNum,// 每页显示几条数据
            page: json.nowPage // 当前页
          };
        }).catch(function (error) {
          console.log(error);
        });
      },
      addMenu(params) { // 增加渠道种类
        var vm = this;
        console.log(params)
        axios({
          method: "post",
          url: "/menu.do",
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
        var Menu = this.menuEntityList[index];
        this.updateParams = {
          type: "updateMenu",// 请求类型
          id:Menu.mid,
          menuIcon:Menu.menuIcon,
          menuName:Menu.menuName,
          menuUrl:Menu.menuUrl,
          parentId:Menu.parentId,
          state:Menu.state
        };
        // 打开修改对话框
        this.updateDialog = true;
      },
      initDelete() {
        // console.log(this.deleteIndex);
        var index = this.deleteIndex;
        var Menu = this.menuEntityList[index];
        this.deleteParams = {
          type: "deleteMenu",
          id: Menu.mid
        };
        console.log(this.deleteParams.id)
        this.deleteMenu(this.deleteParams);
      },
      updateMenu(params) { //修改数据 提交数据到服务器
        var vm = this;
        axios({
          method: "post",
          url: "/menu.do",
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
      deleteMenu(params) { // 删除选中的一条数据
        var vm = this;
        axios({
          method: "post",
          url: "/menu.do",
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
      // 查询列表中的数据
      this.queryAll(this.showParams);
      this.findAllParent(this.findAllParams)
    }
  };

  var vueMenu = Vue.extend(Menu);
  new vueMenu().$mount("#Menu");
</script>
</body>
</html>