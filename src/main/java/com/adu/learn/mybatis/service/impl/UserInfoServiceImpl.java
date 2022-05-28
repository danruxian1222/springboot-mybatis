package com.adu.learn.mybatis.service.impl;

import com.adu.learn.mybatis.common.MybatisResult;
import com.adu.learn.mybatis.entity.UserInfo;
import com.adu.learn.mybatis.exception.BizException;
import com.adu.learn.mybatis.mapper.UserInfoMapper;
import com.adu.learn.mybatis.service.UserInfoService;
import com.adu.learn.mybatis.util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public MybatisResult login(UserInfo userInfo) {
        userInfo = this.userInfoMapper.findUserByNameAndPassword(userInfo);
        if(null == userInfo){
            //登录失败
            throw new BizException(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
        //登录成功
        //获取token
        String token = JwtHelper.createToken(userInfo.getUserName());
        return MybatisResult.ok(token);
    }
}
