<template>
  <div class="login_Wrapper">
    <div class="login_form">
    <el-form  label-width="80px">
      <h2 style="text-align:center;padding-bottom:50px;">管理员登录</h2>
      <el-form-item label="管理员"  prop="username">
        <el-input placeholder="请输入账号" v-model="form.username" ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input placeholder="请输入密码" type="password"  v-model="form.password" ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()" >登录</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
// 简化调用action操作
import { mapActions } from "vuex";
export default {
  data() {
    return {
      form: {
        "username": "",
        "password": ""
      },
       computed: {
         ...mapState(["username"])
       },
    };
  },
  methods: {
    ...mapActions(['adminLogin']),
     onSubmit() {
        this.adminLogin(this.form)
     },
  },
  watch: {
    '$store.state.Flag': function() {
      alert("登录成功");
      this.$router.push("/adminHome");
    }
  }
}
</script>

<style scoped>
.login_Wrapper{
    min-height: 760px;
    background-image: url(../../../static/img/login.jpg);
    background-size: cover;
}
.login_form{
    padding: 100px 30px 0 10px;
    width: 350px;
    height: 400px;
    position: relative;
    top: 150px;
    border: 1px solid #DCDFE6;
    margin: 0 auto 0 auto;
    border-radius: 30px;
    background-color:white;
}

.test >>> p{
  font-size: 50px;
  margin: 50px;
  color: red;
}
</style>



