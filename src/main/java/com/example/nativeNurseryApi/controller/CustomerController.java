package com.example.nativeNurseryApi.controller;

import com.example.nativeNurseryApi.dao.CustomerDao;
import com.example.nativeNurseryApi.model.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

//@PreAuthorize
@RestController("/customers/")
public class CustomerController {
    private CustomerDao dao;
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> list() {
        return dao.getCustomers();
    }
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Customer get(@PathVariable int id) {
        return dao.getCustomerById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Customer add(@Valid @RequestBody Customer customer) {
        return dao.createCustomer(customer);
    }
    @RequestMapping(path = "{id}", method = RequestMethod.POST)
    public Customer update(@PathVariable int id, @Valid @RequestBody Customer customer) {
        return dao.updateCustomer(customer);
    }
}
