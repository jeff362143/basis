<template>
  <div class="login_Wrapper">
    <div class="login_form">
      <h2 style="margin:100px auto 80px auto;width:120px">登录界面</h2>
    <el-form ref="form" :rules="rules"  :model="form" label-width="80px" style="margin-left:20px" >
      <el-form-item label="用户名"  prop="username">
        <el-input placeholder="请输入账号" v-model="form.username" style="width:240px" ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input placeholder="请输入密码" type="password"  v-model="form.password" style="width:240px" ></el-input>
      </el-form-item>
      <el-form-item style="margin:50px 0">
        <el-button type="primary" @click="onSubmit('form')" style="margin-right:20px" >登录</el-button>
        <router-link to="register">
        <el-button  @click="">注册</el-button>
        </router-link>
      </el-form-item>
    </el-form>
    </div>

    <p>{{$route.query.sort}}</p>
  </div>
</template>

<script>
import { mapState } from "vuex";
// 简化调用action操作
import { mapActions } from "vuex";
export default {
  data() {
    return {
      sort:this.$route.query.sort,
      index:this.$route.query.Index,

      form: {
        username: "",
        password: "",
      },
       rules: {
          username: [
            { required: true, message: '请输入账号', trigger: 'blur' },
            { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 5, max: 10, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ]
       },
       computed: {
         ...mapState(["username"])
       },
    };
  },
  methods: {
     onSubmit(formName) {
//  var date = new Date();
	
// 	var year = date.getFullYear();
// 	var month = date.getMonth()+1;
// 	var day = date.getDate();
// 	var hour = date.getHours();
// 	var minute = date.getMinutes();
// 	var second = date.getSeconds();
	
// 	//alert(year+'年'+month+'月'+day+'日 '+hour+':'+minute+':'+second)
// 	 var presentTime=year+'-'+month+'-'+day+'-'+hour+"-"+minute+'-'+second;
// 	//alert( year+'-'+month+'-'+day+''+hour+':'+minute+':'+second);

// alert(presentTime)


        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.Login(this.form);
          } else {
            return false;
          }
        });
     },
      ...mapActions(["Login"])
  },
  watch:{
    '$store.state.loginFlag': function() {
       this.$router.push('/')
       this.$store.state.loginFlag = 0;
    }
  }
}
</script>

<style scoped>
.login_Wrapper{
    background-image: url(../../static/img/login.jpg);
  background-size: cover;
  width: 100%;
  height: 750px;
  border: 1px white solid;
}
.login_form{
    width: 410px;
    height: 560px;
    border: 1px solid #DCDFE6;
    margin: 100px auto 0 auto;
    border-radius: 50px;
    background-color:rgb(252, 252, 252);
}

.test >>> p{
  font-size: 50px;
  margin: 50px;
  color: red;
}
</style>



