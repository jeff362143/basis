<template>
  <div>

<el-dialog
  title="新增用户"
  :visible.sync="dialogVisible"
  width="30%"
  >
<div style="margin: 20px;"></div>
  账号：<el-input style="width:300px;margin:0 20px 20px 0" v-model="username"></el-input> <br>
  描述：<el-input style="width:300px" v-model="admindesc"></el-input>
  <span slot="footer" class="dialog-footer" >
    <el-button @click="dialogVisible = false" >取 消</el-button>
    <el-button type="primary"  @click="updateExpertInfo">提 交</el-button>
  </span>
</el-dialog>

         <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>用户管理</el-breadcrumb-item>
  <el-breadcrumb-item>博客专家</el-breadcrumb-item>
</el-breadcrumb>

     <el-table
    :data="$store.state.expertInfo"
    border
    style="width: 60%"
    key="index"
    >
<el-table-column
      fixed
      v-if="$store.state.expertInfo"
      prop="userId"
      label="对应用户id"
      show-overflow-tooltip	 
      width="180">
    </el-table-column>

    <el-table-column
      v-if="$store.state.expertInfo"
      prop="username"
      label="账号"
      width="150">
    </el-table-column>

    <el-table-column
       v-if="$store.state.expertInfo"
      prop="admindesc"
      label="描述"
      width="250">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="180">

      <template slot-scope="scope">
       <el-button type="primary" icon="el-icon-edit" @click="handleClick(scope.row)">修改信息</el-button>
      </template>
    </el-table-column>

  </el-table>

  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  data () {
    return {
        dialogVisible:false,
        username:"",
        admindesc:"",
        formerUsername: "",
        flag: 0
    }
  },
  methods:{
      ...mapActions(['updateExpert']),
      ...mapActions(['getExpert']),
         handleClick(row) {
         this.dialogVisible = true;
         this.formerUsername = row.username;
         this.username = row.username;
         this.admindesc = row.admindesc;
      },
      updateExpertInfo() {
          
          this.updateExpert({
            "action": "updateExpert",
            "formerUsername": this.formerUsername,
            "username": this.username,
            "desc": this.admindesc
          });    
          this.flag = !this.flag; 
      }
  },
  watch: {
      'flag': function() {
        this.dialogVisible = false;
        var timer = setInterval(function(){alert("修改成功");clearInterval(timer);location.reload();},300)
        
      }
  },
  created() {
      
         if(localStorage.getItem("admin")) {
          this.getExpert();
      }
  }
}
</script>
<style scoped>
</style>