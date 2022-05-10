<template>
<div>

  <div class="headerNavWrapper" >
      <div class="headerNav">
      <ul class="flex-wrapper" style="height:70px">
          <li class="log" style="font-size:20px;margin-left:3px"><span >NewWeb</span></li>
          <li  @click="toHome" style="margin-left:50px"><a href="javascript:;">主页</a></li>
          <li style="margin-left:50px" @click="toMyBlog"> <a href="javascript:;">我的博客</a> </li>
          <!-- <li  @click="toMessage"><a href="javascript:;">留言</a></li> -->
          <li @click="toEdit" style="margin-left:50px;"><a href="javascript:;">写博客</a></li>
          <!-- <li style="margin-left:50px;margin-right:200px" class="self-center"> <router-link to="profile">个人中心</router-link> </li> -->
          <li style="margin-left:50px;margin-right:110px" class="self-center" @click="toUserCenter"> <a href="javascript:;">个人中心</a></li>
          <li><input class="search" v-model="searchValue" type="text" style="height:25px;padding:0;margin-right:22px;" placeholder="react17源码" ><a href="javascript:void(0);"><i @click="Search"  style="font-size:14px;position:relative;left:-50px" class="el-icon-search icon"></i></a></li>         

     <li>
            <!-- 消息通知 -->
<!-- <el-badge :value="$store.state.infoCount" :max="10" class="item" style="margin-right:30px">  <el-button type="info" icon="el-icon-message" @click="myInform" circle></el-button></el-badge> -->
<!-- <el-badge class="item" style="margin-right:50px">  <el-button type="info" icon="el-icon-message" circle></el-button></el-badge> -->
     </li>

          <li v-if="username" style="color:skyblue;font-weight:bold;margin-right:15px">
            <!-- https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png -->
            <el-avatar size="small" src="../../static/img/user.gif" style="position:relative;top:5px"></el-avatar> 
            <span>{{username}}</span></li>
          <li v-if="username"><a href="javascript:;" @click="quitLogin">退出登录</a></li>
          <li v-if="!username" style="margin-right:10px"><a href="javascript:;" @click="toLogin"> <el-button type="success" plain>立即登录</el-button></a></li>         
          <li v-if="!username"><a href="javascript:;" @click="toRegister"> <el-button type="success" >免费注册</el-button></a></li>         
      </ul>
      </div>
  </div>
  <div class="saveHeight"></div>

  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  data () {
    return {
      // userInfo: JSON.parse(localStorage.getItem("userInfo_key")),
      username: localStorage.getItem("username") || '',
      searchValue:"",
    }
  },
  created() {
    //  if(this.username) {
    //     this.getInfoCount(this.username);
    //  }
  },
methods:{
  ...mapActions(['search']),
  ...mapActions(['getInfoCount']),
    // 跳转到aboutAuthor组件
    toEdit() {
           if(this.username){
      this.$router.push('/blogEdit')
      }else{
        var flag = window.confirm("该功能登录可查看，确定登录吗");
        if(flag) {
          this.$router.push('/login')
        }
      }
    },
    // 搜索功能
    Search() {
      if(this.searchValue == "") {
        this.search("react17源码");
      }else {
       this.search(this.searchValue);
      }
      //  this.$router.push('searchDetail');
      this.$router.push({path:"/searchDetail",query:{value:this.searchValue}});
       this.searchFlag = 0;
    },
    // 跳转到home组件
    toHome() {
       this.$router.push('/');
    },
    handleSelect(key, keyPath) {
        console.log(key, keyPath);
    },
    // 跳转到login组件
    toLogin() {
      this.$router.push('/login');
    },
    // 跳转到留言界面
    toMessage() {
      this.$router.push('/messageBoard');
    },
    quitLogin() {
      // localStorage.clear();
      localStorage.removeItem("username")
      this.username = null;
      // this.$store.state.UserInfo = "";
      location.reload();
    },
    toRegister() {
      this.$router.push('register');
    },
    myInform() {
      if(this.username){
      this.$router.push({path:'/myInform',query:{Flag: 1}})
      }else{
        var flag = window.confirm("该功能登录可查看，确定登录吗");
        if(flag) {
          this.$router.push('/login')
        }
      }
    },
    toMyBlog() {
      if(this.username){
      this.$router.push({path:'/myBlog',query:{Flag: 1}})
      }else{
        var flag = window.confirm("该功能登录可查看，确定登录吗");
        if(flag) {
          this.$router.push('/login')
        }
      }
    },
    toUserCenter() {
      if(this.username){
      this.$router.push('/profile')
      }else{
        var flag = window.confirm("该功能登录可查看，确定登录吗");
        if(flag) {
          this.$router.push('/login')
        }
      }
    }
  }
}
</script>
<style scoped>
/* 解决导航条fixed高度塌陷 */
.saveHeight{
  height: 70px;
}

.search{
  border:1px solid rgb(194, 179, 179);
  width: 180px;
  border-radius: 5px;
  outline: none;
}

.headerNavWrapper{
  height: 70px;
  background-color:rgb(253, 251, 251);
  width: 100%;
  text-align: center;
  line-height: 70px;
  position: fixed;
  z-index: 100;
}
/* 消息提示 */
.headerNavWrapper >>> .el-badge__content {
    position: absolute;
    top:15px;
}

/* li:nth-child(6):hover{
  background-color:rgb(231, 222, 222) ;
} */
/* li:nth-child(1):hover{
  background-color:rgb(121, 115, 115) ;
} */
.headerNav{
  width: 1124px;
  margin:0 auto ;
}
.log{
  margin-left:-30px;
  font-size: 12px;
  line-height: 70px;
  color: rgb(50, 245, 11);
}
ul,li{
  padding: 0;
  list-style: none;
  margin: 0;
}
.flex-wrapper{
  display: flex;
}
/* 
.flex-wrapper li{
  width: 80px;
}
 .flex-wrapper li:first-child{
  font-size: 30px;
  width: 150px;
} */
/* .flex-wrapper li:nth-child(6){
  margin-left: 110px;
  width: 200px;
} */
/*
.flex-wrapper li:nth-child(7){
  width: 100px;
}
.flex-wrapper li:nth-child(8){
  width: 100px;
}

.flex-wrapper li:nth-child(9){
  width: 100px;
}  */
li a:hover{
  /* background-color: rgb(101, 101, 102); */
  color: rgb(248, 95, 95);
  font-weight: bold;
}

a{
  text-decoration: none;
  color: rgb(10, 10, 10);
}

</style>
