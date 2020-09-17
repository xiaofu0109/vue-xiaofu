package com.xiaofu.vuessmbms.webservices.service;

import javax.jws.WebService;

@WebService(name = "DemoService",
        targetNamespace = "http://service.webservices.vuessmbms.xiaofu.com")
public interface DemoService {

    public String sayHi(String name);
}
