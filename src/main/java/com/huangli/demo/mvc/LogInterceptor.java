package com.huangli.demo.mvc;

import com.alibaba.fastjson.JSON;
import com.huangli.demo.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 拦截器
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

//    public void crossDomain(HttpServletRequest request, HttpServletResponse response) {
//
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//
//        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//            System.out.println("跨域访问");
//            return true;
//        }
        ;

         User userinfo = (User) request.getSession().getAttribute("userinfo");

         if (userinfo!=null){

             return true;
         }
         response.setCharacterEncoding("utf8");
        response.setContentType("application/json;charset=UTF-8");
        HashMap<String, Object> ma = new HashMap<>();
        ma.put("code",response.SC_UNAUTHORIZED);
        ma.put("msg","请重新登录");
        PrintWriter writer = response.getWriter();
        writer.println(JSON.toJSONString(ma));//转换成JSON格式返回

        return false;


    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
