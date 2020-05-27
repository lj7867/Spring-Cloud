package com.example.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
    @Autowired
    private RestTemplate restTemplate;

    @Value("${name}")
    private String devName3;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/string")
    public String string() {
        return restTemplate.getForObject("http://myService/string",String.class);
    }

    @GetMapping("/list")
    public List<String> list() {
        return (List<String>)restTemplate.getForObject("http://nacos-config/list", List.class);
    }

    @GetMapping("/map")
    public Map<String,Object> map() {
        return restTemplate.getForObject("http://nacos-config/map", Map.class);
    }

    @RequestMapping("/getDevName3")
    public String getDevName3() {
        return devName3;
    }

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("id") Long id) {
        Map<String,Object> uriMap = new HashMap<>(1);
        uriMap.put("id", id);
        return restTemplate.getForObject("http://myService/getUser?id="+id,String.class,uriMap);
    }
}
