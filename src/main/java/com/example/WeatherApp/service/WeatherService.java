package com.example.WeatherApp.service;


import com.example.WeatherApp.model.Weather;

public interface WeatherService {
    Weather getWeatherByCity(String city);
    Weather getWeatherByZipCode(String zipCode);

}