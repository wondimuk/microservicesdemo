package com.example.customer.dto;

import com.example.customer.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Address shipTo;

    private Address billTo;

    private String email;

    private String phoneNumber;

}
