package cn.mirrorming.hello.spring.cloud.stream.controller;

import cn.mirrorming.hello.spring.cloud.stream.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mirror
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    StreamClient streamClient;

    @GetMapping("/test/output")
    public String testOutputStream() {
        String s = "hello Spring Cloud Stream";
        streamClient.output().send(MessageBuilder.withPayload(s).build());
        return "ok";
    }

    @GetMapping("/test/input")
    public String testInputStream() {
        String s = "hello Spring Cloud Stream ";
        for (int i = 0; i < 100000; i++) {
            streamClient.input().send(MessageBuilder.withPayload(s + i).build());
        }
        System.out.println("===========");
        return "ok";
    }
}
