<template>
  <div class="user-center">

      <el-dialog
  title="提示"
  :visible.sync="dialogVisible"
  width="40%"
>
 <h4>个性签名将在您的用户主页和个人中心展示</h4>
  <el-input
  type="textarea"
  :rows="2"
  placeholder="请输入您的个性签名，15字内哦"
  v-model="textarea">
</el-input>
 
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="reviseMyWords">确 定</el-button>
  </span>
</el-dialog>

<!-- 留言板 -->

      <el-dialog
  title="提示"
  :visible.sync="dialogVisible2"
  width="60%"
>
 <h4>您有什么需要帮助的，可以提交给我们！</h4>
  <el-input
  type="textarea"
  :rows="6"
  placeholder="我们会尽快处理您的留言。"
  v-model="message.message">
</el-input>
 
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible2 = false">取 消</el-button>
    <el-button type="primary" @click="saveMessage">提 交</el-button>
  </span>
</el-dialog>

      <headerNav></headerNav>
      <div class="user">
        <el-avatar :size="70" style="margin:50px 0 0 250px">
            <img src="../../static/img/user.gif"/>
        </el-avatar>
        <span style="color:white;position:relative;top:-50px;left:30px">{{username}}</span>
        <span style="color:white;font-size:25px;position:relative;left:400px;top:-30px">{{$store.state.userSelfInfo.selfDesc}}</span>
      </div>
      <div class="user-actions">
          <div class="left-menu"  >
              <!-- <p>个人资料</p>
              <p>主页签名</p>
              <p>我的博客</p>
              <p>我的收藏</p>
              <p>我的评论</p>
              <p>我的关注</p>
              <p>关注我的</p>
              <p>我点赞的</p> 
              <p>给官方留言</p> -->
              <p  v-for="value,index in menu" v-bind:class="{bgc: index==isactive}" @click="selectFunc(index,value)">{{value}}</p>
          </div>
          <div class="main-action-wrapper">
              <div class="main-action">
              <router-view></router-view>
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
        username: localStorage.getItem("username") || '',
        menu:["个人资料","我的博客","我的收藏","我的评论","我的关注","关注我的","我的点赞","主页签名","给官方留言"],
        isactive:  this.$route.query.Flag || 0,
        dialogVisible: false,
        dialogVisible2: false,
        textarea: "",
         message:{
        user:"游客",
        message:"",
        time:"",
      },

    }
  },
 components:{
      headerNav
  },
  methods:{
      ...mapActions(['getUserSelfInfo']),
      ...mapActions(['SaveUserMessage']),
      ...mapActions(['reviseUserSelfDesc']),
     saveMessage() {
       this.dialogVisible2 = false;
      if(this.username) {
        this.message.user = this.username;
      }
      var time = new Date();
      this.message.time = time.toLocaleDateString();
        if(this.message.message){
          this.SaveUserMessage(this.message);
          alert("提交成功，我们会尽快处理您的留言。")
      }else{
        alert("内容不能为空 QWQ")
      }
    },
      selectFunc(index,value) {
          if(index != 8 && index != 9){
          this.isactive = index;
          }
          if(index == 0) {
              this.$router.push('/profile')
          }
          if(index == 1) {
              this.$router.push('/myBlog');
          }
          if(index == 2) {
              this.$router.push('/myColl') 
          }
          if(index == 3) {
              this.$router.push('/myComment')   
          }
          if(index == 4) {
             this.$router.push('/myFollow')     
          }
          if(index == 5) {
              this.$router.push('/followme')
          }
          if(index == 6) {
              this.$router.push('/myLike')
          }
          if(index == 7) {
               this.dialogVisible = true;
          }
          if(index == 8) {
            //   this.$router.push('/messageBoard')
            this.dialogVisible2 = true;
          }
      },
      reviseMyWords() {
        this.dialogVisible = false;
        this.reviseUserSelfDesc({
          "action": "reviseUserSelfDesc",
          "username": this.username, 
          "selfDesc": this.textarea
        });
        location.reload();
      }
  },
        created() {
          this.getUserSelfInfo(this.username);
      },
}
</script>
<style scoped>
.user-center{
    background-color: rgb(235, 235, 235);
    min-height: 770px;
}
.user{
    width: 100%;
    height: 160px;
    background-image: url(../../static/img/userCenter.png);
    background-size: contain;
}
.user-actions{
    display: flex;
    width: 1124px;
    margin: 0 auto;
}
.left-menu{
    width: 170px;
    min-height: 500px;
    background-color: rgb(248, 244, 244);
}
.left-menu p{
    text-align: center;
    font-size: 15px;
    color: rgb(104, 98, 98);
    margin:30px 0;
}
.main-action-wrapper{
    margin-left: 15px;
    width: 890px;
    min-height: 500px;
    background-color: #fff;
}
.main-action{
    width: 94%; 
    margin:0 auto;
    margin-top: 20px;
}
p.bgc{
    color: red;
    font-weight: 800;
}
</style>