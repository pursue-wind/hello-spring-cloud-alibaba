package cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.fallback;

import cn.mirrorming.spring.cloud.alibaba.consumer.feign.service.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author mirror
 */
@Component
public class ProviderServiceFallback implements ProviderService {
    @Override
    public String echo(String message) {
        return "sentinel fallback";
    }
}
