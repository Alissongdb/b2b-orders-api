package com.b2b_orders_api.controller.User;

import com.b2b_orders_api.dto.UserDTO;
import com.b2b_orders_api.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserDTO> criar(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.criar(userDTO));
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
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        userService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}