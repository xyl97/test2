package com.huangli.demo.mvc;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LogInterceptor myHandlerInterceptor() {
        return new LogInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myHandlerInterceptor())
                //选择全部接口
                .addPathPatterns("/**")
                //登录接口除外
                .excludePathPatterns("/login");
    }


    /**
     * 解决跨域问题
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
      //  corsConfiguration.addAllowedOrigin("*"); // 1 设置访问源地址（* 可以设置为只允许http://localhost:8080 访问)
        corsConfiguration.addAllowedOriginPattern("*"); // 1 设置访问源地址（* 可以设置为只允许http://localhost:8080 访问)
        corsConfiguration.addAllowedHeader("*"); // 2 设置访问源请求头
        corsConfiguration.addAllowedMethod("*"); // 3 设置访问源请求方法
      //  corsConfiguration.addExposedHeader("*");
        source.registerCorsConfiguration("/**", corsConfiguration); // 4 对接口配置跨域设置

        return new CorsFilter(source);

    }
    }
