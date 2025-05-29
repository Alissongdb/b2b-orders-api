package com.b2b_orders_api.dto;

import lombok.Builder;

@Builder
public record CustomerDTO(
        Long id,
        String name
) {

}
