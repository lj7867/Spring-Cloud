package com.example.provide.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {

    @GetMapping("queryUserList")
    String queryUserList(@RequestParam("id") Long id);
}
