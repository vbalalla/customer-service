package com.sample.customer_service.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.sample.customer_service.dto.CustomerDTO;
import com.sample.customer_service.model.Customer;
import com.sample.customer_service.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCustomer() {
        String customerId = "bbfc1ca7-651d-4b9a-9383-4dbc188b9e28";
        String firstName = "John";
        String middleName = "BoB";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String phone = "123-456-7890";

        Customer customer = new Customer(customerId, firstName, middleName, lastName, email, phone);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        CustomerDTO result = customerService.getCustomer(customerId);
        assertNotNull(result);
        assertEquals(customerId, result.customerId());
        assertEquals(firstName, result.firstName());
        assertEquals(middleName, result.middleName());
        assertEquals(lastName, result.lastName());
        assertEquals(email, result.email());
        assertEquals(phone, result.phone());
    }
}