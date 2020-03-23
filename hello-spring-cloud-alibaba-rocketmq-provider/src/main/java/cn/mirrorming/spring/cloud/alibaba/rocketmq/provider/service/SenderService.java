package cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service;

import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SenderService {
    @Autowired
    private MySource source;

    public void send(String msg) throws Exception {
        source.output1().send(MessageBuilder.withPayload(msg).build());
    }

    public <T> void sendTimeout(T msg, Long timeout, String tag) throws Exception {
        Message message = MessageBuilder.createMessage(msg,
                new MessageHeaders(Stream.of(tag)
                        .collect(Collectors.toMap(str -> MessageConst.PROPERTY_TAGS, String::toString))));
        source.output1().send(message, timeout);
    }

    public <T> void sendWithTags(T msg, String tag) throws Exception {
        Message message = MessageBuilder.createMessage(msg,
                new MessageHeaders(Stream.of(tag)
                        .collect(Collectors.toMap(str -> MessageConst.PROPERTY_TAGS, String::toString))));
        source.output1().send(message);
    }

    public <T> void sendObject(T msg, String tag) throws Exception {
        Message message = MessageBuilder.withPayload(msg)
                .setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        source.output1().send(message);
    }

    public <T> void sendTransactionalMsg(T msg, int num) throws Exception {
        MessageBuilder builder = MessageBuilder.withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
        builder.setHeader("test", String.valueOf(num));
        builder.setHeader(RocketMQHeaders.TAGS, "binder");
        Message message = builder.build();
        source.output2().send(message);
    }
}