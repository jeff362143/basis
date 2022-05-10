<template>
  <div>
               <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>博客管理</el-breadcrumb-item>
  <el-breadcrumb-item>推荐博客</el-breadcrumb-item>
</el-breadcrumb>

<div class="menu">
    <span style="padding-bottom:10px" @click="changeMenu(1)" :class="{clickMenu: flag == 1}">推荐位</span> <span @click="changeMenu(0)" :class="{clickMenu: flag == 0}" style="padding-bottom:10px;margin-left:30px;">非推荐</span>
</div>

 <!-- 全部博客的内容 -->
     <el-table
    :data="$store.state.blogContent"
    border
    style="width: 100%"
    key="index"
    >

    <el-table-column
      fixed
      v-if="$store.state.blogContent"
      prop="title"
      label="标题"
      show-overflow-tooltip	 
      width="180">
    </el-table-column>


    <el-table-column
      v-if="$store.state.blogContent"
      show-overflow-tooltip	 
      prop="content"
      label="内容"
      width="280">
    </el-table-column>


    <el-table-column
      v-if="$store.state.blogContent"
      prop="createTime"
      label="编辑时间"
      width="150">
    </el-table-column>


    <el-table-column
      v-if="$store.state.blogContent"
      prop="author"
      label="作者"
      width="150">
    </el-table-column> 
 
    <el-table-column
       v-if="$store.state.blogContent"
      prop="likedCount"
      label="点赞数"
      width="160">
    </el-table-column>

        <el-table-column
       v-if="$store.state.blogContent"
      prop="collCount"
      label="收藏数"
      width="160">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="180">

      <template slot-scope="scope">
       <el-button type="primary" icon="el-icon-edit" @click="handleClick(scope.row)">管理该博客</el-button>
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
        ...mapActions(['getRecoBlog']),
        changeMenu(index) {
        this.flag = index;
        if(index == 1) {
           this.getRecoBlog({"action":"getRecoBlog","flag": 1});
        } else {
           this.getRecoBlog({"action":"getRecoBlog","flag": 0});
        }
      },
        handleClick(row) {
      this.$router.push({path:'/blogManage',query:{blogId:row.id}});
    }
  },
  created() {
      if(localStorage.getItem("admin")) {
          this.getRecoBlog({"action":"getRecoBlog","flag": 1});
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
</style>