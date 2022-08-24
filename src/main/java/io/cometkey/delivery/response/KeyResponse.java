package io.cometkey.delivery.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyResponse {

    private String encryptedKey;

    @Builder
    public KeyResponse(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }
}
