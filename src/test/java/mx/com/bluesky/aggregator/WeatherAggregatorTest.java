package mx.com.bluesky.aggregator;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;
import mx.com.bluesky.entity.Weather;
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
	public void getWeather() {

		WeatherVo weater = factory.manufacturePojo(WeatherVo.class);
		
		when(restTemplate.getForEntity(anyString(), any(Class.class))).thenReturn(new ResponseEntity<>(weater,HttpStatus.OK));
		WeatherVo response = weatherAggregator.getWeather("");
		
		assertEquals(weater, response);
		
	}
	
}
