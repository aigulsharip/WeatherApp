package com.example.WeatherApp.scheduler;

import com.example.WeatherApp.model.Weather;
import com.example.WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {

    @Autowired
    private WeatherService weatherService;

    @Scheduled(cron = "0 0 * * * *") // Refresh weather data every hour
    public void refreshWeatherDataByCity() {
        Weather weather = weatherService.getWeatherByCity("San Francisco"); // Refresh data for San Francisco city
        System.out.println("Refreshed weather data for city: " + weather.getCity());
    }
}