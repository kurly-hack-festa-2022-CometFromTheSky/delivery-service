package io.cometkey.delivery.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KeyService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static String TOPIC_NAME = "expired";

    public String getEncryptedKey(String token) {

        //DONE: worker에 해당 id encryptedKey GET 요청
        //TODO: workerUrl 배포 후 수정
        String workerUrl = "http://localhost:8080";
        String getEncryptedKeyUrl = "/v1/worker/{token}";
        String url = workerUrl + getEncryptedKeyUrl;

        //Header

        //Body

        //Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, token.toString());

        //Response
        return responseEntity.getBody();
    }

    public void expireUsedKey(String token) {

        //DONE: Kafka produce -> 해당 id isUsed = true POST 요청
        String messageData = token;
        this.kafkaTemplate.send(new ProducerRecord<>(TOPIC_NAME, messageData));
    }
}
