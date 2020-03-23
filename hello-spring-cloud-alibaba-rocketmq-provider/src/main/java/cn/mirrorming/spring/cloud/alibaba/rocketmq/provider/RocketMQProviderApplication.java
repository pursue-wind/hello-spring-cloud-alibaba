package cn.mirrorming.spring.cloud.alibaba.rocketmq.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author mirror
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding({Source.class})
public class RocketMQProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQProviderApplication.class, args);
    }
}
