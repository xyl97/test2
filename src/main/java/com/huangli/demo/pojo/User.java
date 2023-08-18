package com.huangli.demo.pojo;


import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    //用户id
    private int id;

    //登录用户姓名
    private String user_name;

    //登录用户密码
    private String user_password;
}
