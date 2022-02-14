package net.dreamstack.kafir2.kafka;

import net.dreamstack.kafir2.Kafir2Application;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Kafir2Application.class)
class Kafir2KafkaStreamListenerTest {

    @Autowired
    private Kafir2Binding kafir2Binding;

    @Autowired
    private MessageCollector messageCollector;

    @ParameterizedTest(name = "input = {0}")
    @CsvFileSource(resources = {"/regression/testfile.csv"})
    void testRegression(String input) {
        kafir2Binding.topic1SubscribableChannel().send(new GenericMessage<>(input));
        Message<String> received = (Message<String>) messageCollector.forChannel(kafir2Binding.topic1MessageChannel()).poll();
        assertThat(received.getPayload(), equalTo(input));
    }

}