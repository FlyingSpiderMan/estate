package com.kgc.spring.service;

import com.kgc.spring.mapper.UserMapper;
import com.kgc.spring.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    public User selectUser(String cardId) {
        User user = userMapper.selectByPrimaryKey(cardId);
        return user;
    }
}
