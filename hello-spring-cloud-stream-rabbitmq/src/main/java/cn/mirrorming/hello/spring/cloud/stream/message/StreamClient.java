package cn.mirrorming.hello.spring.cloud.stream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author mirror
 */
public interface StreamClient {

    String INPUT = "myMessageInput";
    String OUTPUT = "myMessageOut";

    @Input(INPUT)
    SubscribableChannel input();

    @Output(OUTPUT)
    MessageChannel output();
}
