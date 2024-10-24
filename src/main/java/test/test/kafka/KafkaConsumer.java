package test.test.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "topic-kdh", groupId = "group_test")
    public void listen(Object data) {
        System.out.println(data);
    }
}
