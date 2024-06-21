package com.example.nativeNurseryApi.dao;

import com.example.nativeNurseryApi.model.Sale;

import java.util.List;

public interface SaleDao {
    /**
     * Search for single sale by int id
     * @param id saleId associated with specific sale
     * @return specified Sale object
     */
    Sale getCartById(int id);

    /**
     * Find all sale from a specified nursery
     * @param nurseryId int id for selected nursery
     * @return list of all Sale objects from selected nursery
     */
    List<Sale> getOrdersByNursery(int nurseryId);

    /**
     * Retrieve all sales for specified customer
     * @param customerId int id for selected customer
     * @return list of all Sales for customer
     */
    List<Sale> getOrderByCustomer(int customerId);

    /**
     * Add a new sale to the database
     * @param sale new sale to add to database
     * @return new sale with id assigned
     */
    Sale createOrder(Sale sale);

    /**
     * Updates an existing sale in database
     * @param sale
     * @return
     */
    Sale updateOrder(Sale sale);

    /**
     * Removes a sale from database,
     * sale must not have been delivered or picked up
     * @param id int id of sale to be deleted
     */
    void deleteOrderById(int id);
}
