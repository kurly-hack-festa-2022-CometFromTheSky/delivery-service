package io.cometkey.delivery.domain;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DELIVERY_ITEM")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryItem {

    @Id
    @GeneratedValue
    @Column(name = "delivery_item_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Builder
    public DeliveryItem(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
