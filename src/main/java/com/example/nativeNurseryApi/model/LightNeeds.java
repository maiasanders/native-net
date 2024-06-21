package com.example.nativeNurseryApi.model;

import jakarta.validation.constraints.NotBlank;

public class LightNeeds {
    private int lightId;
    @NotBlank(message = "Field \"light_name\" can not be blank")
    private String lightName;

    public LightNeeds() {}

    public LightNeeds(int lightId, String lightName) {
        this.lightId = lightId;
        this.lightName = lightName;
    }

    public int getLightId() {
        return lightId;
    }

    public void setLightId(int lightId) {
        this.lightId = lightId;
    }

    public String getLightName() {
        return lightName;
    }

    public void setLightName(String lightName) {
        this.lightName = lightName;
    }
}
