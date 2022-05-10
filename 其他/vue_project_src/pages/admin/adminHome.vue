<template>
  <div class="admin_wrapper">
    <el-container>
  <el-header style="margin:0;padding:0;height:80px">
      <div class="manage-wrapper" >
    <el-avatar :size="70"  style="margin-left:30px;margin-top:8px" >
      <img src="../../../static/img/admin.jpg"/>
    </el-avatar>
       <span style="color:white;font-size:20px;position:absolute;top:25px;left:125px">博客后台管理系统</span>
       <span v-if="admin" style="float:right;color:white;margin-right:50px;margin-top:20px" @click="adminQuit">退出登录</span>
      </div>
  </el-header>
  <el-container>
<div class="aside-wrapper">
  
<el-aside width="200px" >
               <el-menu default-active="2-4" class="el-menu-vertical-demo"  @select="handleSelect" 
:collapse="isCollapse" background-color="#545c64"  active-text-color="#ffd04b" text-color="#fff" 
>
  <el-submenu index="1">
    <template slot="title">
      <i class="el-icon-user-solid"></i>
      <span slot="title">用户管理</span>
    </template>
    <el-menu-item-group>
      <span slot="title">分组一</span>
      <router-link to="/userInfo">
      <el-menu-item index="1-1">用户信息</el-menu-item>
      </router-link>
      <router-link to="/userActions">
      <el-menu-item index="1-2">用户动态</el-menu-item>
      </router-link>
      <router-link to="/blogExpert">
      <el-menu-item index="1-3">博客专家</el-menu-item>
      </router-link>
    </el-menu-item-group>
    </el-submenu>
    
  </el-submenu>
<!-- 博客管理 -->
<el-submenu index="2">
    <template slot="title">
      <i class="el-icon-notebook-1"></i>
      <span slot="title">博客管理</span>
    </template>
    <el-menu-item-group>
      <span slot="title">分组一</span>
      <router-link to="/abbel">
      <el-menu-item index="2-1">博客标签</el-menu-item>
      </router-link>
      <router-link to="/manageNews">
      <el-menu-item index="2-2">官方博客</el-menu-item>
      </router-link>
    </el-menu-item-group>
    <el-menu-item-group title="分组2">
      <router-link to="/manageAllBlog">
      <el-menu-item index="2-3">全部博客</el-menu-item>
      </router-link>
      <router-link to="/recoBlog">
      <el-menu-item index="2-4">推荐博客</el-menu-item>
      </router-link>
    </el-menu-item-group>
  </el-submenu>
  


  <el-menu-item index="3">
    <i class="el-icon-collection"></i>
    <router-link to='/adminUserMessage'>
    <span style="color:white;text-decoration:white;">用户留言</span>
    </router-link>
  </el-menu-item>

  <el-menu-item index="4">
    <i class="el-icon-setting"></i>
    <router-link to="/manageSite">
    <span  style="color:white;text-decoration:white;">社区管理</span>
    </router-link>
  </el-menu-item>
</el-menu> 
</el-aside>
</div>


<el-main>
    <router-view></router-view>
</el-main>

  </el-container>
</el-container>






  </div>
</template>

<script>
  export default {
    data() {
      return {
        isCollapse: false,
        collapse:false,
        admin:localStorage.getItem("admin")
      };
    },
    methods: {
      handleSelect(index) {
          // this.$router.push('/adminLogin')
    },
    adminQuit() {
       localStorage.removeItem("admin");
       this.admin = null;
       location.reload();
    }
 

      //    handleOpen(key, keyPath) {
      //   // console.log(key, keyPath);
      // },
      // handleClose(key, keyPath) {
      //   // console.log(key, keyPath);
      // }
      },
      created(){
          // this.GetBlogList();
      }
    }
</script>
<style scoped>
  .admin_wrapper{
      display: flex;
      align-items:flex-start;
  }
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 730px;
    
  }
  .manage-wrapper{
    width: 100%;
    height: 80px;
    background-color: #545C64;
  }
  .aside-wrapper{
     height: 500px;
     position: sticky;
     top:0
  }
</style>