package org.example.delivermanagementsystem.service;

import jakarta.validation.Valid;
import org.example.delivermanagementsystem.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    int saveCustomer(@Valid CustomerDTO customerDTO);


    List<CustomerDTO> getAllCustomers();
}
