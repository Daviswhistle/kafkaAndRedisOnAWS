package test.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.test.kafka.KafkaProducer;

@RestController
@Slf4j
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/{topic}/{message}")
    public ResponseEntity<?> getResponse(
            @PathVariable String topic,
            @PathVariable String message
    ) {
        kafkaProducer.send(topic, message);
        return ResponseEntity.ok("\"" + message + "\" 메시지를 전송했습니다.");
    }
}
