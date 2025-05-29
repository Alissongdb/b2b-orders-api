package com.b2b_orders_api.controller.User;

import com.b2b_orders_api.dto.UserDTO;
import com.b2b_orders_api.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDTO> criar(@RequestBody UserDTO userDTO) {
        UserDTO criado = userService.criar(userDTO);
        log.info("Usuário criado com sucesso!  |  ID: {}  |  E-mail: {}", criado.id(), criado.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> listarPorId(@PathVariable Long id) {
        UserDTO userDTO = userService.listarPorId(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> atualizarPorId(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO atualizado = userService.atualizarPorId(id, userDTO);
        log.info("Usuário atualizado com sucesso!  |  ID: {}  |  E-mail: {}", atualizado.id(), atualizado.email());
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        UserDTO usuario = userService.listarPorId(id);
        userService.deletarPorId(id);
        log.info("Usuário deletado com sucesso!  |  ID: {}  |  E-mail: {}", usuario.id(), usuario.email());
        return ResponseEntity.noContent().build();
    }

}