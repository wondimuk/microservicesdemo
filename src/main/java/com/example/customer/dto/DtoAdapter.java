package com.example.customer.dto;

import com.example.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DtoAdapter {

    public static Customer dtoToEntity(CustomerDTO customerDTO) {
        return Customer.builder()
                .id(customerDTO.getId())
                .email(customerDTO.getEmail())
                .phoneNumber(customerDTO.getPhoneNumber())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .shipTo(customerDTO.getShipTo())
                //.billTo(customerDTO.getBillTo())
                .build();
    }

    public static CustomerDTO entityToDto(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .shipTo(customer.getShipTo())
                //.billTo(customer.getBillTo())
                .build();
    }

    public static Page<CustomerDTO> pageableEntityToDtoAdapter(Page<Customer> entityPage, Function<Customer, CustomerDTO> converter) {
        List<CustomerDTO> dtoList = entityPage.getContent().stream()
                .map(converter)
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, entityPage.getPageable(), entityPage.getTotalElements());
    }
}
