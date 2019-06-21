package mx.com.bluesky.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class Main {

	@JsonProperty("temp")
	private float temp;
	
	@JsonProperty("pressure")
	private int pressure;
	
	@JsonProperty("humidity")
	private int humidity;
	
	@JsonProperty("temp_min")
	private float tempMin;
	
	@JsonProperty("temp_max")
	private float tempMax;

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public float getTempMin() {
		return tempMin;
	}

	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}

	public float getTempMax() {
		return tempMax;
	}

	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}
	
	
}
