<template>
  <div>

  <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>用户管理</el-breadcrumb-item>
  <el-breadcrumb-item>用户动态</el-breadcrumb-item>
  <el-breadcrumb-item>动态详细</el-breadcrumb-item>
</el-breadcrumb>

<h4>他共有博客 <span style="color:red">{{selfBlog}}</span>  篇
</h4>

    <div class="userInfo">
  <!-- <div style="line-height:80px;font-size:20px">
    <span>用户名：<span style="color:gray">{{username}}</span></span>
    <el-divider direction="vertical"></el-divider>
    <span>个人博客数量：<span style="color:gray">{{selfBlog}}</span></span>
    <el-divider direction="vertical"></el-divider>
    <span>个人收藏博客数量：<span style="color:gray">{{collBlog}}</span></span>
    <el-divider direction="vertical"></el-divider>
  </div> -->
   
    <!-- <el-button type="info" @click.native="GetCollBlogs" v-if="buttonFlag">TA的收藏博客</el-button>
    <el-button type="success" @click.native="GetSelfBlogs" v-if="buttonFlag">TA的个人博客</el-button>
    <el-button type="danger" @click.native="GetSelfBlogs" v-if="buttonFlag">TA的所有评论</el-button> -->
    <!-- <div v-for="value in $store.state.userBlog">
        <h5>{{value.title}}</h5>  
        <p>{{value.content}}</p>    
        <hr>
    </div> -->
    <div class="main">
      <div class="user-blog-wrapper">
   <div class="userBlog" v-for="value,index in $store.state.userBlog" >
      <el-timeline class="list" style="margin:0;width:800px">
        <el-card >
          <p class="blogContent" @click="toBlogManage(value.id)"><span style="color:black">{{index+1}}、</span>{{ value.title }} <span style="margin-left:90px;color:gray">发布于：{{value.createTime}}</span></p>
        </el-card>
      </el-timeline>
   </div>
      </div>

    </div>

    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
return{
  flag: this.$route.query.flag,
  username : this.$route.query.username,
  selfBlog : this.$route.query.selfBlog,
  // collBlog : this.$route.query.collBlog,
  buttonFlag: 1
}
  },
    methods: {
      ...mapActions(['getUserBlogByUsername']),
      // ...mapActions(['getMyCollBlog']),
    //  获取收藏博客
    //  GetCollBlogs() {
    //     this.buttonFlag = !this.buttonFlag;
    //     this.getMyCollBlog(this.username);
    //   },
      // 获取个人博客
      toBlogManage(id){
        this.$router.push({path:'/blogManage',query:{blogId:id}});
      },
      GetSelfBlogs() {
        location.reload();
      }
    },
    created(){
            if(localStorage.getItem("admin")) {
            //  this.getUserBlogByUsername({"username": this.username})
            this.getUserBlogByUsername(this.username)
      }
    }
}
</script>
<style scoped>
.main{
  display: flex;
}
.right-info-wrapper{
  margin-left: 15px;
  width: 300px;
  height: 400px;
  background-color: #fff;
}
.userInfo{
  font-weight: bold;
}
.userInfo span{
  color:coral
}
.userBlog{
  margin-left: -40px;
}
.blogContent{
  margin: 0;
  color: gray;
}
.blogContent:hover{
 color: red;
}
</style>