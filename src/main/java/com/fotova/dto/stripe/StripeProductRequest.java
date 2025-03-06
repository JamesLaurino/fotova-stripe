package com.fotova.dto.stripe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StripeProductRequest {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
    private List<StripOrderBasket> productBasket = new ArrayList<>();
}
