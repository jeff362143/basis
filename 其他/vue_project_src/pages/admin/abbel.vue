<template>
  <div>
      
   <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>博客管理</el-breadcrumb-item>
  <el-breadcrumb-item>博客标签</el-breadcrumb-item>
</el-breadcrumb>

  <el-input style="width:200px" v-model="input" placeholder="新增一个标签" ></el-input>
  <el-button @click="addlabel" type="primary" >增加</el-button>

<el-table
    :data="$store.state.blogList"
    border
    style="width: 80%"
    key="index"
>
    
    <el-table-column
      fixed
      v-if="$store.state.blogList"
      prop="id"
      label="id"
      width="180">
    </el-table-column>

    <!-- <el-table-column
      fixed
      v-if="$store.state.adminUserInfo"
      prop="time"
      label="创建日期"
      width="150">
    </el-table-column> -->


    <el-table-column
      v-if="$store.state.blogList"
      prop="name"
      label="标签名"
      width="180">
    </el-table-column>


    <!-- <el-table-column
      v-if="$store.state.adminUserInfo"
      prop="username"
      label="账号"
      width="150">
    </el-table-column> -->

<!-- 
    <el-table-column
      v-if="$store.state.adminUserInfo"

     -->
 
    </el-table-column>
    <el-table-column
       v-if="$store.state.blogList"
      prop="createTime"
      label="创建时间"
      width="180">
    </el-table-column>

    <el-table-column
       v-if="$store.state.blogList"
      prop="blogCount"
      label="拥有博客数量"
      width="180">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="180">

      <template slot-scope="scope">
       <el-button  type="info"  @click="handleClick(scope.row)"  >删除标签</el-button> 
      </template>
    </el-table-column>

  </el-table>

<!--  弹出层 -->
<el-drawer
   title="为标签新增内容"
  :visible.sync="drawer"
  :direction="direction"
>
  <div class="reviseUserInfo">
   <hr>
   <h3 style="color:red">全部博客如下:</h3>
  </div>
</el-drawer>

  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
      drawer:false,
      direction: 'rtl',
      input:"",
      deleteId:-1
    }
  },
  methods:{
    ...mapActions(['getBlogList']),
    ...mapActions(['addLabel']),
    ...mapActions(['deleteLabel']),
      //   handleClick(row) {
      //   console.log(row);
      // },
      addlabel() {
          var time = new Date();
          var createTime = time.toLocaleDateString();
               this.addLabel(
                {
                "action": "addLabel",
                "labelName": this.input,
                "createTime": createTime
                }
               )
        alert('增加成功');
        location.reload();
      },
      handleClick(row) {
        var flag = window.confirm("确定要删除该标签吗");
        if(flag) {
            this.deleteLabel(row.name);
            // alert('删除成功');
            location.reload();
        }

      },
      // 为标签新增博客,打开隐藏层
  },
  created(){
    
          if(localStorage.getItem("admin")) {
          this.getBlogList();
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