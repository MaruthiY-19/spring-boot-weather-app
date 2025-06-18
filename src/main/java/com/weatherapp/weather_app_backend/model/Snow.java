package com.weatherapp.weather_app_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snow {
    // Volume for the last 1 hour
    @JsonProperty("1h")
    private Double oneHour;

    // Volume for the last 3 hours
    @JsonProperty("3h")
    private Double threeHour;

    // Constructors (optional, but good practice)
    public Snow() {
    }

    public Snow(Double oneHour, Double threeHour) {
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