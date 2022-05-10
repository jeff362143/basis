<template>
  <div class="messageWrapper">
    
<div class="block">
    <span class="demonstration" style="color:green;"> 根据日期范围选择:</span>
    <el-date-picker
      v-model="scope"
      type="daterange"
      range-separator="至"
      start-placeholder="开始日期"
      end-placeholder="结束日期"
      value-format="yyyy-MM-dd"
      >
    </el-date-picker>
    <el-button type="info" @click.native="GetMessageByScope">查看</el-button>
  </div>

    <div v-for="value in $store.state.adminUserMessage" v-if="$store.state.adminUserMessage"  >
    <el-collapse  v-model="activeName" accordion >
    <el-collapse-item  :name="value.id" :title="'用户: '+value.user+' &&创建时间：'+value.time" class="minHeight">
     <div style="width:1300px">
      <div style="width:700px;font-size:18px">{{value.message}}</div>
      </div>
  </el-collapse-item>
    </el-collapse>
</div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
import {mapState} from 'vuex'
export default {
    data() {
      return {
        activeName:0,
        title:"",
        name:"",
        time:"",
        scope:""
      };
    },
    methods: {
      ...mapActions(["GetMessage"]),
      ...mapState(["adminUserMessage"]),
      count(){},
      load(){},
      GetMessageByScope() {
          this.GetMessage(this.scope);
      }
    },
    created() {
      // this.$store.dispatch("GetMessage");
      
      if(localStorage.getItem("admin")) {
          this.GetMessage();
      }
      
    }
  }
</script>
<style scoped>
.messageWrapper{
  height: 720px;
  overflow: auto;
}
</style>