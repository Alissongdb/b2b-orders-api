package com.b2b_orders_api.mapper;

import com.b2b_orders_api.dto.UserDTO;
import com.b2b_orders_api.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .senha(user.getSenha())
                .build();
    }

    public User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.id())
                .email(dto.email())
                .senha(dto.senha())
                .build();
    }
}
