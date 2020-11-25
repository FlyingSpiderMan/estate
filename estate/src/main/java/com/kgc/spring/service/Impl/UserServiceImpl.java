package com.kgc.spring.service.Impl;

import com.kgc.spring.mapper.UserMapper;
import com.kgc.spring.pojo.User;
import com.kgc.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    public int addUser(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }
}
