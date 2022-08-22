package io.cometkey.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    public String getEncryptedKey(Long keyId) {

        //TODO: worker에 해당 id encryptedKey GET 요청
        //TODO: workerUrl 배포 후 수정
        String workerUrl = "http://localhost:8080";
        String getEncryptedKeyUrl = "/v1/worker/delivery/{key_id}";
        String url = workerUrl + getEncryptedKeyUrl;

        //Header

        //Body

        //Request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, keyId.toString());

        //Response
        return responseEntity.getBody();
    }

    public void expireUsedKey(Long keyId) {

        //TODO: Kafka produce -> 해당 id isUsed = true POST 요청
        TopicBuilder.name("delivery")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
