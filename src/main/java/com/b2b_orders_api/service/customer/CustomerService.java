package com.b2b_orders_api.service.customer;

import com.b2b_orders_api.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO criar(CustomerDTO customerDTO);

    List<CustomerDTO> listarTodos();

    CustomerDTO listarPorId(Long id);

    CustomerDTO atualizarPorId(Long id, CustomerDTO customerDTO);

    void deletarPorId(Long id);

}
