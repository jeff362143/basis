<template>
  <div class="profile-wrapper">

<!-- 弹出框 -->
<el-dialog
  title="修改用户信息"
  :visible.sync="dialogVisible"
  width="30%"
 >
  <div class="form-wrapper">
      姓名：<el-input v-model="inputName" placeholder="请输入姓名"></el-input>
      <hr>
      专业：<el-input v-model="inputMajor" placeholder="请输入专业"></el-input>
       <hr>
      毕业学校：<el-input v-model="inputSchool" placeholder="请输入毕业学校"></el-input>
       <hr>
      公司：<el-input v-model="inputCompany" placeholder="请输入公司"></el-input>
      <hr>
      职业：<el-input v-model="inputJob" placeholder="请输入职位"></el-input>
  </div>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="deviseUserInfo">确 定</el-button>
  </span>
</el-dialog>

      <div class="profile" style="position:relative">
         <el-button type="success" style="position:absolute;right:35px;top:5px" @click="dialogVisible = true">修改信息</el-button>
          <div>
          <h4>账号信息</h4>
          <p style="margin-left:40px">账号名<span style="margin-left:50px">{{$store.state.userSelfInfo.username}}</span></p>
          <p style="margin-left:55px">姓名<span>{{$store.state.userSelfInfo.name}}</span></p>
          <p style="margin-left:25px">注册时间<span>{{$store.state.userSelfInfo.time}}</span></p>
          </div>
          <hr>  
          <div style="margin-top:40px">
              <h4>学历信息</h4>
              <p style="margin-left:60px">专业<span>{{$store.state.userSelfInfo.major}}</span></p>
              <p>毕业学校<span>{{$store.state.userSelfInfo.graduateSchool}}</span></p>
          </div>
          <hr>
          <div style="margin-top:40px">
              <h4>任职信息</h4>
              <p>任职公司<span>{{$store.state.userSelfInfo.company}}</span></p>
              <p>任职职位<span>{{$store.state.userSelfInfo.job}}</span></p>
          </div>
      </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  data () {
    return {
        username: localStorage.getItem("username") || '',
        dialogVisible: false,
        inputName:this.$store.state.userSelfInfo.name,
        inputSchool:this.$store.state.userSelfInfo.graduateSchool,
        inputJob:this.$store.state.userSelfInfo.job,
        inputCompany:this.$store.state.userSelfInfo.company,
        inputMajor:this.$store.state.userSelfInfo.major
    }
  },
  methods:{
    ...mapActions(['getUserSelfInfo']),
    ...mapActions(['deviseUser']),
      deviseUserInfo() {
         this.deviseUser({
           "username": this.username,
           "name": this.inputName,
           "graduateSchool": this.inputSchool,
           "job": this.inputJob,
           "company": this.inputCompany,
           "major": this.inputMajor
         })        
         this.dialogVisible = false;
         location.reload();
      }
  },
          created () {
            this.getUserSelfInfo(this.username);
      },
      watch:{
        '$store.state.userSelfInfo':function() {
        this.inputName = this.$store.state.userSelfInfo.name,
        this.inputSchool = this.$store.state.userSelfInfo.graduateSchool,
        this.inputJob = this.$store.state.userSelfInfo.job,
        this.inputCompany = this.$store.state.userSelfInfo.company,
        this.inputMajor = this.$store.state.userSelfInfo.major
        }
      }
}
</script>
<style scoped>
.profile p{
    color: gray;
    margin-left:30px;
}
.profile-wrapper span{
    margin-left:50px;
}
.form-wrapper hr{
    height: 1px;
    background-color: rgb(253, 251, 251);
}
</style>