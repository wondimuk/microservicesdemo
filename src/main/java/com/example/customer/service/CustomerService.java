package com.example.customer.service;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {

    Page<CustomerDTO> findAllCustomers(Pageable pageable);

    CustomerDTO findCustomer(Long cutomerId);

    CustomerDTO findCustomerByField(String field);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    void deleteCustomer(String customerId);

    Customer updateCustomer(String customerId);

}
