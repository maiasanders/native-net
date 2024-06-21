package com.example.nativeNurseryApi.dao;

import com.example.nativeNurseryApi.model.Customer;

import java.util.List;

public interface CustomerDao {
    /**
     * Get all customers in database
     * @return list of all customers
     */
    List<Customer> getCustomers();

    /**
     * Get a specific customer from the database
     * Returns null if customer does not exist
     * @param id associated with selected customer
     * @return Customer obj selected
     */
    Customer getCustomerById(int id);

    /**
     * Adds a new customer to database
     * @param customer new customer to add
     * @return customer with id assigned
     */
    Customer createCustomer(Customer customer);

    /**
     * Updates an existing customer
     * @param customer customer with updated values
     * @return updated customer as retrieved from DB
     */
    Customer updateCustomer(Customer customer);
}
