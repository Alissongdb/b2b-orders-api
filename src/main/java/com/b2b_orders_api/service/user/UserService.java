package com.b2b_orders_api.service.user;

import com.b2b_orders_api.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO criar(UserDTO userDTO);

    List<UserDTO> listarTodos();

    UserDTO listarPorId(Long id);

    UserDTO atualizarPorId(Long id, UserDTO userDTO);

    void deletarPorId(Long id);

}
