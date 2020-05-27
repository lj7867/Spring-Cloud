package com.example.provide;

import com.example.provide.service.UserService;
import com.example.provide.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class TestController {
    @Value("${name}")
    private String name;

    @Value("${devName}")
    private String devName;

    @Value("${nacosName}")
    private String nacosName;
    @Autowired
    private UserServiceFeign userService;

    @GetMapping("/string")
    public String string() {
        return "hello world!";
    }

    @GetMapping("/list")
    public List<String> list() {
        return Arrays.asList("zs", "ls", "ww", "zl");
    }

    @GetMapping("/map")
    public Map<String, Object> map() {
        Map<String, Object> result = new HashMap<>(1);
        result.put("张三", "zs");
        result.put("李四", "ls");
        result.put("王五", "ww");
        result.put("赵六", "zl");
        return result;
    }

    @RequestMapping("/getName")
    public String getValue() {
        return name;
    }

    @RequestMapping("/getDevName")
    public String getDevName() {
        return devName;
    }



    @RequestMapping("/getNacosName")
    public String getNacosName() {
        return nacosName;
    }


    @GetMapping("getUser")
    public String get(@RequestParam("id") Long id) {
        return userService.queryUserList(id);
    }
}
