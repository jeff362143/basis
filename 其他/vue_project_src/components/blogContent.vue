<template>
  <!-- 博客内容 -->
  <div class="blog_wrapper">
      
    <div class="banner"   >
       
  <el-carousel indicator-position="outside" height="220px" >
    <el-carousel-item v-for="value,index in news" :key="index"  @click.native="toNewsDetail(value.id,value.author)">
        <p style="color:white;font-size:25px;margin-left:40px;margin-top:150px" >{{value.title}}</p> 
    </el-carousel-item>
  </el-carousel>

    </div>


    <span style="margin-left:20px">为你推荐</span>
    <hr>


    <div
      class="block"
      v-if="$store.state.blogContent[0]"
      v-for="value in $store.state.blogContent"
    >
      
<!-- 每一列的博客预览 -->
      <div class="blogWrap">
          <div class="blog" >
              <router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}" style="color:black;text-decoration:none"><h4 class="blog-title" >{{value.title}}</h4></router-link>
              <div class="blogContent" style="height:16px">
                <!-- <span>{{value.author}}</span> -->
                <div > <span class="el-icon-user-solid"></span><router-link :to="{path:'/userHome',query:{blogId:value.id,blogAuthor:value.author}}" style="text-decoration:none;">{{value.author}}</router-link></div>
                <div class="markdownBlog" v-html="value.content"></div>
                <div style="height:30px"><i class="el-icon-date"></i> {{value.createTime}}</div>
              </div>
          </div>
      </div>
<!-- 下面这个div是.block -->
    </div>   
    </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  data() {
    return {
      //  fits: ['fill'],
      //   url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        news: ""
     };
  },
  methods: {
    ...mapActions(['judgeColl']),
    ...mapActions(['getCommentsById']),
    // 主页的博客到博客的详细页，显示全部内容以及它的全部评论
     toDetail(event,title,content,createTime,author,id) {
       if(JSON.parse(localStorage.getItem("userInfo_key"))) {
       if(event.target.localName == 'a'){
         return false;
       }
       this.$store.state.blogDetail.title = title;
       this.$store.state.blogDetail.content = content;
       this.$store.state.blogDetail.createTime = createTime;
       this.$store.state.blogDetail.author = author;
       this.$store.state.blogDetail.id = id;
      //  this.$router.push('/blogContentDetail');
      this.getCommentsById(id);
       }else{
          this.$store.state.blogDetail.title = title;
       this.$store.state.blogDetail.content = content;
       this.$store.state.blogDetail.createTime = createTime;
       this.$store.state.blogDetail.author = author;
          this.getCommentsById(id);
       }
     },
      toNewsDetail(id,author) {
        this.$router.push({path:'/blogContentDetail',query:{blogId:id,blogAuthor:author}});
  },
  },
  created() {
    this.news = this.$store.state.news;
    this.news = this.news.concat(this.news)
  },

  watch:{
    '$store.state.blogComments': function() {
       this.$router.push('blogContentDetail')
    },
    '$store.state.news': function() {
       this.news = this.$store.state.news;
    this.news = this.news.concat(this.news)
    }
  }
};
</script>

<style scoped>

.el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 220px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-image: url(../../static/img/bannerOne.png);
   background-size: cover;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-image: url(../../static/img/bannerTwo.png);
   background-size: cover;
  }




.banner{
  margin: 20px;
  width: 95%;
  height: 230px;
}
.list {
  padding: 0;
}
/* 博客作者颜色设置 */
.list a{
  /* color:rgb(35, 223, 160); */
  text-decoration: none;
  font-size: 16px;
  font-weight: 500;
  color: rgb(90, 84, 84);
}
.list a:hover{

  color: red;
}
.blog_wrapper {
  width: 700px;
  margin-top: 20px;
  margin-left: 10px;
  padding: 0;
  border: 1px solid rgb(231, 222, 222);
 
}
/* 设置博客预览时超出内容省略号  */
.blogContent{
  overflow: hidden;
}
/* .blogContent:hover{color: red;}
.blogContent >>> p {
    width: 520px;
    height: 20px;
    overflow: hidden;    
    text-overflow: ellipsis;
    white-space: nowrap;
}  
.blogContent >>>h1,h2,h3,h4,h5{
  font-size: 15px;
}
/* 博客中含有图片，给图片设置vertical-align:top，避免文字与图片底部对齐（无法显示在正确的位置） */
/* .blogContent >>> img{
  display: none;
}


.list >>> .el-card__body{padding:15px} */




/* blog预览项的外层容器 */
.blogWrap{
  height: 70px;
  border-bottom: 1px solid rgb(231, 228, 228);
  background-color:#FFF;
}
.blog{
  height: 53px;
  padding: 17px 0;
}
h4{
  margin: 0;
  padding: 0;
  padding-left: 25px;
}
.blogContent{
  display: flex;
  height: 40px;
  overflow: hidden;
  padding: 5px 0;
  padding-left: 25px;
  font-size: 15px;
  color: rgb(102, 99, 99);
  align-items:stretch;

  /* color: #8a8a8a; */
}
.markdownBlog{
  width: 400px;
  height: 30px;
  overflow: hidden;
  margin-left: 20px;
  margin-right: 10px;
}
.markdownBlog >>> h1,
.markdownBlog >>> h2,
.markdownBlog >>> h3,
.markdownBlog >>> h4,
.markdownBlog >>> h5{
  margin: 0;
  margin-top: -5px;
  font-size: 15px;
  line-height: 30px;
  font-weight: 500;
}
.markdownBlog >>> img{
  display: none;
}
.markdownBlog >>> p{
  margin: 0;
  padding: 0;
  width: 400px;
  white-space: nowrap;
  overflow:hidden;       
  text-overflow:ellipsis;  
}

.blog-title{
  color:rgb(60,60,60);
}

.blog-title:hover{
  color: red;
}

.blogWrap a{
  color: gray;
}
.blogWrap a:hover{
  color: red;
}
</style>
