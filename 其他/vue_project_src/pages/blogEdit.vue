<template>
  <div class="blogEditWrapper" >

<!-- 弹出框  -->
<el-dialog
  title="选择标签"
  :visible.sync="dialogVisible"
  width="30%"
  >
    <div ><el-button  v-for="value,index in $store.state.blogList" :key="index" style="margin-left:20px;" @click="clickButton(value.name,index)" :class="{markBgc: index==markFlag }">{{value.name}}</el-button></div>
    <div style="margin-top:40px;margin-left:330px">
    <el-button type="primary" @click="saveBlog">提交</el-button>
    </div>
</el-dialog>

    <el-form label-width="140px" >
      <el-form-item label="编辑页面">
        <el-input
          v-model="blog.title"
          placeholder="标题为25个字符以下"
           style="width:90%"
        ></el-input>
          <el-button type="danger" style="height:80%" @click="selectMark">发布文章</el-button>
      </el-form-item>
    </el-form>

    <router-link to="/">
    <i class="el-icon-arrow-left" style="position:absolute;top:18px;left:15px;font-size:24px"></i>
    </router-link>

    <div class="edit">
      <mavon-editor v-model="blog.content" style="height:670px"></mavon-editor>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  data() {
    return {
      // 修改个人博客测试
      // reviseFlag : this.$route.query.reviseFlag,
      // Index: this.$route.query.index,
      username:  localStorage.getItem("username") || '',
      blogId: this.$route.query.blogId,
      dialogVisible:false,

      // 标签按钮
      markFlag:0,

      blog: {
        title: "",
        content: "",
        author:localStorage.getItem("username") || '',
        createTime:"",
        // 标签
        marked:"javascript"
      },
      flag: 0,
    };
  },
  mounted() {}, // mounted函数
  methods: {
    ...mapActions(["SaveBlog"]),
    ...mapActions(['updateBlog']),
    ...mapActions(['getBlogByIdForEdit']),
    ...mapActions(["getBlogList"]),
    selectMark(table,index) {
      if (!this.blog.title || !this.blog.content) {
        alert('内容和标题不能为空')
      } else {
      this.dialogVisible = true;
      this.$store.state.blogList.splice(0,1);
      }
    },
    clickButton(table,index) {
        this.markFlag = index;
        this.blog.marked = table;
    },
    saveBlog: function () {
      this.dialogVisible = false;
      if (!this.blog.title || !this.blog.content) {
        this.flag = 1;
      } else{
      var timer = new Date();
      this.blog.createTime = timer.toLocaleDateString();
      if(this.blogId) {
          this.updateBlog(
            {
              "id": this.blogId,
              "title": this.blog.title,
              "content": this.blog.content,
              "createTime":  this.blog.createTime,
              "marked": this.blog.marked 
            }
          )
          this.$alert("提交成功，将返回主界面", {
          confirmButtonText: "确定",
          callback: (action) => {
            this.$router.push("/");
          },
        });
      }else {
        this.SaveBlog(this.blog);
        this.$alert("提交成功，将返回主界面", {
          confirmButtonText: "确定",
          callback: (action) => {
            this.$router.push("/");
          },
        });
       }
      } // else
    },
  },

  // 修改博客的测试
  created() {
      //  获取博客未渲染内容
      if(this.blogId) {
      this.getBlogByIdForEdit(
        {
          "action": "getBlogDetailsById",
          "username":this.username,
          "id": this.blogId
        })
      }

      this.getBlogList();

      // if(this.reviseFlag) {
      //   this.blog.title = this.$store.state.userBlog[this.Index].title;
      //   this.blog.content = this.$store.state.userBlog[this.Index].content;
      // }
  },
  watch:{
    '$store.state.blogDetail': function() {
              if(this.blogId) {
           this.blog.title =  this.$store.state.blogDetail.title;
           this.blog.content =  this.$store.state.blogDetail.content;
        }
    },
  }
};
</script>
<style scoped>
.blogEditWrapper {
  width: 100%;
  margin: 10px auto;
}
span {
  display: none;
  color: red;
}
.case {
  display: inline;
}

.blogEditWrapper>>>label{
  font-size: 20px;
  font-weight: bold;
}
.markBgc{
  background-color: greenyellow;
}
</style>