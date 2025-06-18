package com.weatherapp.weather_app_backend.service; // <-- Missing "_weather" here

import com.weatherapp.weather_app_backend.model.WeatherResponse; // <-- This is CORRECT
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger; // Import this
import org.slf4j.LoggerFactory; // Import this

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class); // Add this line

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeatherByCity(String city) {
        String url = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .toUriString();

        logger.info("Attempting to fetch weather from URL: {}", url); // Add this logging line

        try {
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (Exception e) {
            logger.error("Error fetching weather for city {}: {}", city, e.getMessage(), e); // Enhanced logging
            return null;
        }
    }
}