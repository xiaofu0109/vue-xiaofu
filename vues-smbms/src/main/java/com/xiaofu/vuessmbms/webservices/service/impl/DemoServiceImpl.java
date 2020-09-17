package com.xiaofu.vuessmbms.webservices.service.impl;

import com.xiaofu.vuessmbms.webservices.service.DemoService;

import javax.jws.WebService;
import java.util.Date;

@WebService(
        serviceName = "DemoService",
        targetNamespace = "http://service.webservices.vuessmbms.xiaofu.com",
        endpointInterface = "com.xiaofu.vuessmbms.webservices.service.DemoService"
)
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHi(String name) {
        return name + "，现在时间：" + new Date();
    }
}
