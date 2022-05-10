<template>
  <div>
      <h3>所有通知如下：</h3>
      <div>
          <p v-for="value in $store.state.inform" style="border-bottom:1px solid rgb(200, 200, 200);padding-bottom:15px">
               <!-- <span style="color:#175199;margin-right:10px">{{value.sender}}</span> -->
               <router-link :to="{path:'/userHome',query:{blogAuthor:value.sender}}" style="text-decoration:none">
               <span style="color:#175199">{{value.sender}}</span> 
               </router-link>
               <span>{{value.content}}</span>
               <!-- <span style="margin-left:10px;color:#175199">{{value.blogtitle}}</span> -->
               <router-link :to="{path:'/blogContentDetail',query:{blogId:value.blogid,blogAuthor:value.owner}}" style="text-decoration:none">
               <span style="color:#175199">{{value.blogtitle}}</span> </router-link>
          </p>
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
  methods: {
      ...mapActions(['getSelfInform'])
  },
  created() {
      this.getSelfInform(this.username)
  }
}
</script>
<style scoped>
</style>