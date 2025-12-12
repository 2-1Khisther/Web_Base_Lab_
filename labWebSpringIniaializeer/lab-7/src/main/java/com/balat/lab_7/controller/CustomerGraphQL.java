package com.balat.lab_7.controller;

import com.balat.lab_7.entity.Customer;
import com.balat.lab_7.sevice.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CustomerGraphQL {

    private final CustomerService customerService;

    public CustomerGraphQL(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public Customer getCustomerById(@Argument Long id) {
        return customerService.getCustomerById(id).orElse(null);
    }

    @MutationMapping
    public Customer createCustomer(
            @Argument String name,
            @Argument String email
    ) {
        Customer customer = new Customer(name, email);
        return customerService.saveCustomer(customer);
    }
}
