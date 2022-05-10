<template>
  <div class="home">


    <!-- 首部导航组件 -->
    <headerNav />

  <div class="homeBanner">
<!-- <i class="el-icon-close" style="color:gray;position:absolute;right:30px;top:90px;font-size:30px;"></i> -->

    <div class="buttonWrapper" style="margin-left">
      

      <div class="description" style="margin-top:30px;margin-left:0px">
          <p style="color: white;font-size:25px;margin:0">在NewWeb学习技能，分享博客</p>
          <p style="color: white;font-size:20px;margin-bottom:0">这里有许多优秀的软件开发者，它们在这里记录了他们的学习心得。</p>
          <p style="color: white;font-size:20px;margin-top:5px">给初学者提供了一个良好的学习平台。</p>
      </div>

<div style="margin-left:250px;margin-top:50px" >
          <router-link to="/register"><el-button style="color:green;font-size:18px" v-if="!username">免费注册</el-button></router-link>
          <router-link to="/login"><el-button type="success" style="color:white;font-size:18px" v-if="!username">立即登录</el-button></router-link>
      </div>

    </div>

  </div>


    <!-- 页面主要内容 -->
    <div class="mainContent">
      <!-- 左边导航条，脱离文档流（position） -->
      <div class="left-menu-wrapper">
        <ul class="left-menu">
          <li
            v-for="(value, index) in blogList"
            v-bind:class="{ bgc: index == isactive }"
            @click="selectBlog(value.name, index)"
          >
            <a href="#javascript:;" @click.prevent="">{{ value.name }}</a>
          </li>
        </ul>
      </div>

      <!-- 博客内容 -->
      <blogContent />


<!-- 博客专家 -->
<div class="right_menu_wrapper" style="margin-left:15px;margin-top:20px">
     <div class="expert" style="width:290px;height:330px;background-color:white;border:1px solid white" >
      <h3  style="margin-left:20px;margin-top:10px;margin-bottom:5px">博客专家</h3>
      <div  v-for="value in $store.state.expertInfo" @click="toExpertHome(value.username)">
      <p style="margin-left:20px;margin-top:25px"><img src="../../static/img/coder.png" style="width:50px"><span style="position:relative;top:-30px;" class="expert-name"><a href="javascript:void(0);">{{value.username}}</a></span><img src="../../static/img/expertbig.png" style="width:50px;position:relative;top:-30px;left:70px" alt=""><span style="position:relative;top:-15px;left:30px;color:gray">{{value.blogCount}}篇</span></p>
      <p style="margin-left:20px;margin-top:-20px">{{value.admindesc}}</p>
       </div>

    </div>


    <!-- 今日推荐 -->
    <div class="todayReco">
       <h3 style="margin-top:10px;margin-left:20px">今日推荐</h3>
       
       <div style="display:flex;margin-bottom:10px" v-for="value in $store.state.todayReco">
           <img src="../../static/img/todayReco.png" style="width:50px;margin-left:20px">
           <p style="margin:0;width:180px;height:35px;font-size:15px;margin-left:9px;font-weight:bold;color:rgb(90, 84, 84)"><router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}">{{value.title}}</router-link></p>
       </div>



    </div>
</div>



    </div>
  </div>
</template>

<script>
import headerNav from "../components/headerNav";
import blogContent from "../components/blogContent";
// 在vuex使用mapState映射state,简化操作state中的数据
import { mapState } from "vuex";
// 简化调用action操作
import { mapActions } from "vuex";

export default {
  data() {
    return {
      fits: ['fill'],
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',

      // userInfo: JSON.parse(localStorage.getItem("userInfo_key")),
      // UserInfo: "",
      username: localStorage.getItem("username"),

      isactive: 0,
      allBlog: 0,
      sortedBlog: 0,
      myCollection: 0,
      flag: 0,

      // 显示的博客数量（我的收藏和全部博客）
      num:0,
      // 
      Flag:0
    };
  },
  components: {
    headerNav,
    blogContent,
  },
  computed: {
    ...mapState(["blogContent"]),
    ...mapState(["blogList"]),
  },
  methods: {
    ...mapActions(["getBlog"]),
    ...mapActions(["getBlogList"]),
    ...mapActions(['getNews']),
    ...mapActions(['getTodayReco']),
    ...mapActions(['getExpert']),
    

    ...mapActions(['getUserBlog']),
    ...mapActions(['getMyCollBlog']),
    ...mapActions(['getUserInfo']),
    ...mapActions(['getCommentsById']),
    ...mapActions(['getNewsDetail']),

//  0是第一张。1是第二张
    newsDetail(index){
        
         var MardownIt = require("markdown-it");
         var md = new MardownIt();
         this.$store.state.news[index].content = md.render(this.$store.state.news[index].content)

        if(index == 0) {
            this.$store.state.blogDetail = this.$store.state.news[0];
            this.getCommentsById(this.$store.state.news[0].id);
            this.$router.push('blogContentDetail');
            
        }else{
            this.$store.state.blogDetail = this.$store.state.news[1];
            this.getCommentsById(this.$store.state.news[1].id);
            this.$router.push('blogContentDetail');
        }
    },
    
    selectBlog: function (name, index) {
      this.isactive = index;
      this.getBlog(name);

    },
    editBlog() {
      if (this.$store.state.username) {
        this.$router.push("/blogEdit");
      } else {
        this.$router.push("/login");
      }
    },
    confirm(index) {
      // if (!this.$store.state.userInfo.username) {
        if(!this.username){
        if (window.confirm("登录才能查看，确认登录吗")) {
            this.$router.push('/Login');
        }
      }else{
          if(index == 'editBlog') {
            this.$router.push('/blogEdit')
          }else if(index == 'allBlogs') {
          }else if(index == 'sortBlog') {
          }else if(index == 'myCollection') {
          }
      }
    },
    // 
    appearBlog(list) {
      // 获取信息
      if(this.username){
      if(list == "allBlog") {
          this.getUserBlog(this.username);
        //  this.num = this.$store.state.userInfo.blogCount;
         this.Flag = 1;
      }else{
        //  this.num = this.$store.state.userInfo.blogColl;
          this.getMyCollBlog(this.username.username);
         this.Flag = 0;
      }
      // 显示隐藏层
      // if(this.$store.state.username.username){
            this.flag = 1;
      }
    },
    hiddenBlog() {
      this.flag = 0;
    },
    selectMyBlog(index,Flag) {
       if(Flag == 1){
           this.$router.push({path:'MyBlogDetails',query:{sort:Flag,Index:index}})
       }else{
          //  全部博客中的内容是未渲染的
            var MardownIt = require("markdown-it");
            var md = new MardownIt();
            this.$store.state.userBlog[index].content = md.render(this.$store.state.userBlog[index].content)

           this.$store.state.blogDetail = this.$store.state.userBlog[index];           
           this.getCommentsById(this.$store.state.userBlog[index].id);
       } 
    },

    // 专家主页
    toExpertHome(username) {
      this.$router.push({path:'userHome',query:{blogAuthor:username}});
    }
  },
  created() {
    this.getBlog("推荐");
    this.getBlogList();
    this.getNews();
    this.getTodayReco();
    this.getExpert();
  },
  watch:{
    '$store.state.blogComments': function() {
       this.$router.push('blogContentDetail')
    }
  }
};
</script>

<style scoped>





.mainContent .left-menu-wrapper .bgc {
  background-color: pink;
}
.mainContent {
  min-height: 600px;
  width: 1124px;
  margin: 0 auto;
  display: flex;
  /* align-items: baseline; */
}
.left-menu li {
  list-style: none;
  background-color: #ffffff;
  line-height: 35px;
  text-align: center;
  font-size:14px;

}

.left-menu li:hover {
  background-color: rgb(252, 211, 203);
  color: red;
}
.left-menu-wrapper {
  margin-top: 20px;
  width: 110px;
  position: sticky;
  top: 70px;
  height: 10px;
}
ul {
  padding: 0;
  margin: 0;
}
.right-menu li {
  list-style: none;
  margin: 15px 0px;
}
/* 设置menu-one中li标签的div */
.menu-one li div {
  margin: 0 30px;
  border: 2px solid skyblue;
  padding: 5px;
  border-radius: 8px;
}
.right-menu {
  /* position: sticky; */
  margin-top: 18px;
  width: 250px;
  margin-left: 8px;
}
.menu-one {
  width: 260px;
  border: 2px solid rgb(231, 222, 222);
  background-color: #ffffff;
  height: 300px;
  position: relative;
}
/* 设置我的博客隐藏层 */
.myBlogDetail {
  width: 420px;
  height: 500px;
  /* background-color: rgb(245, 240, 240); */
  background-color: #fff;
  border: 1px solid rgb(164, 166, 167);
  border-radius: 20px;
  position: absolute;
  display: none;
  left: -162%;
  top: 0;
  overflow: auto;
  box-shadow: 0 0 10px rgba(0, 0, 0,0.3),-5px -5px 10px rgba(0, 0, 0,0.3);
}
::-webkit-scrollbar 
{ 
  width: 20px; 
}
::-webkit-scrollbar-thumb 
{ 
  border-radius: 10px; 
  background-color: rgba(0,0,0,0.1);
} 
/* 设置右侧我的博客移入弹出隐藏层 */
/* .menu-one li:hover ~ .myBlogDetail,
.myBlogDetail:hover {
  display: block;
} */
/* 写博客列表特殊处理，不能弹出隐藏层 */
/* .menu-one .writeBlog:hover ~ .myBlogDetail {
  display: none;
} */
/* 这个class用于显示隐藏层 */
.appear{
    display: block;
}
/* 隐藏层本身hover也会显示 */
.myBlogDetail:hover{
  display: block;
}

/* 设置我的博客中的列表文字的位置 */
.menu-one li div {
  padding-left: 20px;
  padding-right: 20px;
}
.menu-two {
  width: 260px;
  border: 2px solid rgb(231, 222, 222);
  margin-top: 5px;
  height: 330px;
  background-color: #ffffff;
}
a {
  text-decoration: none;
  color: rgb(114, 107, 107);
}
span {
  color: skyblue;
  /* border: 2px solid skyblue; */
  padding-left: 3px;
  padding-right: 3px;
  font-weight: bold;
}
/* 博客列表点击变色 */
.bgc {
  color: black;
}
.menu-one li div:hover{
    background-color: rgba(132, 204, 233, 0.6);
    
}
.menu-one li a{
  color: black;
}

.myBlogDetail >>> span :hover{
  color: red;
}



/* 跑马灯的样式 */
.el-carousel__item h3 {
    color: #e7ebf0;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

.homeBanner{
  width: 100%;
  /* display:none; */
  height: 170px;
  background-image: url(../../static/img/bannerHome.png);
  
  /* background-image: url(https://cdn.pixabay.com/photo/2018/03/10/09/49/city-3213676__340.jpg); */
  /* https://cdn.pixabay.com/photo/2020/02/22/17/53/communication-4871245__340.jpg */

}

.buttonWrapper{
  display: flex;
  width: 1124px;
  margin: 0 auto;
}

.todayReco{
  width: 290px;
  border:1px solid rgb(216, 214, 214);
  background-color: #fff;
  margin-top:15px;
}

.todayReco a{
  color: gray;
}
.todayReco a:hover{
  color: red;
}
.expert-name{
  color:rgb(100,100,100)
}
.expert >>> a:hover{
  color: red;
}

</style>