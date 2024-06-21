package com.example.nativeNurseryApi.model;

//import javax.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Plant {

    private int id;
    @NotBlank(message = "Field \"scientific_name\" can not be blank")
    @Size(min = 1, max = 100, message = "Field \"Scientific_name\" must be 100 characters or less")
    private String scientificName;
    @NotBlank(message = "Field \"common_name\" can not be blank")
    @Size(min = 1, max = 100, message = "Field \"common_name\" must be 100 characters or less")
    private String commonName;
    @Positive
    private double maxHeightCm;
    @Min(value = 1, message = "Field \"planting_month\" must be at least 1")
    @Max(value = 12, message = "Field \"planting_month\" must be 12 or less")
    private int plantingMonth;
    @Size(max = 200, message = "Field \"Description\" must be 200 characters or less")
    private String description;
    @Size(max = 100, message = "Field \"bloom_color\" must be 100 characters or less")
    private String bloomColor;
    private boolean pollinatorFriendly;
    private List<Nursery> nurseriesAvailable;
    private List<LightNeeds> lightNeeds;
    private List<Soil> soils;
    private List<Category> categories;

    public Plant() {}

    public Plant(int id, @NonNull String scientificName, String commonName, double maxHeightCm, int plantingMonth, String bloomColor, boolean pollinatorFriendly, List<Nursery> nurseriesAvailable, List<LightNeeds> lightNeeds, List<Soil> soils, List<Category> categories) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.maxHeightCm = maxHeightCm;
        this.plantingMonth = plantingMonth;
        this.bloomColor = bloomColor;
        this.pollinatorFriendly = pollinatorFriendly;
        this.nurseriesAvailable = nurseriesAvailable;
        this.lightNeeds = lightNeeds;
        this.soils = soils;
        this.categories = categories;
    }

    public Plant(int id, String scientificName, String commonName, double maxHeightCm, int plantingMonth, String description, String bloomColor, boolean pollinatorFriendly) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.maxHeightCm = maxHeightCm;
        this.plantingMonth = plantingMonth;
        this.description = description;
        this.bloomColor = bloomColor;
        this.pollinatorFriendly = pollinatorFriendly;
        this.nurseriesAvailable = new ArrayList<>();
        this.lightNeeds = new ArrayList<>();
        this.soils = new ArrayList<>();
        this.categories = new ArrayList<>();
    }
}
