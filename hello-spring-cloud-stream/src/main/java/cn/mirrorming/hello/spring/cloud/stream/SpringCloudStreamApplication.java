package cn.mirrorming.hello.spring.cloud.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author mirror
 */

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "cn.mirrorming.hello.spring.cloud.stream.*")
public class SpringCloudStreamApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamApplication.class, args);
    }

}