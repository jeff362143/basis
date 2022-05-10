<template>
<div class="register-wrapper">
  <div class="formWrapper">
    <h2 style="text-align: center; margin-bottom: 80px">注册界面</h2>
    <el-form
      :model="ruleForm"
      status-icon
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="用户名" prop="username">
        <el-input
          placeholder="账号名为3-8个字符"
          v-model="ruleForm.username"
          autocomplete="off"
          style="width: 260px"
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input
        placeholder="密码为5-10个字符"
          type="password"
          v-model="ruleForm.password"
          autocomplete="off"
          style="width: 260px"
        ></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input
         placeholder="密码为5-10个字符"
          type="password"
          v-model="ruleForm.checkPass"
          autocomplete="off"
          style="width: 260px"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')"
          >提交</el-button
        >
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
</template>
<script>
import { mapActions } from 'vuex';
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        username: "",
        password: "",
        checkPass: "",
      },
      rules: {
        username: [
          { required: true, message: "账号在为3到8个字符", trigger: "blur" },
          {
            min: 3,
            max: 12,
            message: "长度在 3 到 8 个字符",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, validator: validatePass, trigger: "blur" },
          {
            min: 5,
            max: 10,
            message: "长度在 5 到 10 个字符",
            trigger: "blur",
          },
        ],
        checkPass: [
          { required: true, validator: validatePass2, trigger: "blur" },
          {
            min: 5,
            max: 10,
            message: "长度在 5 到 10 个字符",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
      ...mapActions(['userRegister']),
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          var time = new Date();
          time = time.toLocaleDateString();
          this.userRegister({
              "username": this.ruleForm.username,
              "password": this.ruleForm.password,
              "time": time
          })
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
  watch:{
      '$store.state.Flag':function() {
          alert("注册成功,跳转到登录界面");
          this.$router.push('login');
      }
  }
};
</script>

<style scoped>
.formWrapper {
  width: 410px;
  height: 500px;
  padding-top: 50px;
  border: 1px solid rgb(182, 177, 177);
  background-color: #fff;
  border-radius: 50px;
  margin:0 auto;
  margin-top: 100px;
}
.register-wrapper{
  background-image: url(../../static/img/register.jpg);
  background-size: cover;
  width: 100%;
  height: 750px;
  border: 1px white solid;
}
</style>