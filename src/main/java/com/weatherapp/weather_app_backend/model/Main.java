package com.weatherapp.weather_app_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// ... other imports if needed

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private double temp;
    private int humidity;
    // ... other fields like feels_like, temp_min, temp_max, pressure

    // Constructor (if any)
    // Getters and Setters for all fields
}