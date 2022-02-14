package net.dreamstack.kafir2.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Kafir2KafkaStreamListener {

    @Autowired
    private final Kafir2Binding kafir2Binding;

    @StreamListener(target = Kafir2Binding.TOPIC1_INPUT)
    public void processTopic1Messages(@Payload String payload) {
        kafir2Binding.topic1MessageChannel().send(new GenericMessage<>(payload));
    }

}
