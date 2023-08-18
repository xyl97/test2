package com.huangli.demo.service.impl;

import com.huangli.demo.dao.LoginDao;
import com.huangli.demo.pojo.dto.LoginUserDto;
import com.huangli.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登录service实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    //用户登录
    @Override
    public LoginUserDto findUserInfoByLoginName(String user_name) {
        return loginDao.selectUserByLoginName(user_name);
    }
}
