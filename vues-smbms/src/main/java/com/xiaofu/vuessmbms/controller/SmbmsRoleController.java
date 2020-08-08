package com.xiaofu.vuessmbms.controller;

import com.xiaofu.vuessmbms.Common.CommonResult;
import com.xiaofu.vuessmbms.pojo.SmbmsRole;
import com.xiaofu.vuessmbms.service.SmbmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SmbmsRoleController",description = "用户角色接口")
@RequestMapping("/role")
@RestController
public class SmbmsRoleController {

    @Autowired
    private SmbmsRoleService roleService;

    @ApiOperation("查询所有数据接口")
    @PostMapping("/getlist")
    public CommonResult<List<SmbmsRole>> getList(){
        List<SmbmsRole> list = roleService.getList();
        return new CommonResult<List<SmbmsRole>>(list);
    }
}
