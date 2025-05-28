package com.b2b_orders_api.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record UserDTO(
        Long id,
        String email,
        String senha
) {
}
