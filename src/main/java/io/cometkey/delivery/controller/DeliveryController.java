package io.cometkey.delivery.controller;

import io.cometkey.delivery.domain.Delivery;
import io.cometkey.delivery.domain.DeliveryItem;
import io.cometkey.delivery.request.NewDelivery;
import io.cometkey.delivery.request.NewDeliveryItem;
import io.cometkey.delivery.response.DeliveryItemResponse;
import io.cometkey.delivery.response.DeliveryResponse;
import io.cometkey.delivery.service.DeliveryService;
import io.cometkey.delivery.domain.type.Address;
import io.cometkey.delivery.domain.type.DeliveryStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping("/v1/delivery/{delivery_id}")
    public DeliveryResponse GetDeliveryInfo(@Valid @PathVariable String delivery_id) {
        Delivery delivery = this.deliveryService.getDelivery(Long.valueOf(delivery_id));

        List<DeliveryItemResponse> deliveryItemResponses = new ArrayList<>();
        for (DeliveryItem deliveryItem : delivery.getDeliveryItems()) {
            deliveryItemResponses.add(DeliveryItemResponse.builder()
                    .name(deliveryItem.getName())
                    .price(deliveryItem.getPrice())
                    .quantity(deliveryItem.getQuantity())
                    .build()
            );
        }

        return DeliveryResponse.builder()
                .memberName(delivery.getMemberName())
                .zipcode(delivery.getAddress().getZipcode())
                .state(delivery.getAddress().getState())
                .city(delivery.getAddress().getCity())
                .town(delivery.getAddress().getTown())
                .fullAddress(delivery.getAddress().getFullAddress())
                .orderId(delivery.getOrderId())
                .deliveryStatus(delivery.getDeliveryStatus().toString())
                .deliveryItems(deliveryItemResponses)
                .build();
    }

    @PutMapping("/v1/delivery")
    public void PutDeliveryInfo(@Valid @RequestBody NewDelivery newDelivery) {
        List<DeliveryItem> deliveryItemList = new ArrayList<>();

        for (NewDeliveryItem deliveryItem : newDelivery.getDeliveryItems()) {
            deliveryItemList.add(DeliveryItem.builder()
                    .name(deliveryItem.getName())
                    .price(deliveryItem.getPrice())
                    .quantity(deliveryItem.getQuantity())
                    .build()
            );
        }

        this.deliveryService.addNewDelivery(Delivery.builder()
                        .memberName(newDelivery.getMemberName())
                        .address(Address.builder()
                                .zipcode(newDelivery.getZipcode())
                                .state(newDelivery.getState())
                                .city(newDelivery.getCity())
                                .town(newDelivery.getTown())
                                .fullAddress(newDelivery.getFullAddress())
                                .build())
                        .orderId(newDelivery.getOrderId())
                        .deliveryStatus(DeliveryStatus.valueOf(newDelivery.getDeliveryStatus()))
                        .build(),
                deliveryItemList
        );
    }

    /*
    @GetMapping("/v1/key/{order_id}")
    public KeyResponse GetKeyInfo(@Valid @PathVariable String order_id) {
        //TODO: key-service key 요청
        return KeyResponse.builder()
                .build();
    }
     */
}
