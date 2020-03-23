package cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author mirror
 */
@Service
public class ProviderService {
    @Autowired
    private MessageChannel output;

    public void send(String message) {
        Message<String> build = MessageBuilder.withPayload(message).build();
        MessageHeaders headers = build.getHeaders();
        output.send(MessageBuilder.withPayload(message).build());
    }
}
