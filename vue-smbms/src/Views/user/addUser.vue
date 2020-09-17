<template>
  <div id="addUser">
    <div id="forms">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="aa" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户编码" prop="usercode">
          <el-input v-model="ruleForm.usercode"></el-input>
        </el-form-item>
        <el-form-item label="用户名称" prop="username">
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="userpassword">
          <el-input type="password" v-model="ruleForm.userpassword" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="password">
          <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户性别">
          <el-select v-model="ruleForm.gender" placeholder="请选择">
            <el-option
              v-for="item in sex"
              :key="item.id"
              :label="item.value"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="出生日期">
          <el-date-picker
            v-model="ruleForm.birthday"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用户电话">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>

        <el-form-item label="用户地址">
          <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item label="用户角色">
          <el-select v-model="ruleForm.userrole" placeholder="请选择">
            <el-option
              v-for="item in userroles"
              :key="item.id"
              :label="item.rolename"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('aa')">提交</el-button>
          <el-button @click="resetForm('aa')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "add-user",
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.password !== '') {
            this.$refs.aa.validateField('password');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.userpassword) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      var usercodevalidate = (rule,value,callback)=>{
        if(value === ''){
          callback(new Error('请输入用户编码'))
        }
        callback();
      };
      var usernamevalidate =(rule,value,callback) =>{
        if(value == ''){
          callback(new Error('请输入用户名称'));
        }
        callback();
      }
      return {
        ruleForm: {
          usercode: '',
          username: '',
          userpassword: '',
          password: '',
          gender: '',
          birthday: '',
          phone: '',
          address: '',
          userrole: '',

        },
        sex:[
          {id:1,value:'男'},
          {id:2,value:'女'}
        ],
        userroles:[''],
        rules: {
          userpassword: [
            {validator: validatePass, trigger: 'blur'}
          ],
          password: [
            {validator: validatePass2, trigger: 'blur'}
          ],
          usercode:[
            {validator:usercodevalidate,trigger:'blur'}
          ],
          username:[
            {validator:usernamevalidate,trigger:'blur'}
          ]
        }
      };
    },
    mounted(){
      this.getRoles();
    },
    methods: {
      getRoles:function () {
        const that = this;
        this.$axios({
          method:"post",
          url:"http://localhost:8001/role/getlist"
        }).then(function (res) {
          that.userroles = res.data.data;
        }).catch(function (error) {
          alert(error);
        })
      },
      submitForm:function (forms) {
        this.$refs[forms].validate((valid) => {
          if(valid){
            const that = this;
            alert(this.ruleForm.birthday);
            this.$axios({
              method:"post",
              url:"http://localhost:8001/user/add",
              params:{
                usercode:that.ruleForm.usercode,
                username:that.ruleForm.username,
                userpassword:this.ruleForm.userpassword,
                birthday:this.ruleForm.birthday,
                gender:this.ruleForm.gender,
                address:this.ruleForm.address,
                phone:this.ruleForm.phone,
                userrole:this.ruleForm.userrole
              }
            }).then(function (res) {
              if(res.data.code == '200'){
                alert(res.data.message);
                that.$router.push("/home/users");
              }else{
                alert("添加失败！！！！");
              }
            }).catch(function (error) {
              alert(error);
            })
          }else{
            alert('error');
          }
        })
      },
      resetForm:function (aa) {
        this.$refs[aa].resetFields();
      }
    }
  }
</script>

<style scoped>

</style>
