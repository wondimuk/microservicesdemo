package com.example.customer.controller;

import com.example.customer.dto.CustomerDTO;
import com.example.customer.service.CustomerService;
import com.sun.jdi.request.InvalidRequestStateException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDTO>> getCustomers(Pageable pageable) {
        Page<CustomerDTO> customers = customerService.findAllCustomers(pageable);
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = customerService.findCustomer(id);
        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByField(
            @RequestParam(name = "email", required = false) String emailId,
            @RequestParam(name = "phone", required = false) String phone) {
        String filterBy = getFilterBy(emailId, phone);
        CustomerDTO customer = customerService.findCustomerByField(filterBy);
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        return ResponseEntity.ok().body(customerService.addCustomer(customerDTO));
    }

    private String getFilterBy(String emailId, String phone) {
        if (StringUtils.isNotBlank(emailId)) {
            return emailId;
        } else if (StringUtils.isNotBlank(phone)) {
            return phone;
        } else {
            throw new InvalidRequestStateException("Filter criteria not available!, atleast one search criteria expected!");
        }
    }
}
