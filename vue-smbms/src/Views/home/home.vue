<template>

  <div>
    <el-container>
      <el-header>
        <tou class="header"></tou>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <navs></navs>
        </el-aside>
        <el-main>
            <router-view />
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
  import tou from '../common/header'
  import navs from '../common/aside'
  export default {
    name: "home",
    components:{
      'tou': tou,
      'navs' : navs
    }
  }
</script>

<style scoped>
  .header{
    background-color: #409EFF;
    color: #fff;
    line-height: 60px;
    width: 100%;
  }
  .el-header{
    padding: 0px;
  }


</style>
