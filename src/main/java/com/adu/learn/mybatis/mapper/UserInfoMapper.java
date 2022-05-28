package com.adu.learn.mybatis.mapper;

import com.adu.learn.mybatis.entity.UserInfo;

public interface UserInfoMapper {
    UserInfo findUserByNameAndPassword(UserInfo userInfo);
}
