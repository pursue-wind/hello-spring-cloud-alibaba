package cn.mirrorming.spring.cloud.alibaba.rocketmq.provider;

import cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service.Foo;
import cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service.MySource;
import cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author mirror
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(MySource.class)
public class RocketMQProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMQProviderApplication.class, args);
    }


}
