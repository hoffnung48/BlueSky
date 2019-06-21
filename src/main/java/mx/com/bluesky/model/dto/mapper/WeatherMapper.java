package mx.com.bluesky.model.dto.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.bluesky.commons.util.TempUtil;
import mx.com.bluesky.entity.Weather;
import mx.com.bluesky.entity.WeatherVo;
import mx.com.bluesky.model.dto.WeatherDto;

@Component
public class WeatherMapper {

	@Autowired
	private TempUtil util;
	
	public WeatherDto mappToOuter(WeatherVo weather) {

		WeatherDto outer = new WeatherDto();

		if (weather != null) {
			outer.setCity(weather.getName());
			outer.setDate(new Date());
			outer.setDescription(getDescription(weather.getWeather()));
			outer.setSunrise(new Date(weather.getSys().getSunrise()*1000));
			outer.setSunset(new Date(weather.getSys().getSunset()*1000));
			outer.setTempCelsius(util.fromkelvinToCelsius(weather.getMain().getTemp()));
			outer.setTempFarenheit(util.fromkelvinToFarenheit(weather.getMain().getTemp()));
		}
		
		return outer;

	}

	private List<String> getDescription(List<Weather> weather) {
		List<String> descriptions = new ArrayList<>();
		
		for(Weather val: weather){
			descriptions.add(val.getDescription());
		}
		return descriptions;
	}

}
