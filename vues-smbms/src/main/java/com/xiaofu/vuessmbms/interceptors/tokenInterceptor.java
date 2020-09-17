package com.xiaofu.vuessmbms.interceptors;

import jdk.nashorn.internal.runtime.Undefined;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        if(token == null || token == "" || token == "undefined"){
            throw new RuntimeException("无token，请重新登录");
        }
        System.out.println("---------------后台拦截器token:" + token);
        return true;
    }
}
