package mx.com.blueskymodel.dto.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.bluesky.commons.util.TempUtil;
import mx.com.bluesky.entity.WeatherVo;
import mx.com.bluesky.model.dto.WeatherDto;
import mx.com.bluesky.model.dto.mapper.WeatherMapper;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class WeatherMapperTest {

	@InjectMocks
	private WeatherMapper weatherMapper;

	@Mock
	private TempUtil util;
	
	
	private PodamFactory factory = new PodamFactoryImpl();

	@Test
	public void mappToOuter() {
		WeatherVo vo = factory.manufacturePojo(WeatherVo.class);
		WeatherDto dto = weatherMapper.mappToOuter(vo);
		
		assertEquals(vo.getName(), dto.getCity());
		assertNotNull(dto.getDate());
		assertEquals(new Date(vo.getSys().getSunrise()*1000), dto.getSunrise());
		assertEquals(new Date(vo.getSys().getSunset()*1000), dto.getSunset());
	}

}
