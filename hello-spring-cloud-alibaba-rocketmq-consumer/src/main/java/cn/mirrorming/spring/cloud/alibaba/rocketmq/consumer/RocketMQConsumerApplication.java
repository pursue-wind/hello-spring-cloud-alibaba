package cn.mirrorming.spring.cloud.alibaba.rocketmq.consumer;

import cn.mirrorming.spring.cloud.alibaba.rocketmq.consumer.service.MySink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author mirror
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({MySink.class})
public class RocketMQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQConsumerApplication.class, args);
    }
}
