package com.weatherapp.weather_app_backend.controller;

import com.weatherapp.weather_app_backend.model.WeatherResponse; 
import com.weatherapp.weather_app_backend.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather") 
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) { 
        try {
            WeatherResponse weather = weatherService.getWeatherByCity(city); 
            return ResponseEntity.ok(weather);
        } catch (ResponseStatusException ex) {
            // This catches exceptions thrown by WeatherService
            throw ex; 
        } catch (Exception ex) {
            // General error for unexpected issues
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching weather data", ex);
        }
    }
}
