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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xiaofu.vuessmbms.utils.tokenUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "SmbmsUserController",description = "用户信息表接口管理")
@RestController
@RequestMapping("/user")
public class SmbmsUserController {

    @Autowired
    private SmbmsUserService userService;

    @ApiOperation("登录接口管理")
    @PostMapping("/login")
    public CommonResult getLogin( SmbmsUser user){
        System.out.println("用戶名:" + user.getUsercode());
        List<SmbmsUser> list = userService.getLogin(user);
        if(list != null){
            String token = tokenUtils.createToken(list.get(0));

            System.out.println("token:---" + token);
            return new CommonResult(200,"操作成功",token);
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


    @ApiOperation("修改用户信息接口")
    @PostMapping("/update")
    public CommonResult updateUser(SmbmsUser user){
        System.out.println("出生日期：" + user.getBirthday());
        int result = userService.updateUser(user);
        if(result > 0){
            return new CommonResult(200,"修改成功",null);
        }
        return new CommonResult(500,"修改失败",null);

    }
}
