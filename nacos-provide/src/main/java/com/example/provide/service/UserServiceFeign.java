package com.example.provide.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "myService",fallback = ErrorResult.class)
public interface UserServiceFeign extends UserService {
}
