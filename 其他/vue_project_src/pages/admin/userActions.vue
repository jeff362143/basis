<template>
  <div>
  <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>用户管理</el-breadcrumb-item>
  <el-breadcrumb-item>用户动态</el-breadcrumb-item>
</el-breadcrumb>

 <el-table
    :data="$store.state.userActions"
    border
    style="width: 100%"
    key="index"
    >
    
    <el-table-column
      fixed
      v-if="$store.state.userActions"
      prop="id"
      label="id"
      width="120">
    </el-table-column>

    <el-table-column
      fixed
      v-if="$store.state.userActions"
      prop="username"
      label="账号"
      width="150">
    </el-table-column>
    <el-table-column
          v-if="$store.state.userActions"

      prop="lastWriteTime"
      label="上一次发博时间"
      width="180">
    </el-table-column>
    <el-table-column
          v-if="$store.state.userActions"

      prop="likeBlogCount"
      label="喜欢的博客"
      width="150">
    </el-table-column>
    <el-table-column
          v-if="$store.state.userActions"

      prop="selfBlogNumber"
      label="个人博客"
      width="150">
    </el-table-column>
 
    <el-table-column
       v-if="$store.state.userActions"
      prop="selfCollBlogNumber"
      label="收藏博客"
      width="150">

       </el-table-column>
    <el-table-column
       v-if="$store.state.userActions"
      prop="commentCount"
      label="评论数量"
      width="150">

    </el-table-column>
    <el-table-column
      fixed="right"
      label="管理员操作"
      width="200">

      <template slot-scope="scope">
          <router-link :to="{path:'/userDetailActions',query:{username:scope.row.username,selfBlog:scope.row.selfBlogNumber}}" >
       <el-button  type="primary"  @click="handleClick(scope.row)" >查看用户全部博客</el-button>
          </router-link>
      </template>
    </el-table-column>

  </el-table>
  
  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  data () {
    return {
 drawer: false,
      direction: 'rtl',

      userInfo:{},
      // input:"",
      newUsername:"",
      newName:"",
      newPassword:""
 
    }
  },
  created() {
    
                                             if(localStorage.getItem("admin")) {
           this.$store.dispatch('getUserActions')
      }
  },
  methods:{
    ...mapActions(['queryByUsername']),
    ...mapActions(['saveNewUserInfo']),
    ...mapActions(['getUserActions']),
    ...mapActions(['queryUserActionsByUsername']),

    handleClick(row) {
        
    },
    saveNewInfo() {
        if(this.newUsername&&this.newName&&this.newPassword){
        this.drawer = false;
        this.saveNewUserInfo({"id":this.userInfo.id,"username":this.newUsername,"name":this.newName,"password":this.newPassword});
        }else{
          alert("更改信息必须填写完整")
        }

    }
,
handleClose(done) {
        // this.$confirm('确认关闭？')
          // .then(_ => {
            done();
          // })
          // .catch(_ => {});
      },
  }
}
</script>
<style scoped>
.reviseUserInfo li{
  list-style: none;
}
.reviseUserInfo{
  margin-left: 35px;
}
.reviseUserInfo span{
  margin-left: 20px;
}
</style>