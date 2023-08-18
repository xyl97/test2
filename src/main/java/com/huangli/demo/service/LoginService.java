package com.huangli.demo.service;

import com.huangli.demo.pojo.dto.LoginUserDto;

/**
 * 登录service
 */
public interface LoginService {
    //用户登录
    LoginUserDto findUserInfoByLoginName(String user_name);
}
