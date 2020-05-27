package com.example.provide;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.example.provide.dao")
@SpringBootApplication
// 修改配置自动刷新失效
//@NacosPropertySource(dataId = "nacos-config-public.yml",groupId = "PUBLIC_GROUP",autoRefreshed = true)
public class ProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication.class, args);
    }
}
