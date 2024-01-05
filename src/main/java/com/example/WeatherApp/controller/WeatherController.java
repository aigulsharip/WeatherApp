package com.example.WeatherApp.controller;

import com.example.WeatherApp.model.Weather;
import com.example.WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/city/{city}")
    public ResponseEntity<Weather> getWeatherByCity(@PathVariable String city) {
        Weather weather = weatherService.getWeatherByCity(city);
        return ResponseEntity.ok(weather);
    }

    @GetMapping("/zip/{zipCode}")
    public ResponseEntity<Weather> getWeatherByZipCode(@PathVariable String zipCode) {
        Weather weather = weatherService.getWeatherByZipCode(zipCode);
        return ResponseEntity.ok(weather);
    }


}