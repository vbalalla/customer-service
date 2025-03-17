package com.sample.customer_service.mapper;

import com.sample.customer_service.dto.CustomerDTO;
import com.sample.customer_service.model.Customer;

public class CustomerMapper {

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getCustomerId(), customer.getFirstName(),
                customer.getMiddleName(), customer.getLastName(), customer.getEmail(), customer.getPhone());
    }

    public static Customer toCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.customerId(), customerDTO.firstName(),
                customerDTO.middleName(), customerDTO.lastName(), customerDTO.email(), customerDTO.phone());
    }
}
