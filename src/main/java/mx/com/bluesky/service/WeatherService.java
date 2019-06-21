package mx.com.bluesky.service;

import mx.com.bluesky.model.dto.WeatherDto;

public interface WeatherService {

	WeatherDto getWeather(String cityId);

}
