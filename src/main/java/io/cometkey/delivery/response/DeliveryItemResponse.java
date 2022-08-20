package io.cometkey.delivery.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryItemResponse {

    private String name;
    private Integer price;
    private Integer quantity;

    @Builder
    public DeliveryItemResponse(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
