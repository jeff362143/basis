<template>
  <div class="blog-Detail-wrapper">

    <headerNav/>

    <div  class="blog-wrapper">
    <div class="author-info-wrapper">
        <div class="author-self-info">
        <el-avatar :size="50" style="margin:10px 0 0 10px">
            <router-link :to="{path:'/userHome',query:{blogAuthor:blogAuthor}}"><img src="../../static/img/user.gif" width="50px" alt=""></router-link>
        </el-avatar>
             
        <span style="position:relative;top:-15px;left:10px">{{$store.state.blogDetail.author}}<img v-if="offcialFlag" src="../../static/img/enstaf.png" width="30px" style="position:relative;top:10px;left:5px" alt=""> </span>
         <span v-if="!offcialFlag"><el-button v-if="!followFlag" type="danger" style="position:relative;left:35px;top:-19px" @click="followed(0)">关注</el-button>
         <el-button v-if="followFlag" type="danger" style="position:relative;left:35px;top:-19px" @click="followed(1)">已关注</el-button>
         </span>
        <div class="author-action" style="margin:15px 0 0 10px">
            <div style="font-size:14px"><span>个人博客</span><span style="margin:10px  10px 0 15px">收藏博客</span><span style="margin-left:20px">最近写博</span></div>
            <div style="margin:10px 0 10px 20px;color:gray">
              {{$store.state.userActions.selfBlogNumber}}<span style="margin-left:40px"></span>
              {{$store.state.userActions.selfCollBlogNumber}} <span style="margin-left:50px"></span>
              {{$store.state.userActions.lastWriteTime}}
            </div>
            <div style="font-size:14px"><span>粉丝数量</span><span style="margin:10px  10px 0 15px">评论总数</span></div>
            <div style="margin:10px 0 10px 20px;color:gray">
              {{$store.state.userActions.followedUserCount}}<span style="margin-left:50px"></span>
              {{$store.state.userActions.commentCount}} <span style="margin-left:50px"></span>
            </div>
            <p style="color:gray;margin-top:0px">{{$store.state.userActions.desc}}</p>
        </div>
        </div>
        <div class="author-new-blog" style="border:1px solid white">
            <h3 style="margin:15px">最新博客</h3>
            <div v-for="value in $store.state.userBlog" class="new-blog-wrapper">
                <div style="margin:0 0 10px 20px;"><span>{{value.createTime}}</span><div class="new-blog-title" style="margin-left:10px;"><router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}" @click.native="reload"><a href="javascript:void(0);" style="text-decoration:none;">{{value.title}}</a></router-link></div></div>    
            </div>
        </div>
    </div>
  

    <div class="blog-content-wrapper">
        <div class="blog-content">
        <h1>{{$store.state.blogDetail.title}}</h1>
        <div class="blog-info">
           <img src="../../static/img/original.png" style="height:50px;vertical-align:middle;">
           <span style="margin:0 20px">{{$store.state.blogDetail.author}}</span>
           <span style="margin:0 20px;color:gray">{{$store.state.blogDetail.createTime}}</span>
           <span style="color:gray" v-if="!userCollFlag" @click="collect(0)"> <i class="el-icon-star-off" ></i> 收藏</span> 
           <span style="color:gray" v-if="userCollFlag"  @click="collect(1)"> <i class="el-icon-star-on"></i> 已收藏</span>
           <i style="float:right;position:relative;top:15px;right:40px" class="el-icon-delete" @click="deleteMyBlog"></i>
           <i style="float:right;position:relative;top:15px;right:100px" class="el-icon-edit" @click="editMyblog"></i>
        </div>

           <div class="blog-content-detail" v-html="$store.state.blogDetail.content">
              
           </div>
           <div class="tool-box">
             <div style="position:relative;top:4px;left:15px">
                  <i v-if="userLikeFlag" class="el-icon-magic-stick"></i><span v-if="userLikeFlag" @click="showMyLike(1)"> 已点赞{{$store.state.blogDetail.likedCount}}</span>
                  <i v-if="!userLikeFlag" class="el-icon-magic-stick"></i><span v-if="!userLikeFlag" @click="showMyLike(0)"> 点赞{{$store.state.blogDetail.likedCount}}</span>
                  <i style="margin-left:30px" class="el-icon-chat-dot-square"></i> <span> 评论 <span>{{this.commentsLength}}</span></span>
                  <i v-if="!userCollFlag" style="margin-left:30px" class="el-icon-star-off"></i> <span v-if="!userCollFlag" @click="collect(0)">收藏{{$store.state.blogDetail.collCount}}</span>
                  <i v-if="userCollFlag" style="margin-left:30px" class="el-icon-star-on"></i> <span v-if="userCollFlag" @click="collect(1)">已收藏{{$store.state.blogDetail.collCount}}</span>

                  <i style="margin-left:30px" class="el-icon-s-flag"></i> <span @click="report"> 举报</span>
                     <el-button  v-if="!followFlag" size="medium" type="danger" round style="position:relative;left:25px;top:-2px;" @click="followed(0)">关注</el-button>
                     <el-button  v-if="followFlag" size="medium" type="danger" round style="position:relative;left:25px;top:-2px;" @click="followed(1)">已关注</el-button>
             </div>
           </div>
           <el-input
  type="textarea"
  :rows="4"
  placeholder="友善的评论是交流的第一步，留下您的高见吧。"
  v-model="input"
  style="margin-left:10px;width:700px">
</el-input>
  <el-button type="danger" @click="submitMyComment">提交</el-button>
           <div class="blog-comments" v-for="value,index in $store.state.blogDetail.comments">
              <div style="margin:10px;color:gray"><img src="../../static/img/user.gif" width="30px" alt="" style="vertical-align:middle;"> <span style="margin-left:10px">  <span @click="toUserHome(index)">{{value.username}}</span> ：  {{value.comment}} <span style="margin-left:15px;font-size:13px">{{value.commentTime}}</span> </span> <i @click="deleteUserComment(value.commentId,index)"  style="margin-left:20px" v-if="blogAuthor==username" class="el-icon-delete"></i></div>
              <hr>
           </div>
        </div>
    </div> 
</div>

  </div>
</template>

<script>
import { mapActions } from 'vuex';
import headerNav from "../components/headerNav";
export default {
  components: {
    headerNav,
  },
  mounted() {
  },
  data() {
    return {
        blogId: this.$route.query.blogId,
        username:  localStorage.getItem("username") || '',
        blogAuthor: this.$route.query.blogAuthor,
        input:"",
        userCollFlag:0,
        offcialFlag: 0,
        followFlag: 0,
        commentsLength: 0,
        userLikeFlag: 0
    };
  },
  methods:{
    ...mapActions(['getUserBlogByUsername']),
    ...mapActions(['getBlogDetailById']),
    ...mapActions(['queryUserActionsByUsername']),
    ...mapActions(['submitComment']),
    ...mapActions(['judgeColl']),
    ...mapActions(['collectBlog']),
    ...mapActions(['judgeFollow']),
    ...mapActions(['followedUser']),
    ...mapActions(['showLike']),
    ...mapActions(['judgeLike']),
    ...mapActions(['deleteCommentById']),
    ...mapActions(['deleteBlog']),
    ...mapActions(['sendLikeInform']),
    ...mapActions(['compainReport']),
    //   提交评论
        submitMyComment() {
      // 获取当前评论的时间
      var date = new Date();
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
      var hour = date.getHours();
      var minute = date.getMinutes();
      var second = date.getSeconds();
      var time = (year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second);

      if(localStorage.getItem("username")) {
      this.submitComment({
          username:this.username,
          comment: this.input,
          commentTime:time,
          id: this.$store.state.blogDetail.id,

        });
      } else {
      var flag = window.confirm("您未登录，是否登录？")
      if(flag){
      this.$router.push('login')
      }
    }
},
// 收藏与取消收藏博客
    collect(flag) {
      if(localStorage.getItem("username")) {
        if(flag == 0 ){
          this.$store.state.blogDetail.collCount = this.$store.state.blogDetail.collCount + 1;
        }else{
          this.$store.state.blogDetail.collCount = this.$store.state.blogDetail.collCount - 1;
        }
      this.collectBlog({
        "action": "collectBlog",
        "username": localStorage.getItem("username"),
        "flag": flag,
        "id": this.blogId
      });
    }else {
      var flag = window.confirm("您未登录，是否登录？")
      if(flag){
      this.$router.push('login')
      }
    }
    },
    reload() {
      this.$router.go(0)
    },

    // 关注和取消关注用户
    followed(followFlag) {

      if(localStorage.getItem("username")) {

      if(followFlag == 1) {
          this.$store.state.userActions.followedUserCount = this.$store.state.userActions.followedUserCount - 1;
      }else{
          this.$store.state.userActions.followedUserCount = this.$store.state.userActions.followedUserCount + 1;
      }

      this.followedUser({
        "action": "followedUser",
        "username": this.username,
        "blogauthor": this.blogAuthor,
        "flag": followFlag
      })
    }else {
      var flag = window.confirm("您未登录，是否登录？");
      if(flag){
      this.$router.push('login');
      }
    }
    },

//  点赞和取消点赞
    showMyLike(flag) {



        if(localStorage.getItem("username")) {
           if(flag == 0 ){

        // 点击喜欢后会发生信息到用户后台
        this.sendLikeInform({
          
          "owner": this.blogAuthor,
          "blogid": this.blogId,
          "sender": this.username,
          "blogtitle": this.$store.state.blogDetail.title
        });

          this.$store.state.blogDetail.likedCount = this.$store.state.blogDetail.likedCount + 1;
        }else{
          this.$store.state.blogDetail.likedCount = this.$store.state.blogDetail.likedCount - 1;
        }
        this.showLike({
           "action": "showLike",
           "blogId": this.blogId,
           "username": this.username,
           "flag": flag
        });
    }else {
      var flag = window.confirm("您未登录，是否登录？")
      if(flag){
      this.$router.push('login')
      }
    }
    },

    toUserHome(index) {
        this.$router.push({path:'/userHome',query:{blogAuthor:this.$store.state.blogDetail.comments[index].username}})  
    },

    editMyblog() {
       if(this.blogAuthor == this.username) {
         this.$router.push({path:'/blogEdit',query:{blogId: this.blogId}})
       } else {
         alert('没有访问权限')
       }
    },

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

    deleteMyBlog() {
        if(this.username == this.blogAuthor) {
            var flag = window.confirm("您确定要删除该博客吗?");
            if(flag) {
            this.deleteBlog({"action":"deleteBlog","id": this.blogId});
            }
        }else{
          alert("您没有权限")
        }
    },

    report() {
      var flag = window.confirm("确定举报该博客");
      if(flag) {
      if(this.blogAuthor == this.username) {
        alert("举报自己？？？");
      } else {
      var time = new Date();
      time = time.toLocaleDateString();
      this.compainReport({
        "action": "compainReport",
        "title":  this.$store.state.blogDetail.title,
        "time": time,
        "blogAuthor": this.blogAuthor,
        "username": this.username,
        "blogId": this.blogId
      });
      }
    }
    }

},  // methods


  created() {
//    官方博客时特殊处理,加一个官方标志
      if(this.blogAuthor == 'NewWeb官方') {
        this.offcialFlag = 1;
      }

//    获取博客详细内容
      this.getBlogDetailById(
        {
          "action": "getBlogDetailsById",
          "username": this.username,
          "id": this.blogId
          }
        );

//    获取博客主人的个人详细信息
       this.queryUserActionsByUsername(this.blogAuthor);

//     获取博客主人最新博客标题
      this.getUserBlogByUsername(this.blogAuthor)

// 关注判断    收藏判断   收藏判断
      if(localStorage.getItem("username")){
           this.judgeColl({
             "action": "JudgeColl",
             "username": this.username,
             "id": this.blogId
      });

           this.judgeFollow(
             {
               "action": "judgeFollow",
               "username": this.username,
               "blogauthor": this.blogAuthor
             }
           );

           this.judgeLike({
             "action": "judgeLike",
             "id": this.blogId,
              "username": this.username
           })
    }
  },

  watch:{
    '$store.state.loadFlag': function() {
      location.reload();
    },
    '$store.state.collFlag': function() {
       this.userCollFlag = !this.userCollFlag;
    }, 
    '$store.state.likeFlag': function() {
       this.userLikeFlag = !this.userLikeFlag;
    },
    '$store.state.followFlag': function() {
       this.followFlag = !this.followFlag;
    },
    '$store.state.blogDetail.author': function() {
      if(this.$store.state.blogDetail.author == 'NewWeb官方') {
        this.offcialFlag = 1;
      }else{
        this.offcialFlag = 0;
      }
    },
    '$store.state.blogDetail': function() {
      this.commentsLength = this.$store.state.blogDetail.comments.length;
    },
    '$store.state.Flag': function() {
       alert("删除成功，返回首页");
       this.$router.push('/')
    }
  }

} // data

</script>
<style scoped>
.list {
  width: 900px;
  margin: 0 auto;
}
h4 {
  margin-top: 20px;
  font-size: 40px;
  text-align: center;
}
.time {
  text-align: center;
}
.content {
  width: 750px;
  margin: 0 auto;
  min-height: 350px;
}

.blog-Detail-wrapper{
  background-image: url(../../static/img/bgc.jpeg);
  min-height: 750px;
}

.blog-wrapper{
  display: flex;
  width: 1150px;
  margin: 0 auto;
  align-items:flex-start;
}

.author-info-wrapper{
  position: sticky;
  top:70px;
   width: 300px;
}
.author-self-info{
  width: 100%;
  height: 250px;
  background-color: #fff;
  margin: 10px 0;
}
.author-new-blog{
  overflow: hidden;
  width: 100%;
  height: 410px;
  background-color: #fff;
}

.blog-content-wrapper{
  margin:10px 0 0 10px;
  width: 900px;
  min-height: 700px;
  background-color: #fff;
}
.blog-content{
  width: 93%;
  margin: 0 auto;
}
.blog-info{
  width: 98%;
  height: 50px;
  background-color: rgb(241, 236, 236);
  
}
.new-blog-wrapper >>> div a{
  text-decoration: none;
  color: gray;
}
.new-blog-wrapper >>> div a:hover{
  color: red;
}
.tool-box{
  width: 90%;
  margin-left:10px;
  height: 40px;
  background-color: rgb(241, 234, 234);
}
.tool-box span,
.tool-box i{
  color: gray;
}
</style>