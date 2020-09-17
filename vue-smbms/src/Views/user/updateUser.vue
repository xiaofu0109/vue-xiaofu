<template>
  <div id="update">
    <div id="formsss">
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rulesform"
        ref="users"
        label-width="100px"
        class="demo-ruleForm">
        <el-form-item hidden="true" label="用户ID" prop="id">
          <el-input v-model="ruleForm.id"></el-input>
        </el-form-item>
        <el-form-item label="用户名称" prop="username">
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="用户性别" prop="gender">
          <el-select v-model="ruleForm.gender" placeholder="请选择性别">
            <el-option v-for="item in genders"
                       :key="item.id"
                       :value="item.id"
                       :label="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker
            v-model="ruleForm.birthday"
            align="right"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用户电话" prop="phone">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="用户住址" prop="address">
          <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item label="用户角色" prop="userrole">
          <el-select v-model="ruleForm.userrole" placeholder="请选择用户角色">
            <el-option v-for="item in userroles"
                       :key="item.id"
                       :label="item.rolename"
                       :value="item.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('users')">提交</el-button>
        </el-form-item>
      </el-form>

    </div>
  </div>
</template>

<script>
  export default {
    name: "update-user",
    data() {
       var usernameValidator =(rule,value,callback) =>{
         if(value == ''){
           callback('请输入用户名称');
         }
         callback();
       };
       var phoneValidator = (rule,value,callback) =>{
         if(value == ''){
           return callback(new Error("请输入电话！"));
         }
         let isMobile = /^1[34578]\d{9}$/.test(value);
         if(isMobile){
           callback();
         }else{
           callback(new Error("请输入正确电话！"));
         }
       };
       var addressValidator = function (rule,value,callback) {
         if(!value){
           callback(new Error("请输入用户住址"));
         }
         callback();
       }

       return{
         rulesform:{
          username:[
            {validator:usernameValidator, trigger: "blur"}
          ],
           phone:[
             {validator:phoneValidator,trigger:"blur"}
           ],
           address:[
             {validator:addressValidator,trigger:"blur"}
           ]
        },
         ruleForm:{
           username:'',
           id:'',
           gender:'',
           phone:'',
           address:'',
           birthday:'',
           userrole:''
         },
         genders:[
           {id:1,value:'男'},
           {id:2,value:'女'}
         ],
         userroles:['']
      }
    },
    mounted(){
      this.getRoles();
      console.log(this.$route.query.row);
      this.ruleForm = this.$route.query.row;
    },
    methods:{
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
      submitForm:function (users) {
        this.$refs[users].validate((isResult) =>{
          if(isResult){
            const that = this;
            this.$axios({
              method:"post",
              url:"http://localhost:8001/user/update",
              params:{
                username:that.ruleForm.username,
                gender:that.ruleForm.gender,
                birthday:that.ruleForm.birthday,
                id:that.ruleForm.id,
                address:that.ruleForm.address,
                phone:that.ruleForm.phone,
                userrole:that.ruleForm.userrole
              }
            }).then(function (res) {
              if(res.data.code == '200'){
                alert("修改成功！！！");
                that.$router.push("/home/users")
              }else{
                alert("修改失败！！！");
              }
            }).catch(function (error) {
              alert(error);
            })
          }else{
            alert("请认真填写信息后进行提交！！！");
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
