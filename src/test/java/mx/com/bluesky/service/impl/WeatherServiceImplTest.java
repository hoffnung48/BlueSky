package mx.com.bluesky.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import mx.com.bluesky.aggregator.WeatherAggregator;
import mx.com.bluesky.entity.WeatherVo;
import mx.com.bluesky.model.dto.WeatherDto;
import mx.com.bluesky.model.dto.mapper.WeatherMapper;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {
	
	@InjectMocks
	private WeatherServiceImpl weatherServiceImpl;
	
	@Mock
	private WeatherMapper weatherMapper;

	@Mock
	private WeatherAggregator weatherAggregator;
	
	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void getWeather() {
		WeatherVo vo = factory.manufacturePojo(WeatherVo.class);
		WeatherDto dto = factory.manufacturePojo(WeatherDto.class);
		
		when(weatherMapper.mappToOuter(any(WeatherVo.class))).thenReturn(dto);
		when(weatherAggregator.getWeather(anyString())).thenReturn(vo);
		
		WeatherDto response = weatherServiceImpl.getWeather("");
		
		assertEquals(dto, response);
	}
	
	@Test(expected=RuntimeException.class)
	public void getWeatherExceptionTest() {
		when(weatherAggregator.getWeather(anyString())).thenThrow(new RuntimeException());
		weatherServiceImpl.getWeather("");
	}
	
}
