<template>
  <div>
                  <h3 class="title">我的点赞  共 <span style="color:red">{{$store.state.userBlog.length}}</span> 条</h3>
          <div class="blog"  v-for="value in $store.state.userBlog">
             <router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}" style="text-decoration:none"> <span style="border:1px solid gray;font-size:12px;color:gray">BLOG</span> <span style="color:rgb(78, 74, 74)">{{value.title}}</span> </router-link>
          </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
      username: localStorage.getItem("username"),
    }
  },
  methods:{
    ...mapActions(['getUserLikeBlog'])
  },
  created() {
      this.getUserLikeBlog(this.username);
  }
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
</style>