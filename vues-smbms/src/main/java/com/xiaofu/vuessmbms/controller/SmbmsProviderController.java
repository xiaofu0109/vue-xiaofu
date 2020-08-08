package com.xiaofu.vuessmbms.controller;

import com.xiaofu.vuessmbms.Common.CommonResult;
import com.xiaofu.vuessmbms.pojo.SmbmsProvider;
import com.xiaofu.vuessmbms.service.SmbmsProviderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "SmbmsProviderController",description = "供应商接口管理s")
@RestController
@RequestMapping("provider")
public class SmbmsProviderController {

    @Autowired
    private SmbmsProviderService providerService;

    @RequestMapping(value = "getprolist",method = RequestMethod.POST)
    public CommonResult<List<SmbmsProvider>> getProList(){
        List<SmbmsProvider> list = providerService.getList();
        return new CommonResult<List<SmbmsProvider>>(list);
    }

}
