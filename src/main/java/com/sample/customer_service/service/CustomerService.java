package com.sample.customer_service.service;

import com.sample.customer_service.dto.CustomerDTO;
import com.sample.customer_service.mapper.CustomerMapper;
import com.sample.customer_service.model.Customer;
import com.sample.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::toCustomerDTO).collect(Collectors.toList());
    }

    public CustomerDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return null;
        }
        return CustomerMapper.toCustomerDTO(customer);
    }

    public void addCustomer(CustomerDTO customerDTO) {
        customerRepository.save(CustomerMapper.toCustomer(customerDTO));
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        customerRepository.save(CustomerMapper.toCustomer(customerDTO));
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
