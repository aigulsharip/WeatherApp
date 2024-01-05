package com.example.WeatherApp.service;

import com.example.WeatherApp.model.OpenWeatherResponse;
import com.example.WeatherApp.feign.OpenWeatherClient;
import com.example.WeatherApp.model.Weather;
import com.example.WeatherApp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private OpenWeatherClient openWeatherClient;

    @Value("${openweather.api.key}")
    private String apiKey;

    @Override
    public Weather getWeatherByCity(String city) {
        OpenWeatherResponse response = openWeatherClient.getWeatherByCityName(city, apiKey);
        Weather weather = mapToWeatherEntity(response, city);
        return weatherRepository.save(weather);
    }

    @Override
    public Weather getWeatherByZipCode(String zipCode) {
        OpenWeatherResponse response = openWeatherClient.getWeatherByZipCode(zipCode, apiKey);
        String city = response.getName(); // Update this with actual city name if available in the response
        Weather weather = mapToWeatherEntity(response, city);
        return weatherRepository.save(weather);
    }




    private Weather mapToWeatherEntity(OpenWeatherResponse response, String city) {
        Weather weather = new Weather();
        weather.setCity(city);
        weather.setTemperature(response.getMain().getTemp().toString() + "°C");
        weather.setWindSpeed(response.getWind().getSpeed().toString() + " m/s");
        return weather;
    }
}