package cn.mirrorming.hello.spring.cloud.stream.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author mirror
 */
@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object inputProcess(Object message) {
        log.info("inputProcess: {}:", message);
        return message;
    }

    @StreamListener(StreamClient.OUTPUT)
    public void OutputProcess(Object message) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        log.info("OutputProcess: {}:", message);
    }
}
