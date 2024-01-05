package com.example.WeatherApp.repository;

import com.example.WeatherApp.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findByCity(String city);
}