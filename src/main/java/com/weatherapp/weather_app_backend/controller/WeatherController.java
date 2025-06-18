package com.weatherapp.weather_app_backend.controller;

import com.weatherapp.weather_app_backend.model.WeatherResponse; // <-- This is CORRECT
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

    // This is the crucial part that handles the /api/weather request
    @GetMapping("/api/weather") // Make sure this annotation is present and correct
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) { // Make sure @RequestParam String city is correct
        try {
            WeatherResponse weather = weatherService.getWeatherByCity(city); // CORRECTED LINE
            return ResponseEntity.ok(weather);
        } catch (ResponseStatusException ex) {
            // This catches exceptions thrown by WeatherService
            throw ex; // Re-throw to let Spring handle the HTTP status
        } catch (Exception ex) {
            // General error for unexpected issues
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching weather data", ex);
        }
    }
}