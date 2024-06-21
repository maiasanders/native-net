package com.example.nativeNurseryApi.dao;

import com.example.nativeNurseryApi.model.Nursery;

import java.util.List;

public interface NurseryDao {
    /**
     * Retrieve list of all nurseries that have a storefront, shipping,
     * and partially or fully match name search
     * @param name search query to match nursery name partially or fully
     * @return list of all matching nurseries
     */
    List<Nursery> getNurseriesWithStoreFrontAndShippingByName(String name);

    /**
     * Retrieves list of all nurseries that have a storefront and shipping
     * @return list of all matching nurseries
     */
    List<Nursery> getNurseriesWithStorefrontAndShipping();

    /**
     * Retrieves list of nurseries that have a storefront
     * and name partially or fully matches query string
     * @param name
     * @return List of all matching Nurseries
     */
    List<Nursery> getNurseriesWithStorefrontByName(String name);

    /**
     * Retrieves list of all nurseries that offer shipping
     * and where name partially or fully match query string
     * @param name
     * @return list of all matching nurseries
     */
    List<Nursery> getNurseriesShipByName(String name);

    /**
     * Retrieves list of all nurseries that have a storefront
     * @return list of all nurseries with storefront
     */
    List<Nursery> getNurseriesWithStorefront();

    /**
     * Retrieve all nurseries that offer shipping
     * @return list of all nurseries with shipping
     */
    List<Nursery> getNurseriesShips();

    /**
     * Retrieve all nurseries where name is partial or full match for query string
     * @param name
     * @return list of matching nurseries
     */
    List<Nursery> getNurseriesByName(String name);

    /**
     * Get all nurseries in database
     * @return list of all nurseries
     */
    List<Nursery> getNurseries();

    /**
     * Retrieve single nursery from database
     * @param id integer id associated with nursery
     * @return selected nursery
     */
    Nursery getNurseryById(int id);

    /**
     * Adds a new nursery to the database
     * @param nursery nursery to add to database
     * @return nursery with id assigned
     */
    Nursery createNursery(Nursery nursery);

    /**
     * Updates an existing nursery in the database
     * @param nursery
     * @return
     */
    Nursery updateNursery(Nursery nursery);

    /**
     * Deletes an existing nursery from the database
     * @param id integer id of nursery to delete
     */
    void deleteNurseryById(int id);
}
