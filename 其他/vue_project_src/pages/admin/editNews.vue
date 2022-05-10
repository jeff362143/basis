<template>
  <!-- <div class="blogEditWrapper">
    <h1 style="text-align: center; margin-bottom: 10px">编辑博客</h1>
    <el-form label-width="80px">
      <el-form-item label="标题">
        <el-input
          v-model="blog.title"
          placeholder="标题为3-15个字符"
        ></el-input>
      </el-form-item>
    </el-form>
    <div class="edit">
      <p>
        博客内容:<span v-bind:class="{ case: 1 == flag }"
          >博客标题和博客内容不可为空！！！</span>
      </p>
      <mavon-editor v-model="blog.content" style="height:520px"></mavon-editor>
    </div>
    <el-button type="success" style="margin-left: 40px" @click="saveBlog"
      >提交</el-button
    >
  </div> -->
<div class="blogEditWrapper">
  <el-form label-width="140px" >
      <el-form-item label="编辑页面">
        <el-input
          v-model="blog.title"
          placeholder="标题为25个字符以下"
           style="width:90%"
        ></el-input>
          <el-button type="danger" style="height:80%" @click="saveBlog">发布文章</el-button>
      </el-form-item>
    </el-form>

    <router-link to="/manageNews">
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
      // new: this.$route.query.new,
      blog: {
        id:0,
        title: "",
        content: "",
        createTime:""
      },

      newsId: this.$route.query.newsId,
      // flag: 0,
    };
  },
  mounted() {}, // mounted函数
  methods: {
    ...mapActions(['saveNews']),
    ...mapActions(['getBlogByIdForEdit']),
    // saveBlog: function () {
    //   if (!this.blog.title || !this.blog.content) {
    //     this.flag = 1;
    //   } else {
    //     var timer = new Date();
    //     this.blog.createTime = timer.toLocaleDateString();
    //     this.blog.id = this.new.id;
    //     // this.blog.author = this.$store.state.userInfo.username;
    //     this.saveNews(this.blog);
    //     this.$alert("提交成功，将返回新闻页面", {
    //       confirmButtonText: "确定",
    //       callback: (action) => {
    //         this.$router.push("/manageNews");
    //       },
    //     });
    //   }
    // },
    saveBlog() { 
          if (!this.blog.title || !this.blog.content) {
              alert("内容或标题不能为空");
          } else {
               var timer = new Date();
               this.blog.createTime = timer.toLocaleDateString();
               this.blog.id = this.newsId;
               this.saveNews(this.blog);
               this.$alert("提交成功，将返回新闻页面", {
               confirmButtonText: "确定",
               callback: (action) => {
               this.$router.push("/manageNews");
          },
        });
        }
    }
  },

  // 修改博客的测试
  created() {
      // if(this.reviseFlag) {
      //   this.blog.title = this.$store.state.userBlog[this.Index].title;
      //   this.blog.content = this.$store.state.userBlog[this.Index].content;
      // }
       
      this.getBlogByIdForEdit({
        "action": "getBlogDetailsById",
          "username":"",
          "id": this.newsId
      });


  },
  watch: {
        '$store.state.blogDetail': function() {
        this.blog.title = this.$store.state.blogDetail.title;
        this.blog.content = this.$store.state.blogDetail.content;
      }
  }
};
</script>
<style scoped>
/* .blogEditWrapper {
  width: 1000px;
  margin: 10px auto;
}
.edit {
  margin-left: 40px;
}
/*  */
/* 
span {
  display: none;
  color: red;
  margin-left: 50px;
}
.case {
  display: inline;
}  */


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