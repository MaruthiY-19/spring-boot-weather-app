package com.weatherapp.weather_app_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {
   
    @JsonProperty("1h")
    private Double oneHour;

    
    @JsonProperty("3h")
    private Double threeHour;

   
    public Rain() {
    }

    public Rain(Double oneHour, Double threeHour) {
        this.oneHour = oneHour;
        this.threeHour = threeHour;
    }

    // Getters and Setters
    public Double getOneHour() {
        return oneHour;
    }

    public void setOneHour(Double oneHour) {
        this.oneHour = oneHour;
    }

    public Double getThreeHour() {
        return threeHour;
    }

    public void setThreeHour(Double threeHour) {
        this.threeHour = threeHour;
    }
}
