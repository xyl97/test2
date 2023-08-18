package com.huangli.demo.controller;


import com.huangli.demo.pojo.User;
import com.huangli.demo.pojo.dto.LoginUserDto;
import com.huangli.demo.service.LoginService;
import com.huangli.demo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * 登录控制器
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("login")
    public ResponseResult login(HttpSession session, @RequestBody LoginUserDto loginUser) {
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        if (loginUser.getUsername() == null) {
            return ResponseResult.fail("用户名不能为空");

        }
        if (loginUser.getPassword() == null) {
            return ResponseResult.fail("登录密码不能为空");
        }
        LoginUserDto userInfoByLoginName = loginService.findUserInfoByLoginName(loginUser.getUsername());



        if (userInfoByLoginName == null) {
            return ResponseResult.fail("用户不存在");

        } else {

            boolean bl  = loginUser.getPassword().equals(userInfoByLoginName.getPassword());
            if (!bl) {
                return ResponseResult.fail("用户名密码错误");
            } else {
                User user = new User();
                user.setId(userInfoByLoginName.getId());
                user.setUser_name(userInfoByLoginName.getUsername());

                session.setAttribute("userinfo", user);

                return ResponseResult.success("登录成功");
            }


        }


    }
}
