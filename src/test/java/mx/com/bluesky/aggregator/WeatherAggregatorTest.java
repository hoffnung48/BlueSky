package mx.com.bluesky.aggregator;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.bluesky.entity.WeatherVo;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


@RunWith(MockitoJUnitRunner.class)
public class WeatherAggregatorTest {

	@InjectMocks
	private WeatherAggregator weatherAggregator;

	@Mock
	private RestTemplate restTemplate;
	
	private PodamFactory factory = new PodamFactoryImpl();
	
	@Test
	public void getWeatherTest() {

		WeatherVo weater = factory.manufacturePojo(WeatherVo.class);
		
		when(restTemplate.getForEntity(anyString(), any(Class.class))).thenReturn(new ResponseEntity<>(weater,HttpStatus.OK));
		WeatherVo response = weatherAggregator.getWeather("");
		
		assertEquals(weater, response);
		
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void getWeatherTestNotFound() {

		WeatherVo weater = factory.manufacturePojo(WeatherVo.class);
		
		when(restTemplate.getForEntity(anyString(), any(Class.class))).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
		weatherAggregator.getWeather("");		
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void getWeatherTestBadRequest() {

		WeatherVo weater = factory.manufacturePojo(WeatherVo.class);
		
		when(restTemplate.getForEntity(anyString(), any(Class.class))).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		weatherAggregator.getWeather("");		
	}
	
	@Test(expected=HttpServerErrorException.class)
	public void getWeatherTestBusinessException() {

		WeatherVo weater = factory.manufacturePojo(WeatherVo.class);
		
		when(restTemplate.getForEntity(anyString(), any(Class.class))).thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		weatherAggregator.getWeather("");

	}
	
}
