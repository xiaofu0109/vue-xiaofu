<template>
  <div id="indexs">
    <div id="wheres">
      <el-form :inline="true" :model="users" class="demo-form-inline">
        <el-form-item label="用户名">
          <el-input v-model="users.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item label="用户角色">
          <el-select v-model="users.userrole" placeholder="用户角色">
            <el-option
            v-for="item in options"
            :key="item.id"
            :label="item.rolename"
            :value="item.id"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div id="tables">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column fixed prop="usercode" label="用户编码" width="150">
        </el-table-column>
        <el-table-column prop="username" label="用户名称" width="120">
        </el-table-column>
        <el-table-column prop="gender" :formatter="issex" label="性别" width="120">
        </el-table-column>
        <el-table-column prop="userpassword" label="密码" width="120">
        </el-table-column>
        <el-table-column prop="phone" label="电话" width="300">
        </el-table-column>
        <el-table-column prop="rolename" label="用户角色" width="120">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="text" v-on:click="updateUsers(scope.row)" size="small">修改</el-button>
            <el-button type="text" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div id="pages">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[1, 2, 3, 4, 5]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  export default {
    name: "index",
    data() {
      return {
        tableData:[''],
        pageSize:5,
        currentPage:1,
        total:0,
        users:{
          username:'',
          userrole:''
        },
        options:['']
      }
    },
    mounted(){
      this.getList();
      this.getRoleList();
    },
    methods:{
      getList:function () {
        const that = this;
        this.$axios({
          method:"post",
          url:"http://localhost:8001/user/getlist",
          params:{
            username:that.users.username,
            userrole:that.users.userrole,
            pageindex:that.currentPage,
            pagesize:that.pageSize
          }
        }).then(function (res) {
          console.log(res);
          that.tableData = res.data.data.list;
          that.total = res.data.data.total;
          that.pageSize = res.data.data.pageSize;
          that.currentPage = res.data.data.pageNum;


        }).catch(function (error) {
          alert(error);
        })
      },
      getRoleList:function () {
        const that = this;
        this.$axios({
          method:"post",
          url:"http://localhost:8001/role/getlist"
        }).then(function (res) {
          that.options = res.data.data;
        }).catch(function (error) {
          alert(error);
        })
      },
      handleSizeChange(val) {
        this.currentPage = 1;
        this.pageSize = val;
        this.getList();
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        this.getList();
      },
      onSubmit:function () {
        this.getList();
      },
      issex:function (row) {
        switch (row.gender){
          case 1:
            return "男";
            break;
          case 2:
            return "女";
            break;

        }
      },
      updateUsers:function (row) {
        this.$router.push({path:"/home/updateuser",query:{row:row}});
      }
    }
  }
</script>

<style scoped>
  #pages{
    margin: 20px;
    text-align: right;
  }
</style>
