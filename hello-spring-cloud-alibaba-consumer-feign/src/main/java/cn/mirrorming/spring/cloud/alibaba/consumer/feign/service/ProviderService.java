package cn.mirrorming.spring.cloud.alibaba.consumer.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mirror
 */
@FeignClient(value = "provider")
public interface ProviderService {

    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable String message);
}
