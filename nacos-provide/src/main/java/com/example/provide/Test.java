/*
package com.example.provide;

import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.util.Properties;


public class Test {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "192.168.245.130:8848");
        properties.setProperty("namespace","849c385c-df44-49fd-ab49-6521c9debac6");
        */
/**
         * 获取到nacosService
         *//*

        NamingService naming = NamingFactory.createNamingService(properties);
        */
/**
         * 注册实例集群
         *//*

        naming.registerInstance("nacos-config-jq1", "127.0.0.1", 6666, "dev-test1");

        naming.registerInstance("nacos-config-jq1", "2.2.2.2", 9999, "dev-test2");
        */
/**
         * 获取所有实例
         *//*

//        System.out.println(naming.getAllInstances("nacos-config"));
        */
/**
         * 注销
         *//*

//        naming.deregisterInstance("nacos-config", "2.2.2.2", 9999, "DEFAULT");


        naming.subscribe("nacos-config-jq1","nacos-config-jq2", event -> {
            System.out.println(((NamingEvent)event).getServiceName());
            System.out.println(((NamingEvent)event).getInstances());
        });
    }
}
*/
