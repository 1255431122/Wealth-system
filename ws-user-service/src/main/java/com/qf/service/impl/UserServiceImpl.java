package com.qf.service.impl;

import com.qf.entity.UserEntity;

import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity login(UserEntity userEntity){
        return userMapper.selectOne(userEntity);
    }

}
