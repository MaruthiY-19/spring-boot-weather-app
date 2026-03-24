package com.weatherapp.weather_app_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private double temp;
    private int humidity;
  
}
