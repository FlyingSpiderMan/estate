package com.kgc.spring.service;

import com.kgc.spring.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService{
    User selectUser(String cardId);
}
