<template>
  <div>
        <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>博客内容管理</el-breadcrumb-item>
</el-breadcrumb>



    <div class="blog-content-wrapper">
        <div class="blog-content">
        <h1>{{$store.state.blogDetail.title}}</h1>
        <div class="blog-info">
           <img src="../../../static/img/original.png" style="height:50px;vertical-align:middle;">
           <span style="margin:0 20px">{{$store.state.blogDetail.author}}</span>
           <span style="margin:0 20px;color:gray">{{$store.state.blogDetail.createTime}}</span>
           <span style="color:gray;margin-left:50px"><i class="el-icon-delete" @click="deleteUserBlog">删除博客</i></span>
           <span style="color:gray;margin-left:50px" v-if="!flag" @click="setReco(0)"><i class="el-icon-trophy">设为推荐</i></span>
           <span style="color:gray;margin-left:50px" v-if="flag" @click="setReco(1)"><i class="el-icon-trophy">已推荐</i></span>
           <!-- <span style="color:gray" v-if="!userCollFlag" @click="collect(0)"> <i class="el-icon-star-off" ></i> 收藏</span>  -->
           <!-- <span style="color:gray" v-if="userCollFlag"  @click="collect(1)"> <i class="el-icon-star-on"></i> 已收藏</span> -->
           <!-- <i style="float:right;position:relative;top:15px;right:40px" class="el-icon-edit" @click="editMyblog"></i> -->
        </div>

           <div class="blog-content-detail" v-html="$store.state.blogDetail.content">
              
           </div>
           <div class="tool-box">
             <div style="position:relative;top:4px;left:15px">
                  <!-- <i v-if="userLikeFlag" class="el-icon-magic-stick"></i><span v-if="userLikeFlag" @click="showMyLike(1)"> 已点赞{{$store.state.blogDetail.likedCount}}</span> -->
                  <!-- <i v-if="!userLikeFlag" class="el-icon-magic-stick"></i><span v-if="!userLikeFlag" @click="showMyLike(0)"> 点赞{{$store.state.blogDetail.likedCount}}</span> -->
                  <!-- <i style="margin-left:30px" class="el-icon-chat-dot-square"></i> <span> 评论 <span>{{this.commentsLength}}</span></span> -->
                  <!-- <i v-if="!userCollFlag" style="margin-left:30px" class="el-icon-star-off"></i> <span v-if="!userCollFlag" @click="collect(0)">收藏{{$store.state.blogDetail.collCount}}</span> -->
                  <!-- <i v-if="userCollFlag" style="margin-left:30px" class="el-icon-star-on"></i> <span v-if="userCollFlag" @click="collect(1)">已收藏{{$store.state.blogDetail.collCount}}</span> -->

                  <!-- <i style="margin-left:30px" class="el-icon-s-flag"></i> <span> 举报</span> -->
                     <!-- <el-button  v-if="!followFlag" size="medium" type="danger" round style="position:relative;left:25px;top:-2px;" @click="followed(0)">关注</el-button> -->
                     <!-- <el-button  v-if="followFlag" size="medium" type="danger" round style="position:relative;left:25px;top:-2px;" @click="followed(1)">已关注</el-button> -->
             </div>
           </div>
           <!-- <el-input
  type="textarea"
  :rows="4"
  placeholder="友善的评论是交流的第一步，留下您的高见吧。"
  v-model="input"
  style="margin-left:10px;width:700px">
</el-input> -->
  <!-- <el-button type="danger" @click="submitMyComment">提交</el-button> -->
           <div class="blog-comments" v-for="value,index in $store.state.blogDetail.comments">
              <div style="margin:10px;color:gray"><img src="../../../static/img/user.gif" width="30px" alt="" style="vertical-align:middle;"> <span style="margin-left:10px">  <span >{{value.username}}</span> ：  {{value.comment}} <span style="margin-left:15px;font-size:13px">{{value.commentTime}}</span> </span> <i @click="deleteUserComment(value.commentId,index)"  style="margin-left:20px" class="el-icon-delete"></i></div>
              <hr>
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
    return {
      id: this.$route.query.blogId,
      flag: 0
    }
  },
  methods: {
    ...mapActions(['getBlogDetailById']),
    ...mapActions(['deleteCommentById']),
    ...mapActions(['judgeRecoById']),
    ...mapActions(['setBlogReco']),
    ...mapActions(['deleteBlog']),
    deleteUserComment(commentId,index) {
     var flag = window.confirm("确定删除该评论吗？");
      if(flag == true) {
         this.$store.state.blogDetail.comments.splice(index,1); // 前端删除
         this.deleteCommentById({
            "action": "deleteComment",
           "commentId": commentId
         });
      }else{}
    },
    setReco(flag) {
       this.setBlogReco({"action":"setReco","flag": flag, "id": this.id});
    },
    deleteUserBlog() {
       var flag = window.confirm("您确定要删除该博客吗?");
            if(flag) {
            this.deleteBlog({"action":"deleteBlog","id": this.id});
     }
    }
  },
  created() {
        if(localStorage.getItem("admin")) {
           this.getBlogDetailById(
        {
          "action": "getBlogDetailsById",
          "username":"NewWeb官方",
          "id": this.id
        }
        ),
        this.judgeRecoById({"action":"judgeReco","id": this.id});
      }
       
  },
  watch:{
    '$store.state.recoFlag': function() {
       this.flag = !this.flag;
    },
  }

}
</script>
<style scoped>
.blog-info{
  width: 98%;
  height: 50px;
  background-color: rgb(241, 236, 236);
} 
</style>