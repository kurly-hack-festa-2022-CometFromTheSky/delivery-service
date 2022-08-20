package io.cometkey.delivery.domain.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryResponse {

    private String memberName;
    private String zipcode;
    private String state;        // 시, 도
    private String city;        // 시, 군, 구
    private String town;        // 읍, 면, 동
    private String fullAddress;
    private Long orderId;
    private String deliveryStatus;
    private List<DeliveryItemResponse> deliveryItems = new ArrayList<>();

    @Builder
    public DeliveryResponse(String memberName, String zipcode, String state, String city, String town, String fullAddress, Long orderId, String deliveryStatus, List<DeliveryItemResponse> deliveryItems) {
        this.memberName = memberName;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.town = town;
        this.fullAddress = fullAddress;
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryItems = deliveryItems;
    }
}
