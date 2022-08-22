package io.cometkey.delivery.controller;

import io.cometkey.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping("/v1/delivery/{key_id}")
    public String GetDeliveryInfo(@Valid @PathVariable String key_id) {

        return this.deliveryService.getEncryptedKey(Long.valueOf(key_id));
    }

    @PutMapping("/v1/delivery/{key_id}")
    public void PutDeliveryInfo(@Valid @PathVariable String key_id) {

        this.deliveryService.expireUsedKey(Long.valueOf(key_id));
    }
}
