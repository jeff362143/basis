<template>
  <div class="userHome_Wrapper">
      <headerNav></headerNav>
        <h1 style="margin-left:200px;color:white">{{blogAuthor}}的博客</h1>

       <div  class="blog-wrapper">

    <div class="author-info-wrapper">
        <div class="author-self-info">
        <el-avatar :size="50" style="margin:10px 0 0 10px">
            <img src="../../static/img/user.gif"/>
        </el-avatar>
        <span style="position:relative;top:-15px;left:10px">{{blogAuthor}}</span>
       <span style="position:relative;top:-15px;left:10px"><img v-if="offcialFlag" src="../../static/img/enstaf.png" width="30px" style="position:relative;top:10px;left:5px" alt=""> </span>
       <span v-if="!offcialFlag">
         <el-button v-if="!followFlag" type="danger" style="position:relative;left:35px;top:-19px" @click="followed(0)">未关注</el-button>
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
            <p style="color:gray;margin-top:20px">{{$store.state.userActions.desc}}</p>
            
        </div>
        </div>
        <div class="author-new-blog" style="border:1px solid white">
            <h3 style="margin:15px">精选博客</h3>
            <div v-for="value in $store.state.blogContent" class="new-blog-wrapper">
                <div style="margin:0 0 10px 20px"><span>{{value.createTime}}</span><div class="new-blog-title" style="margin-left:10px;"><a href="javascript:void(0);" style="text-decoration:none;"> <router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}">{{value.title}}</router-link></a></div> 
                 </div>    
            </div>
        </div>
    </div>
  

    <div class="blog-content-wrapper">
        <h4 style="font-weight:400;margin-left:30px;border-bottom:1px solid  #e8ebee;padding-bottom:20px"> <span style="padding-bottom:20px" :class="{'info-title': clickFlag==1}" @click="clickList('self')">个人博客({{$store.state.userActions.selfBlogNumber}})</span>  
        <span style="margin-left:50px;padding-bottom:20px" :class="{'info-title': clickFlag==2}"  @click="clickList('coll')">收藏博客({{$store.state.userActions.selfCollBlogNumber}})</span>
        <span style="margin-left:50px;padding-bottom:20px" :class="{'info-title': clickFlag==3}"  @click="clickList('like')">赞过博客({{$store.state.userActions.likeBlogCount}})</span>
        </h4>
        <div v-for="value,index in $store.state.userBlog" class="new-blog-wrapper" :key="index" >
                <div style="margin:0 0 10px 40px;border-bottom:1px solid rgb(210,210,210)">
                  <div class="new-blog-title" style="margin-left:10px;font-size:18px">
                    <router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}">{{value.title}}</router-link>
                 </div> 
                    <span style="color:gray;font-size:13px;margin-left:10px">{{value.createTime}}</span>
                 </div>    
        </div>
        
    </div> 

       </div>


  </div>
</template>

<script>
import { mapActions } from 'vuex'
import headerNav from '../components/headerNav'
export default {
  data () {
    return {
      blogAuthor: this.$route.query.blogAuthor,
      blogId: this.$route.query.blogId,
      username: localStorage.getItem("username") || '',
      clickFlag: true,
      followFlag:0,
      offcialFlag:0
    }
  },
  methods:{
    ...mapActions(['getUserBlogByUsername']),
    ...mapActions(['queryUserActionsByUsername']),
    ...mapActions(['getBlog']),
    ...mapActions(['getMyCollBlog']),
    ...mapActions(['judgeFollow']),
    ...mapActions(['getUserLikeBlog']),
    ...mapActions(['followedUser']),

    toDetail (index) {
         var MardownIt = require("markdown-it");
         var md = new MardownIt();
         this.$store.state.userBlog[index].content = md.render(this.$store.state.userBlog[index].content)
         
         this.$store.state.blogDetail = this.$store.state.userBlog[index];
  },

  clickList(flag) {
    if( flag == 'self' ) {
        this.clickFlag = 1;
        // this.getUserBlogByUsername(this.blogAuthor);
        this.getUserBlogByUsername({"username": this.blogAuthor})
    }else if(flag == 'coll'){
        this.clickFlag = 2;
        this.getMyCollBlog(this.blogAuthor);
    }else if(flag == 'like') {
        this.clickFlag = 3;
        this.getUserLikeBlog(this.blogAuthor);
    }
  },

  // 关注和取消关注
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
  },

  created(){
       if(this.blogAuthor == "NewWeb官方") {
         this.offcialFlag = 1;
       }
      //  获取博客作者个人信息
       this.queryUserActionsByUsername(this.blogAuthor);
      //  获取博客作者的全部博客
      //  this.getUserBlogByUsername({"username": this.blogAuthor});
       this.getUserBlogByUsername(this.blogAuthor);
      //  获取网站的推荐博客
       this.getBlog("推荐");
          if(localStorage.getItem("username")){
            // 判断登录用户是否关注该博客作者
              this.judgeFollow(
             { 
               "action": "judgeFollow",
               "username": this.username,
               "blogauthor": this.blogAuthor
             }
           )
    }

  },

  components:{
      headerNav
  },

  watch:{
    '$store.state.blogDetail':function() {
      // 数组是未渲染的，

      this.$router.push('blogContentDetail')
    },
        '$store.state.followFlag': function() {
       this.followFlag = !this.followFlag;
    },
    '$store.state.MyCollBlog': function() {
      this.$store.state.blogContent = this.$store.state.MyCollBlog;
    },
    '$store.state.userBlog': function() {
      this.authorblog = this.$store.state.userBlog
    }
  }
}
</script>
<style scoped>
    .userHome_Wrapper{
        background-image: url(../../static/img/bgc.jpeg);
         min-height: 750px;
    }
    .list{
        width: 1124px;
        padding: 0;
        margin: 0 auto;
    }
    .content_wrapper{
        height: 50px;
        overflow: hidden;
    }
    p >>> p{
         height: 30px; 
    width: 520px;
    overflow: hidden;    
    text-overflow: ellipsis;
    white-space: nowrap;
    }
    p >>> img{
        display:none;
    }
    .content_wrapper{
      overflow: hidden;
      white-space: nowrap;
      width: 800px;
      text-overflow: ellipsis;
    }
    h4 a:hover{
      color: red;
    }
    a{
      text-decoration: none;
      color:gray
    }


    .blog-Detail-wrapper{
  background-image: url(https://images.pexels.com/photos/1089438/pexels-photo-1089438.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500);
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
  height: 260px;
  background-color: #fff;
  margin: 10px 0;
}
.author-new-blog{
  overflow: hidden;
  width: 100%;
  height: 365px;
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
  color: gray;
}
.new-blog-wrapper >>> div a:hover{
  color: red;
}
/* 主内容点击变色 */
.info-title{
  color: red;
  border-bottom: 1px solid red;
}
.new-blog-wrapper .new-blog-title a{
  color:rgb(107, 105, 105);
}
.new-blog-title a:hover{
  color: red;
}
</style>