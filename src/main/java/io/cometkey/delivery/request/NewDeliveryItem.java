package io.cometkey.delivery.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class NewDeliveryItem {

    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer quantity;

    @Builder
    public NewDeliveryItem(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
