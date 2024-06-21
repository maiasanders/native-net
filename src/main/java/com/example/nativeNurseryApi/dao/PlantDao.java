package com.example.nativeNurseryApi.dao;

import com.example.nativeNurseryApi.model.Plant;

import java.util.List;

public interface PlantDao {

    /**
     * Returns specified plant
     * @param id associated with desired plant
     * @return Plant object associated with id
     */
    Plant getPlantById(int id);

    /**
     * Returns all plants in database
     * @return list of instantiated Plant objects for all plants in DB
     */
    List<Plant> getPlants();

    /**
     * Gets plants that include queried common name (case insensitive)
     * @param commonName common name being searched for
     * @return list of all plants that include query string (case insensitive)
     */
    List<Plant> getPlantsByCommonName(String commonName);

    /**
     * Gets list of plants up to specified maximum height
     * @param maxHeight maximum height in centimeters
     * @return all plants less than maximum height
     */
    List<Plant> getPlantsByMaxHeight(double maxHeight);

    /**
     * Get list of plants equal or below specified max height with a partial or full match to specified string in scientific name
     * @param scientificName string to check against scientific names (case insensitive)
     * @param maxHeight maximum height in cm
     * @return list of plant objects that contain a match for scientific name and are <= max height
     */
    List<Plant> getPlantsByScientificNameAndMaxHeight(String scientificName, double maxHeight);

    /**
     * Get list of plants that contain queried string in scientific name (case insensitive)
     * @param scientificName scientific name to search for
     * @return list of plant objects with a scientific name that matches query in full or part
     */
    List<Plant> getPlantsByScientificName(String scientificName);

    /**
     * Adds a new plant to the database
     * @param plant the plant being added
     * @return the newly added plant with integer id assigned
     */
    Plant createPlant(Plant plant);

    /**
     * Update an existing plant in the database
     * @param plant plant with new values assigned
     * @return plant object successfully updated
     */
    Plant updatePlant(Plant plant);
}
