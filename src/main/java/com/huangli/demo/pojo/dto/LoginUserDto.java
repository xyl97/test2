package com.huangli.demo.pojo.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录实体类
 */
@ApiModel
@Data
public class LoginUserDto {

    //登录用户id
    @ApiModelProperty( value= "用户id(swagger测试时不需要传)",required=false)
    private int id;

    //登录用户姓名
    @ApiModelProperty(value = "用户名",required=true)
    private String username;

    //登录用户密码
    @ApiModelProperty(value = "密码",required=true)
    private String password;
}
