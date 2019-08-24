package cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.controller;

import cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mirror
 */
@RestController
public class TestController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/test")
    public String run() {
        providerService.send("Hello RocketMQ");
        return "ok";
    }
}
