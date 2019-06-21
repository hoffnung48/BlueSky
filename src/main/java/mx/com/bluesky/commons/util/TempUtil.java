package mx.com.bluesky.commons.util;

import org.springframework.stereotype.Component;

@Component
public class TempUtil {
	
	public float fromkelvinToCelsius(float kelvin){
		
		return kelvin - 273.15f;
	}
	
	public float fromkelvinToFarenheit(float kelvin){
		
		return (kelvin*1.8f) - 459.67f;
	}

}
