package mx.com.bluesky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.bluesky.aggregator.WeatherAggregator;
import mx.com.bluesky.commons.exception.BusinessServiceException;
import mx.com.bluesky.model.dto.WeatherDto;
import mx.com.bluesky.model.dto.mapper.WeatherMapper;
import mx.com.bluesky.service.WeatherService;

@Component
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	private WeatherAggregator weatherAggregator;

	@Autowired
	private WeatherMapper weatherMapper;

	@Override
	public WeatherDto getWeather(String cityId) {
		try{
			return weatherMapper.mappToOuter(weatherAggregator.getWeather(cityId));
		}catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

}
