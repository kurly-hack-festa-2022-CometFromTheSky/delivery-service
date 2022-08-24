package io.cometkey.delivery.controller;

import io.cometkey.delivery.controller.response.KeyResponse;
import io.cometkey.delivery.service.KeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyService;

    @GetMapping("/v1/emulator/{token}")
    public KeyResponse GetDeliveryInfo(@Valid @PathVariable String token) throws Exception {

        return KeyResponse.builder()
                .encryptedKey(this.keyService.getEncryptedKey(token))
                .build();
    }

    @PutMapping("/v1/emulator/{token}")
    public void PutDeliveryInfo(@Valid @PathVariable String token) {

        this.keyService.expireUsedKey(token);
    }
}
