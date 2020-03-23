package cn.mirrorming.hello.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mirror
 */
@RestController
//@RefreshScope 打开动态刷新功能
@RefreshScope
public class TestNacosConfigController {
    /**
     * 注入配置文件上下文
     */
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    @Value("${user.name}")
    String userName;

    @Value("${user.age}")
    int age;

    /**
     * 从上下文中读取配置
     */
    @GetMapping(value = "/hi")
    public String getNameFromNacosConfig() {
        return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
    }

    /**
     * 从上下文中读取配置
     */
    @GetMapping(value = "/test")
    public String test() {
        return "Hello " + userName + " -> " + age;
    }
}
