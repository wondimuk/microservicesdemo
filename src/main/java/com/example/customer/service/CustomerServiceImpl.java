package com.example.customer.service;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.dto.DtoAdapter;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<CustomerDTO> findAllCustomers(Pageable pageable) {
        return DtoAdapter.pageableEntityToDtoAdapter(customerRepository.findAll(pageable), DtoAdapter::entityToDto);
    }

    @Override
    public CustomerDTO findCustomer(Long customerId) {
        return DtoAdapter.entityToDto(customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with customerId={} not found", customerId.toString())));
    }

    @Override
    public CustomerDTO findCustomerByField(String field) {
        return null;
    }


    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        customerRepository.save(DtoAdapter.dtoToEntity(customerDTO));
        return customerDTO;
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public Customer updateCustomer(String customerId) {
        return null;
    }
}
