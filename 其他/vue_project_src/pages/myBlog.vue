<template>
  <div>
      <h3 class="title">我的全部博客  共 <span style="color:red">{{$store.state.userBlog.length}}</span> 篇</h3>
      <div class="myCollBlog">
          <div class="menu" style="margin-left:80px;color:rgb(78,74,74);">
              <span style="padding-bottom:10px" @click="Click(0)" :class="{clickFlag: flag}">按时间排序</span> 
              <!-- <span :class="{clickFlag: !flag}"  @click="Click(1)" style="margin-left:90px;padding-bottom:10px;">按点赞数排序</span> -->
          </div>
          <div class="blog" v-for="value in $store.state.userBlog">
              <router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}" style="text-decoration:none"><span style="border:1px solid gray;font-size:12px;color:gray">BLOG</span> <span style="color:rgb(78, 74, 74)">{{value.title}}</span></router-link> 
          </div>
      </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
        username: localStorage.getItem("username"),
        flag: 1,

    }
  },
  methods:{
      ...mapActions(['getUserBlogByUsername']),
      ...mapActions(['getUserLikeBlog']),
      Click(index){
    if(index == 0) {
        this.flag = 1;
        this.getUserBlogByUsername(this.username);
    }
    // if(index == 1) {
    //     this.flag = 0;
    //     this.getUserBlogByUsername({"username": this.username,"flag": "1"});
    //     // this.getUserLikeBlog(this.username)
    // }
}
  },
  created() {
      this.getUserBlogByUsername(this.username)
  },
}
</script>
<style scoped>
.title{
    color: rgb(95, 93, 93);
}
.blog{
    width: 700px;
    height: 40px;
    margin-top:25px;
    border-bottom: 1px solid rgb(223, 217, 217);
}
.clickFlag{
    border-bottom: 3px solid red;
}

</style>