package io.cometkey.delivery.repository;

import io.cometkey.delivery.domain.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long> {
}
