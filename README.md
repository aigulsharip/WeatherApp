# Weather Data Spring Boot Application

This Spring Boot application integrates with a third-party API (OpenWeather API) to retrieve weather data based on zip code or city name. The application utilizes Hibernate to persist weather data into a local database and uses Spring Scheduler to periodically refresh the weather data from the third-party API.

## Features

- Fetch weather data by zip code or city name.
- Store weather data (including temperature, description, wind speed, humidity, etc.) into a local database using Hibernate.
- Periodically refresh weather data from the OpenWeather API using Spring Scheduler.

## Technologies Used

- Spring Boot
- Spring Web
- Spring Data JPA
- Feign Client
- Hibernate
- H2 Database (or your preferred database)
- Spring Scheduler
- OpenWeather API

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed
- Maven installed
- OpenWeather API Key (Sign up at [OpenWeather](https://openweathermap.org/api) to get your API key)

### Steps to Run the Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/aigulsharip/WeatherApp.git
   ```
2. ** Navigate to the Project Directory

```bash
cd weather-data-spring-boot
```

### Endpoints
GET /api/weather/zip/{zipCode} - Fetch weather data by zip code.
GET /api/weather/city/{cityName} - Fetch weather data by city name.

### Scheduled Tasks
Weather data is refreshed periodically using Spring Scheduler. The application contains scheduled tasks to fetch and update weather data at specified intervals (e.g., every hour for zip code "94103" and every two hours for city "San Francisco").
