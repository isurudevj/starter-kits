package net.dreamstack.kafir2.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Kafir2Binding {

    public static final String TOPIC1_INPUT = "topic1-in";
    public static final String TOPIC1_OUTPUT = "topic1-out";

    @Input(TOPIC1_INPUT)
    SubscribableChannel topic1SubscribableChannel();

    @Output(TOPIC1_OUTPUT)
    MessageChannel topic1MessageChannel();

}
