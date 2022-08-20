package io.cometkey.delivery.service;


import io.cometkey.delivery.domain.Delivery;
import io.cometkey.delivery.domain.DeliveryItem;
import io.cometkey.delivery.repository.DeliveryItemRepository;
import io.cometkey.delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryItemRepository deliveryItemRepository;

    public Delivery getDelivery(Long deliveryId) { return this.deliveryRepository.findById(deliveryId).get(); }

    public void addNewDelivery(Delivery delivery, List<DeliveryItem> deliveryItems) {
        for (DeliveryItem orderItem : deliveryItems) {
            delivery.addDeliverItem(orderItem);
        }
        this.deliveryRepository.save(delivery);
        this.deliveryItemRepository.saveAll(deliveryItems);
    }
}
