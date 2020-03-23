package cn.mirrorming.spring.cloud.alibaba.rocketmq.provider.service;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author mirror
 */
@Service
public class ProviderService {
    @Autowired
    private SenderService senderService;


    public void send(String msg) {
        LongStream.range(1, 100).forEach(i -> {
            try {
                senderService.sendTimeout("延时消息测试"
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) + msg, i, "标签" + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
