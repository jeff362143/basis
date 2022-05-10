<template>
  <div>
            <h3 class="title">我的关注  共 <span style="color:red">{{$store.state.followedUser.length}}</span>人</h3>
          <div class="blog"  v-for="value in $store.state.followedUser">
               <router-link :to="{path:'/userHome',query:{blogAuthor:value.username}}" style="text-decoration:none"><span style="border:1px solid gray;font-size:12px;color:gray">USER</span> <span style="color:rgb(78, 74, 74)">{{value.username}}</span> </router-link>
          </div>
  </div>
</template>


<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
       username: localStorage.getItem("username") || '',
    }
  },
  methods:{
    ...mapActions(['getFollowedUser']),
  },
  created() {
    this.getFollowedUser({"action":"getFollowedUser","username": this.username,"flag":""});
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