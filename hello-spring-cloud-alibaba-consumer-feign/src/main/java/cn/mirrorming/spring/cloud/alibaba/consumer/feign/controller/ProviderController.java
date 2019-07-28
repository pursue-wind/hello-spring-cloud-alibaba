package cn.mirrorming.spring.cloud.alibaba.consumer.feign.controller;

import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mirror
 */
@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("echo")
    public String echo() {
        return providerService.echo("Feign Client");
    }
}
