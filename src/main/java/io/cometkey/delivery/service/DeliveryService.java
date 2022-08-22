package io.cometkey.delivery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {


    public String getEncryptedKey(Long keyId) {
        //TODO: worker에 해당 id encryptedKey GET 요청
        return null;
    }

    public void expireUsedKey(Long keyId) {
        //TODO: worker에 해당 id isUsed = true POST 요청
    }
}
