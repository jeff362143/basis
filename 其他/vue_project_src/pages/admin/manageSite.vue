<template>
  <div>
     <!-- 面包屑 -->
<el-breadcrumb separator-class="el-icon-arrow-right" style="margin-bottom:20px">
  <el-breadcrumb-item :to="{ path: '/adminHome' }">首页</el-breadcrumb-item>
  <el-breadcrumb-item>社区管理</el-breadcrumb-item>
</el-breadcrumb>



  <el-table
    :data="$store.state.blogContent"
    border
    style="width: 95%"
    key="index"
    >
<!-- 
    <el-table-column
      fixed
      v-if="$store.state.blogContent"
      prop="id"
      label="id"
      show-overflow-tooltip	 
      width="180">
    </el-table-column> -->



    <el-table-column
      v-if="$store.state.blogContent"
      prop="title"
      label="标题"
      width="300">
    </el-table-column> 
 
    <el-table-column
       v-if="$store.state.blogContent"
      prop="complainer"
      label="举报者"
      width="130">
    </el-table-column>

    <el-table-column
       v-if="$store.state.blogContent"
      prop="blogAuthor"
      label="被举报者"
      width="130">
    </el-table-column>

        <el-table-column
       v-if="$store.state.blogContent"
      prop="time"
      label="time"
      width="130">
    </el-table-column>

    <el-table-column
      fixed="right"
      label="管理员操作"
      width="500">

      <template slot-scope="scope">
       <el-button type="primary" icon="el-icon-edit"  @click="handleClick(scope.row)">管理该博客</el-button>
      </template>
    </el-table-column>

  </el-table>




  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
    }
  },
  created() {
    
                                         if(localStorage.getItem("admin")) {
           this.manageSite();
      }
  },
  methods:{
    ...mapActions(['manageSite']),
    handleClick(row) {
       this.$router.push({path:'/blogManage',query:{blogId:row.id}});
    }
  }
}
</script>
<style scoped>
</style>