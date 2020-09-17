package com.xiaofu.vuessmbms.config;

import com.xiaofu.vuessmbms.webservices.service.DemoService;
import com.xiaofu.vuessmbms.webservices.service.impl.DemoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {
    @Bean
    public ServletRegistrationBean registrationBean(){
        return new ServletRegistrationBean(new CXFServlet(),"/demo/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    @Bean
    public DemoService demoService(){
        return new DemoServiceImpl();
    }

    @Bean
    public Endpoint endpoints(){
        EndpointImpl endpoint = new EndpointImpl(springBus(),demoService());
        endpoint.publish("/api");
        return endpoint;
    }
}
