package com.xiaofu.vuessmbms.controller;

import com.github.pagehelper.PageInfo;
import com.xiaofu.vuessmbms.Common.CommonResult;
import com.xiaofu.vuessmbms.pojo.SmbmsBill;
import com.xiaofu.vuessmbms.service.SmbmsBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SmbmsBillController",description = "222222订单接口管理 ")
@RestController
@RequestMapping("bill")
public class SmbmsBillController {
    @Autowired
    private SmbmsBillService billService;

    @ApiOperation("查询多有订单信息ssssss")
    @PostMapping("/getList")
    public CommonResult<List<SmbmsBill>> getList(){
        List<SmbmsBill> list = billService.getList();
        return new CommonResult<List<SmbmsBill>>(list);
    }

    @ApiOperation("动态查询订单信息")
    @PostMapping("/getbillList")
    public CommonResult<PageInfo> getBillList( SmbmsBill bill, @Param("pageindex") int pageindex, @Param("pagesize") int pagesize){
        PageInfo<SmbmsBill> pageInfo = billService.getListBill(bill,pageindex,pagesize);
        return new CommonResult<PageInfo>(pageInfo);
    }

    @ApiOperation("添加订单111111111111")
    @PostMapping("/addbill")
    public CommonResult addBill(SmbmsBill bill){
        int result = billService.addBill(bill);
        if(result > 0){
            return new CommonResult(200,"添加成功",null);
        }
        return new CommonResult(500,"添加失败",null);
    }

    @ApiOperation("wwwwwwwwwwwwwwwwwww修改订单123456789")
    @PostMapping("/updatebill")
    public CommonResult updateBill(SmbmsBill bill){
        int result = billService.updateBill(bill);
        if(result > 0){
            return new CommonResult(200,"修改成功",null);
        }
        return new CommonResult(500,"修改失败",null);
    }




}
