<template>
  <div >
<!-- 弹出框  -->
<el-dialog
  title="新增用户"
  :visible.sync="dialogVisible"
  width="30%"
  :before-close="handleClose">
<div style="margin: 20px;"></div>
<el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
  <el-form-item label="账号">
    <el-input v-model="formLabelAlign.name"></el-input>
  </el-form-item>

  <el-form-item label="密码">
    <el-input v-model="formLabelAlign.password"></el-input>
  </el-form-item>
</el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary"  @click="registerNewUser">提 交</el-button>
  </span>
</el-dialog>


  
<!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>用户管理</el-breadcrumb-item>
  <el-breadcrumb-item>用户列表</el-breadcrumb-item>
</el-breadcrumb>

  <el-input style="width:300px" v-model="input" placeholder="根据账号查找用户"></el-input><el-button @click.native="queryUserInfo"  style="background-color:rgb(230,230,230)" ><i class="el-icon-search" ></i></el-button>
  <el-button type="primary" @click="dialogVisible = true">添加用户</el-button>  
 
 <el-table
    :data="$store.state.adminUserInfo"
    border
    style="width: 100%"
    key="index"
    >
    
    <el-table-column
      fixed
      v-if="$store.state.adminUserInfo"
      prop="id"
      label="id"
      width="70">
    </el-table-column>

    <el-table-column
      fixed
      v-if="$store.state.adminUserInfo"
      prop="time"
      label="创建日期"
      width="140">
    </el-table-column>
    <el-table-column
      v-if="$store.state.adminUserInfo"

      prop="name"
      label="真实姓名"
      width="120">
    </el-table-column>
    <el-table-column
      v-if="$store.state.adminUserInfo"

      prop="username"
      label="账号"
      width="130">
      
    </el-table-column>
    <el-table-column
      v-if="$store.state.adminUserInfo"

      prop="password"
      label="密码"
      width="140">
    </el-table-column>
 
    </el-table-column>
    <el-table-column
       v-if="$store.state.adminUserInfo"
      prop="selfDesc"
      label="个性签名"
      show-overflow-tooltip	 
      width="180">
    </el-table-column>
    
        <el-table-column
       v-if="$store.state.adminUserInfo"
      prop="company"
      label="公司"
      show-overflow-tooltip	 
      width="140">
    </el-table-column>

        <el-table-column
       v-if="$store.state.adminUserInfo"
      prop="job"
      label="职位"
      show-overflow-tooltip	 
      width="140">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="250">

      <template slot-scope="scope">
       <el-button  type="primary"  @click="handleClick(scope.row)" >编辑账号</el-button>
       <!-- <el-button  type="info">加入黑名单</el-button> -->
      </template>
    </el-table-column>

  </el-table>

<el-drawer
   title="修改用户信息"
  :visible.sync="drawer"
  :direction="direction"
>
  <div class="reviseUserInfo" style="color:gray">
      <h3 style="color:gray">当前信息：</h3>
        <li>账号：<span style="margin-left:5px">{{userInfo.username}}</span></li>
        <li>密码：<span style="margin-left:5px">{{userInfo.password}}</span></li>
<hr style="margin-top:30px;margin-bottom:30px">
      <h3 style="color:gray">输入您修改后的信息:</h3>
      <el-input style="width:200px;margin:10px 0" v-model="newUsername" placeholder="新账号名" ></el-input><br>
      <el-input style="width:200px" v-model="newPassword" placeholder="新密码"></el-input><br>
       <el-button  type="primary" @click="saveNewInfo" >保存</el-button>
  </div>
</el-drawer>



  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  data () {
    return {
    drawer: false,
    direction: 'rtl',

      userInfo:{},
      // 搜索框
      input:"",
      newUsername:"",
      newPassword:"",

         dialogVisible: false,
           labelPosition: 'left',
        formLabelAlign: {
          name: '',
          password: ''
        }
    }
  },
  created() {
   
            if(localStorage.getItem("admin")) {
            this.$store.dispatch('adminGetAllUserInfo');  
      }
  },
  methods:{
    ...mapActions(['queryByUsername']),
    ...mapActions(['saveNewUserInfo']),
    ...mapActions(['adminGetAllUserInfo']),
    ...mapActions(['userRegister']),
    // 根据用户名搜索
    queryUserInfo() {
      this.queryByUsername(this.input);
    },
    handleClick(row) {
        this.userInfo = row;
        this.drawer = true;
    },
    saveNewInfo() {
        if(this.newUsername&&this.newPassword){
        this.drawer = false;
        this.saveNewUserInfo({"id":this.userInfo.id,"username":this.newUsername,"password":this.newPassword});
        }else{
          alert("更改信息必须填写完整")
        }

    },

 handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      adminGetAllUserInfo() {
        this.adminGetAllUserInfo()
      },
      registerNewUser() {
        this.dialogVisible = true;
        var time = new Date();
        var time = time.toLocaleDateString();
        this.userRegister({
              "username": this.formLabelAlign.name,
              "password": this.formLabelAlign.password,
              "time": time
        })
      }
  }
}
</script>
<style scoped>
.reviseUserInfo li{
  list-style: none;
}
.reviseUserInfo{
  margin-left: 35px;
}
.reviseUserInfo span{
  margin-left: 20px;
}
</style>