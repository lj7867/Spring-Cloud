package com.example.provide.service;

import com.alibaba.fastjson.JSONObject;
import com.example.provide.dao.UserMapper;
import com.example.provide.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public String queryUserList(Long id) {
        List<User> users = userMapper.queryUserList(id);
        /*ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        valueOps.set("user", JSONObject.toJSONString(users));
        redisTemplate.expire("user", 120, TimeUnit.SECONDS);*/
        return JSONObject.toJSONString(users);
    }

}
