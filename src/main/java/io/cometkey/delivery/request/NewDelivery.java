package io.cometkey.delivery.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class NewDelivery {

    @NotNull
    private String memberName;

    @NotNull
    private String zipcode;
    @NotNull
    private String state;        // 시, 도
    @NotNull
    private String city;        // 시, 군, 구
    @NotNull
    private String town;        // 읍, 면, 동
    @NotNull
    private String fullAddress;

    @NotNull
    private Long orderId;

    private String deliveryStatus;

    @NotNull
    private List<NewDeliveryItem> deliveryItems;

    @Builder
    public NewDelivery(String memberName, String zipcode, String state, String city, String town, String fullAddress, Long orderId, String deliveryStatus) {
        this.memberName = memberName;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.town = town;
        this.fullAddress = fullAddress;
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
    }
}
