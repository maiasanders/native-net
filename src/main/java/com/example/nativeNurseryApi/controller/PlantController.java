package com.example.nativeNurseryApi.controller;

import com.example.nativeNurseryApi.dao.PlantDao;
import com.example.nativeNurseryApi.model.Plant;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/plants")
public class PlantController {

    private PlantDao plantDao;
    private final String BASE_API_URL = "/plants";
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Plant getPlantById(@PathVariable int id) {
        return plantDao.getPlantById(id);
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Plant> list(
            @RequestParam(defaultValue = "") String scientific_name_like,
            @RequestParam(defaultValue = "0.0") double max_height_lte) {

        if (scientific_name_like.isEmpty() && max_height_lte == 0.0 ) {
            return plantDao.getPlants();
        } else if (scientific_name_like.isEmpty()) {
            return plantDao.getPlantsByMaxHeight(max_height_lte);
        } else if (max_height_lte == 0.0) {
            return plantDao.getPlantsByScientificName(scientific_name_like);
        } else {
            return plantDao.getPlantsByScientificNameAndMaxHeight(scientific_name_like, max_height_lte);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Plant create(@Valid @RequestBody Plant plant) {
        return plantDao.createPlant(plant);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Plant update(@PathVariable int id, @Valid @RequestBody Plant plant) {
        return plantDao.updatePlant(plant);
    }

}
