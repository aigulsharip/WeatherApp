package com.example.WeatherApp.feign;

import com.example.WeatherApp.model.OpenWeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// OpenWeatherClient.java
@FeignClient(name = "openWeatherClient", url = "${openweather.api.url}")
public interface OpenWeatherClient {

    @GetMapping
    OpenWeatherResponse getWeatherByCityName(@RequestParam("q") String cityName, @RequestParam("appid") String apiKey);

    @GetMapping
    OpenWeatherResponse getWeatherByZipCode(@RequestParam("zip") String zipCode, @RequestParam("appid") String apiKey);

}


