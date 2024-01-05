package com.example.WeatherApp.model;

import lombok.Data;

@Data
public class OpenWeatherResponse {
    private String name;
    private Main main;
    private Wind wind;

}

