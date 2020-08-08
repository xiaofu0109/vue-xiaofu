package com.xiaofu.vuessmbms.controller;

import com.github.pagehelper.PageInfo;
import com.xiaofu.vuessmbms.Common.CommonResult;
import com.xiaofu.vuessmbms.pojo.SmbmsUser;
import com.xiaofu.vuessmbms.service.SmbmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SmbmsUserController",description = "用户信息表接口管理")
@RestController
@RequestMapping("/user")
public class SmbmsUserController {

    @Autowired
    private SmbmsUserService userService;

    @ApiOperation("登录接口管理")
    @PostMapping("/login")
    public CommonResult getLogin(SmbmsUser user){
        List<SmbmsUser> list = userService.getLogin(user);
        if(list != null){
            return new CommonResult(200,"操作成功",null);
        }else{
            return new CommonResult(500,"操作失败",null);
        }
    }


    @ApiOperation("查询所有用户接口 ")
    @PostMapping("/getlist")
    public CommonResult<PageInfo> getList(SmbmsUser user, @Param("pageindex") int pageindex, @Param("pagesize") int pagesize){
        PageInfo<SmbmsUser> pageInfo = userService.getList(user,pageindex,pagesize);
        return new CommonResult<PageInfo>(pageInfo);
    }

    @ApiOperation("添加用户信息接口")
    @PostMapping("/add")
    public CommonResult addUser(SmbmsUser user){
        int result = userService.addUser(user);
        if(result > 0){
            return new CommonResult(200,"添加用户成功",null);
        }
        return new CommonResult(500,"添加用户失败",null);
    }
}
