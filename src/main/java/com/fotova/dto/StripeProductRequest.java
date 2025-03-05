package com.fotova.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class StripeProductRequest {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
}
