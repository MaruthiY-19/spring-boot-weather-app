package com.weatherapp.weather_app_backend.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {
    private int all;

    // Getters and Setters
    public int getAll() {
        return all;
    }
    public void setAll(int all) {
        this.all = all;
    }
}