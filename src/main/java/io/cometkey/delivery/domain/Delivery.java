package io.cometkey.delivery.domain;

import io.cometkey.delivery.type.Address;
import io.cometkey.delivery.type.DeliveryStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DELIVERY")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull
    private String memberName;

    @Embedded
    @NotNull
    private Address address;

    @NotNull
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private DeliveryStatus deliveryStatus;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private List<DeliveryItem> deliveryItems = new ArrayList<>();

    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime modifiedAt;
    @CreatedDate
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdAt;

    @Builder
    public Delivery(String memberName, Address address, Long orderId, DeliveryStatus deliveryStatus) {
        this.memberName = memberName;
        this.address = address;
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
    }

    public void addDeliverItem(DeliveryItem deliveryItem) {
        this.deliveryItems.add(deliveryItem);
        deliveryItem.setDelivery(this);
    }

    @PrePersist
    public void PrePersist() {
        this.deliveryStatus = this.deliveryStatus == null ? DeliveryStatus.SHIPPING : this.deliveryStatus;
    }
}
