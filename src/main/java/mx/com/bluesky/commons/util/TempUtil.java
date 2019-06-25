package mx.com.bluesky.commons.util;

import org.springframework.stereotype.Component;

@Component
public class TempUtil {
	
	private static final float CELSIUS_FACTOR = 273.15f;
	private static final float FARENHEIT_FACTOR = 459.67f;
	private static final float MULTIPLY_FACTOR = 1.8f;
	
	public float fromkelvinToCelsius(float kelvin){
		
		return kelvin - CELSIUS_FACTOR;
	}
	
	public float fromkelvinToFarenheit(float kelvin){
		
		return (kelvin*MULTIPLY_FACTOR) - FARENHEIT_FACTOR;
	}

}
