package com.b2b_orders_api.service.customer;

import com.b2b_orders_api.dto.CustomerDTO;
import com.b2b_orders_api.mapper.CustomerMapper;
import com.b2b_orders_api.model.Customer;
import com.b2b_orders_api.model.User;
import com.b2b_orders_api.repository.CustomerRepository;
import com.b2b_orders_api.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO criar(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);

        Customer customerSalvo = customerRepository.save(customer);
        return customerMapper.toDTO(customerSalvo);
    }
    
    @Override
    public List<CustomerDTO> listarTodos() {
        List<Customer> users = customerRepository.findAll();
        return users.stream()
                .map(customerMapper::toDTO)
                .toList();
    }

    @Override
    public CustomerDTO listarPorId(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado com o id" + id));
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO atualizarPorId(Long id, CustomerDTO customerDTO) {
        Customer customerExistente = getCustomer(id);

        customerExistente.setName(customerDTO.name());

        Customer customerAtualizado = customerRepository.save(customerExistente);
        return customerMapper.toDTO(customerAtualizado);
    }

    @Override
    public void deletarPorId(Long id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
    }

    private Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado com o id" + id));
        return customer;
    }
}
