<template>
  <div id="top">
    <div id="form">
      <el-form :inline="true" :model="billa" class="demo-form-inline">
        <el-form-item label="商品名称">
          <el-input v-model="billa.productname" placeholder="商品名称"></el-input>
        </el-form-item>
        <el-form-item label="供应商">
          <el-select v-model="billa.providerid" placeholder="供应商">
            <el-option
              v-for="item in options"
              :key="item.id"
              :label="item.proname"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否付款">
          <el-select v-model="billa.ispayment" placeholder="是否付款">
            <el-option
              v-for="item in payments"
              :key="item.id"
              :label="item.value"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getList">查询</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div id="table">
      <el-table :data="bills" border>
        <el-table-column fixed prop="billcode" label="订单编号" width="150"></el-table-column>
        <el-table-column prop="productname" label="商品名称" width="150">
        </el-table-column>
        <el-table-column prop="proname" label="供应商" width="300">
        </el-table-column>
        <el-table-column prop="totalprice" label="订单金额" width="120">
        </el-table-column>
        <el-table-column prop="ispayment" :formatter="isPayFormatter" label="是否付款" width="100">
        </el-table-column>
        <el-table-column prop="creationdate" :formatter="isDateFormatter" label="创建时间" width="250">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="text" @click="selBill(scope.row)" size="small">查看</el-button>
            <el-button type="text" @click="updatebill(scope.row)" size="small">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="block">
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
    name: "bill",
    data() {
      return {
        bills: [''],
        billa: {
          productname: '',
          providerid: '',
          ispayment: ''
        },
        options: [''],
        payments: [
          {id: 1, value: "已付款"},
          {id: 2, value: "未付款"}
        ],
        currentPage: 1,
        pageSize: 5,
        total: 0
      }
    },
    mounted() {
      this.getList();
      this.getProList();
    },
    methods: {
      getList: function () {
        const that = this;
        let result =
          this.$axios.post("/bill/getbillList",{
            productname: this.billa.productname,
            providerid: this.billa.providerid,
            ispayment: this.billa.ispayment,
            pageindex: this.currentPage,
            pagesize: this.pageSize
          });
        result.then((res) => {
          that.bills = res.data.list;
          that.total = res.data.total;
          that.pageSize = res.data.pageSize;
          that.currentPage = res.data.pageNum;
        },(error)=>{
          alert(error);
        })
      },
      isDateFormatter: function (row) {
        return this.moment(new Date(row.creationdate)).format("YYYY-MM-DD HH:mm:ss");
      },
      isPayFormatter: function (row) {
        switch (row.ispayment) {
          case 1:
            return "已付款";
            break;
          case 2:
            return "未付款";
            break;
        }
      },
      getProList: function () {
        const that = this;

        let result = this.$axios.post("/provider/getprolist");
        result.then((res) => {
          that.options = res.data;
        },(error)=>{
          alert(error);
        })
      },
      selBill: function (row) {
        alert(row.ispayment);
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.pageSize = val;
        this.currentPage = 1;
        this.getList();
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.currentPage = val;
        this.getList();
      },
      updatebill: function (row) {
        console.log(row)
        this.$router.push({path: '/home/update', query: {row: row}});
      }
    }
  }
</script>

<style>
  .block {
    margin: 10px;
    text-align: right;

  }
</style>
