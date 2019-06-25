package mx.com.bluesky.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.com.bluesky.entity.WeatherVo;

@Component
public class WeatherAggregator {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${base.url}")
	private String baseURL;

	@Value("${app.key}")
	private String key;
	
	@Value("${app.key.param.name}")
	private String keyName;
	
	
	public WeatherVo getWeather(String cityId) {
		return restTemplate.getForEntity(getUrl(cityId), WeatherVo.class).getBody();
	}


	private String getUrl(String cityId) {
		StringBuilder builder = new StringBuilder();
		builder.append(baseURL);
		builder.append("?q=");
		builder.append(cityId);
		builder.append("&");
		builder.append(keyName);
		builder.append("=");
		builder.append(key);
		return builder.toString();
	}

}
