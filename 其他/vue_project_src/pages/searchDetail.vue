<template>
  <div class="searchDetail" >
    <headerNav />
    

    <div style="display:flex">
    <div>
    <div class="search-wrapper">
       <div class="icon-wrapper"> <i class="el-icon-search" @click="Search"></i></div>
      <div class="search-input">
      <input type="text" class="input" v-model="input" style="display:block;font-size:20px">
      </div>
    </div>
  <el-timeline class="list">
        <el-card style="min-height:600px;margin-top:10px" v-if="$store.state.searchBlogs">
            <h2>搜索结果如下：共有<span style="color:red">{{searchResult.length}}</span>条数据</h2>
          <div v-for="value,index in $store.state.searchBlogs" style="border-bottom:1px solid  rgb(207, 200, 200)">
          <p @click="toDetail(index)" class="searchTitle"><router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}">{{index+1}}、{{value.title}}</router-link></p>
      </div>
        </el-card>
      </el-timeline>
  </div>

    <!-- 今日推荐 -->
    <div class="todayReco">
       <h3 style="margin-top:10px;margin-left:20px">今日推荐</h3>
       
       <div style="display:flex;margin-bottom:10px" v-for="value in $store.state.todayReco">
           <img src="../../static/img/todayReco.png" style="width:50px;margin-left:20px">
           <p style="margin:0;width:180px;height:35px;font-size:15px;margin-left:9px;font-weight:bold;color:rgb(90, 84, 84)"><router-link :to="{path:'/blogContentDetail',query:{blogId:value.id,blogAuthor:value.author}}">{{value.title}}</router-link></p>
       </div>
    </div>

  </div>

  </div>
</template>

<script>
import { mapActions } from 'vuex';
import headerNav from "../components/headerNav";
export default {
  data () {
    return {
        searchResult:[],
        input: this.$route.query.value
    }
  },
  created() {
    if(this.input == "") {
      this.input = "react17源码"
    }
  },
  components:{
      headerNav
  },
  watch:{
      '$store.state.searchBlogs': function() {
          this.searchResult = this.$store.state.searchBlogs;
      }
  },
  methods:{
     ...mapActions(['search']),
      toDetail(index) {
           var MardownIt = require("markdown-it");
           var md = new MardownIt();
           this.searchResult[index].content = md.render(this.searchResult[index].content);
           this.$store.state.blogDetail = this.searchResult[index];
           this.$router.push('/blogContentDetail');
      },
      Search() {
        this.search(this.input)
      }
  }
}
</script>
<style scoped>
.searchDetail{
  background-image: url(../../static/img/bgc.jpeg);

}
.searchDetail >>> input {
  display: none;
}
.searchDetail >>> .icon
{
  display: none;
}
.searchDetail >>> .self-center{
    padding-right: 200px;
}
.icon-wrapper{
    position: absolute;
  z-index: 10;
  left: 780px;
  top:12px;
  background-color: rgb(207, 200, 200);
  width: 44px;
  height: 44px;
  font-size: 30px;
}
.el-icon-search{
  margin-left: 5px;
}
.input{
  background-color:#f0f0f5;
  width: 100%;
  height: 40px;
  border: 1px solid rgb(241,240,240);
  outline: none;
}
.search-wrapper{
  position: relative;
width: 840px;
height: 70px;
background-color: #fff;
margin-left:200px;
margin-top:10px;
}
.search-input{
  width: 95%;
  background-color: rgb(241, 240, 240);
  border:1px solid whitesmoke;
  margin:0 auto;
  position: relative;
top:10px
}
.white-hidden{
  position: absolute;
  z-index: 100;
  left:870px;
  top:20px;
  width: 190px;
  height: 30px;
  background-color: rgb(253, 250, 250);
}
.list{
    width: 840px;
    margin-left: 160px;
}
.searchTitle a:hover{
    color: red;
}
a{
    color: rgb(102, 93, 93);
    text-decoration: none;
    font-size: 18px;

}

.todayReco{
  margin-left: 10px;
  width: 290px;
  border:1px solid rgb(216, 214, 214);
  background-color: #fff;
  margin-top:15px;
}
.todayReco a{
  font-size: 15px;
}
a:hover{
  color: red;
}
</style>