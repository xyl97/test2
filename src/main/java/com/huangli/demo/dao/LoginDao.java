package com.huangli.demo.dao;

import com.huangli.demo.pojo.dto.LoginUserDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户登录mapper接口
 */
@Mapper
public interface LoginDao {
    //用户登录
    LoginUserDto selectUserByLoginName(String user_name);
}
