<template>
  <div>
    <!--flex弹性盒子模型，justify-content：主抽 -->
    <div style="display: flex;justify-content: center;margin-top: 150px">
      <el-card style="width: 400px">
        <div slot="header" class="clearfix">
          <span>登录</span>
        </div>
        <table>
          <tr>
            <td>用户名</td>
            <td>
              <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
            </td>
          </tr>
          <tr>
            <td>密码</td>
            <td>
              <el-input type="password" v-model="user.password" placeholder="请输入密码"
                        @keydown.enter.native="doLogin"></el-input>
              <!-- @keydown.enter.native="doLogin"当按下enter键的时候也会执行doLogin方法-->
            </td>
          </tr>
          <tr>
            <!-- 占两行-->
            <td colspan="2">
              <!-- 点击事件的两种不同的写法v-on:click和 @click-->
              <!--<el-button style="width: 300px" type="primary" v-on:click="doLogin">登录</el-button>-->
              <el-button style="width: 300px" type="primary" @click="doLogin">登录</el-button>
            </td>
          </tr>
        </table>
      </el-card>
    </div>
  </div>
</template>

<script>
  export default {
    name: "login",
    data() {
      return {
        user: {
          username: '',
          password: ''
        }
      }
    },
    methods: {
      doLogin: function () {
        const that = this;
        let result = this.$axios.post("/user/login",
          {usercode: that.user.username,
            userpassword: that.user.password});

        result.then((value) =>{
          console.log("这是个什么东西 ！！！！");
          console.log(value);
          if(value.code == "200"){
            alert(value.data);
            that.$store.commit("changeLogin", {Authorization:value.data});
            that.$router.push("/home")
          }
        },(error) =>{
          alert(error);
        })
      }
    }
  }
</script>

<style scoped>
</style>
