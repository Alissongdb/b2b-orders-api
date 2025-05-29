package com.b2b_orders_api.controller.customer;

import com.b2b_orders_api.dto.CustomerDTO;
import com.b2b_orders_api.service.customer.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> criar(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO criado = customerService.criar(customerDTO);
        log.info("Cliente criado com sucesso!  |  ID: {}  |  Nome: {}", criado.id(), criado.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> listarPorId(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.listarPorId(id);
        return ResponseEntity.ok(customerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> atualizarPorId(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO atualizado = customerService.atualizarPorId(id, customerDTO);
        log.info("Cliente atualizado com sucesso!  |  ID: {}  |  Nome: {}", atualizado.id(), atualizado.name());
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        CustomerDTO customer = customerService.listarPorId(id);
        customerService.deletarPorId(id);
        log.info("Cliente deletado com sucesso!  |  ID: {}  |  Nome: {}", customer.id(), customer.name());
        return ResponseEntity.noContent().build();
    }
}
