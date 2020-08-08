<template>
  <div id="uu">
    <div class="blick">
      <el-form :model="ruleForm" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item :hidden="true" label="ID">
          <el-input v-model="ruleForm.id"></el-input>
        </el-form-item>
        <el-form-item label="订单编号">
          <el-input v-model="ruleForm.billcode"></el-input>
        </el-form-item>
        <el-form-item label="商品名称">
          <el-input v-model="ruleForm.productname"></el-input>
        </el-form-item>
        <el-form-item label="商品单位">
          <el-input v-model="ruleForm.productunit"></el-input>
        </el-form-item>
        <el-form-item label="商品数量">
          <el-input v-model="ruleForm.productcount"></el-input>
        </el-form-item>
        <el-form-item label="总金额">
          <el-input v-model="ruleForm.totalprice"></el-input>
        </el-form-item>
        <el-form-item label="供应商">
          <el-select  v-model="ruleForm.providerid" placeholder="请选择供应商">
            <el-option
              v-for="item in options"
              :key="item.id"
              :label="item.proname"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否付款">
          <el-radio-group v-model="ruleForm.ispayment">
            <el-radio :label="1">已付款</el-radio>
            <el-radio :label="2">未付款</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">保存</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "bill-update",
    data() {
      return {
        options: '',
        ruleForm: {
          id: '',
          billcode: '',
          productname: '',
          productunit: '',
          productcount: '',
          totalprice: '',
          proname: '',
          ispayment: '',
        }
      }
    },
    mounted() {
      this.getProList();
      if (this.$route.query.row != undefined) {
        this.ruleForm = this.$route.query.row;
      }
    },
    methods: {
      getProList: function () {
        const that = this;
        this.$axios({
          method: "post",
          url: "http://localhost:8001/provider/getprolist"
        }).then(function (res) {
          that.options = res.data.data;
        }).catch(function (error) {
          alert(error);
        })
      },
      onSubmit: function () {
        const that = this;
        if (that.ruleForm.id != '') {
          console.log("开始修改");
          this.$axios({
            method: "post",
            url: "http://localhost:8001/bill/updatebill",
            params: {
              id: that.ruleForm.id,
              billcode: that.ruleForm.billcode,
              productname: that.ruleForm.productname,
              totalprice: that.ruleForm.totalprice,
              productcount: that.ruleForm.productcount,
              providerid: that.ruleForm.providerid,
              ispayment: that.ruleForm.ispayment,
              productunit: that.ruleForm.productunit
            }
          }).then(function (res) {
            if (res.data.code == '200' && res.data.message == '修改成功') {
              alert("修改成功！！");
              that.$router.push("/home/bill");
            }
          }).catch(function (error) {
            alert(error);
          })
        } else {
          console.log("开始添加");
          this.$axios({
            method: "post",
            url: "http://localhost:8001/bill/addbill",
            params: {
              billcode: that.ruleForm.billcode,
              productname: that.ruleForm.productname,
              totalprice: that.ruleForm.totalprice,
              productcount: that.ruleForm.productcount,
              providerid: that.ruleForm.providerid,
              ispayment: that.ruleForm.ispayment,
              productunit: that.ruleForm.productunit
            }
          }).then(function (res) {
            if (res.data.code == '200' && res.data.message == '添加成功') {
              alert("添加成功！！");
              that.$router.push("/home/bill");
            }
          }).catch(function (error) {
            alert(error);
          })

        }
      }
    }
  }
</script>

<style scoped>
  .blick {
    width: 40%;
  }
</style>
