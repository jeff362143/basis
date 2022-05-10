<template>
  <div>

  
<!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>博客管理</el-breadcrumb-item>
  <el-breadcrumb-item>全部博客</el-breadcrumb-item>
</el-breadcrumb>




  <!-- 全部博客的内容 -->
     <el-table
    :data="$store.state.adminAllBlogs"
    border
    style="width: 100%"
    key="index"
    >

    <el-table-column
      fixed
      v-if="$store.state.adminAllBlogs"
      prop="title"
      label="标题"
      show-overflow-tooltip	 
      width="180">
    </el-table-column>


    <el-table-column
      v-if="$store.state.adminAllBlogs"
      show-overflow-tooltip	 
      prop="content"
      label="内容"
      width="280">
    </el-table-column>


    <el-table-column
      v-if="$store.state.adminAllBlogs"
      prop="createTime"
      label="编辑时间"
      width="150">
    </el-table-column>


    <el-table-column
      v-if="$store.state.adminAllBlogs"
      prop="author"
      label="作者"
      width="150">
    </el-table-column> 
 
    <el-table-column
       v-if="$store.state.blogList"
      prop="collCount"
      label="收藏数"
      width="130">
    </el-table-column>

    <el-table-column
       v-if="$store.state.blogList"
      prop="likedCount"
      label="点赞数"
      width="130">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="180">

      <template slot-scope="scope">
       <el-button type="primary" icon="el-icon-edit" @click="handleClick(scope.row)">管理该博客</el-button>
      </template>
    </el-table-column>

  </el-table>




<!-- 隐藏抽屉 -->
<!-- <el-drawer
  :visible.sync="drawer"
  :direction="direction"
>
  <div class="reviseUserInfo">
   <h2 style="color:red;margin-left:50px;">管理该博客</h2>
<hr>
<nav style="margin-left:50px">
<el-button type="success">查看全部内容</el-button>
 <el-button type="info">设置首页推荐</el-button>
 <el-button type="warning">删除该博客</el-button>
</nav>
 <div v-html="content">
  
</div>
  </div>
</el-drawer> -->


  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
      scope:"",
      drawer: false,
      direction: 'rtl',
      content:""
    }
  },
  methods:{
    ...mapActions(['getAllBlog']),
    handleClick(row) {
      // var content = row.content;
      // var MardownIt = require("markdown-it");
      // var md = new MardownIt();
      // this.content = md.render(content);
      // this.drawer = true;
      this.$router.push({path:'/blogManage',query:{blogId:row.id}});
    }
  },
  created(){
   
           if(localStorage.getItem("admin")) {
           this.getAllBlog();
      }
  },
}
</script>
<style scoped>
</style>