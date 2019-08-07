package com.example.bootdemo.service.impl;

import com.example.bootdemo.entity.User;
import com.example.bootdemo.mapper.UserMapper;
import com.example.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    public User getUserById(Long id){
        return mapper.getUserById(id);
    }
}
