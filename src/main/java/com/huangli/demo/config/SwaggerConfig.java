package com.huangli.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket creatApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() //选择哪些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.huangli.demo.controller"))//controller路径
                //.apis(RequestHandlerSelectors.any())   //对所有api进行监控
                .paths(PathSelectors.any())  //对所有路径进行监控
                .build();
    }

    //接口文档的一些基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("test接口文档")//文档主标题
                .description("test接口文档")//文档描述
                .contact(new Contact("xxxx","http:localhost:8078/doc.html","xxxx@xxx.com"))
                .version("1.0")//API的版本
                .build();
    }


}
