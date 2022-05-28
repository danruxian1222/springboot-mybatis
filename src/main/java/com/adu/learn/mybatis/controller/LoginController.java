package com.adu.learn.mybatis.controller;

import com.adu.learn.mybatis.common.MybatisResult;
import com.adu.learn.mybatis.entity.UserInfo;
import com.adu.learn.mybatis.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("登录")
    @PostMapping("login")
    public MybatisResult login(@RequestBody UserInfo userInfo){
        return userInfoService.login(userInfo);
    }
}
