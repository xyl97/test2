package com.huangli.demo.utils;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 解决跨域问题
 */
//@Configuration
//@EnableWebMvc
public class CorsConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//

//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOriginPatterns("*")
////                .allowedOrigins("/**")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .allowedHeaders("*");
//
//    }
}
