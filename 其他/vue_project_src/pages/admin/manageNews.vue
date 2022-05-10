<template>
  <div>

     <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>博客管理</el-breadcrumb-item>
  <el-breadcrumb-item>官方博客</el-breadcrumb-item>
</el-breadcrumb>


<div class="menu">
    <span style="padding-bottom:10px" @click="changeMenu(1)" :class="{clickMenu: flag == 1}">今日推荐</span> <span @click="changeMenu(0)" :class="{clickMenu: flag == 0}" style="padding-bottom:10px;margin-left:30px;">轮播图</span>
</div>

       <el-table
    :data="$store.state.todayReco"
    border
    style="width: 95%"
    key="index"
    >

    <el-table-column
      fixed
      v-if="$store.state.todayReco"
      prop="title"
      label="标题"
      show-overflow-tooltip	 
      width="180">
    </el-table-column>

    <el-table-column
      v-if="$store.state.todayReco"
      show-overflow-tooltip	 
      prop="content"
      label="内容"
      width="280">
    </el-table-column>


    <el-table-column
      v-if="$store.state.todayReco"
      prop="createTime"
      label="编辑时间"
      width="150">
    </el-table-column>


    <el-table-column
      v-if="$store.state.todayReco"
      prop="author"
      label="作者"
      width="150">
    </el-table-column> 
 
    <el-table-column
       v-if="$store.state.todayReco"
      prop="collCount"
      label="收藏数"
      width="130">
    </el-table-column>

    <el-table-column
       v-if="$store.state.blogList"
      prop="likedCount"
      label="点赞数"
      width="130">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="150">

      <template slot-scope="scope">
       <el-button type="primary" icon="el-icon-edit"  @click="handleClick(scope.row)">编辑该博客</el-button>
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
      flag:1
    }
  },
  methods:{
      ...mapActions(['getNews']),
      ...mapActions(['getTodayReco']),
      changeMenu(index) {
        this.flag = index;
        if(index == 1) {
           this.getTodayReco();
        } else {
           this.getNews();
        }
      },
       handleClick(row) {
         this.$router.push({path:'/editNews',query:{newsId: row.id}})
       }
  },
  created () {
        
                                     if(localStorage.getItem("admin")) {
           this.getTodayReco();
      }
      },
    watch:{
      '$store.state.news':function() {
          this.$store.state.todayReco = this.$store.state.news; 
    }
  }
}
</script>
<style scoped>
.clickMenu{
  border-bottom:1px solid red
}
.menu{
  margin-bottom: 30px;
}
a{
    text-decoration:none;
    color:white
}
</style>