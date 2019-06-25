package mx.com.bluesky.controller.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import mx.com.bluesky.model.dto.WeatherDto;
import mx.com.bluesky.service.WeatherService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;



@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerImplTest {
	
	@InjectMocks
	private WeatherControllerImpl weatherControllerImpl;

	@Mock
	private WeatherService service;
	
	@Mock
	private Model model;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void getWeather() {
		WeatherDto weather = factory.manufacturePojo(WeatherDto.class);
		
		when(service.getWeather(anyString())).thenReturn(weather);
		
		String response = weatherControllerImpl.getWeather("",model,null,null);
		
		assertNotNull(response);
	}
}
