package com.b2b_orders_api.mapper;

import com.b2b_orders_api.dto.CustomerDTO;
import com.b2b_orders_api.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .nomeEmpresa(customer.getNomeEmpresa())
                .build();
    }

    public Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.id())
                .nomeEmpresa(dto.nomeEmpresa())
                .build();
    }
}
