package com.adu.learn.mybatis.service;

import com.adu.learn.mybatis.common.MybatisResult;
import com.adu.learn.mybatis.entity.UserInfo;

public interface UserInfoService {
    MybatisResult login(UserInfo userInfo);
}
