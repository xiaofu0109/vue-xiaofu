package com.xiaofu.vuessmbms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.xiaofu.vuessmbms.interceptors.tokenInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public tokenInterceptor get(){
        return new tokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(get())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }
}
