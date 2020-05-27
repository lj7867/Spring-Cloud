package com.example.provide.service;

import org.springframework.stereotype.Component;

@Component
public class ErrorResult implements UserService{

    @Override
    public String queryUserList(Long id) {
        return "请求超时~~~~~~~"+id;
    }
}
