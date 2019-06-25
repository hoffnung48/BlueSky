package mx.com.bluesky.model.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Account
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class WeatherDto {

	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("desription")
	private List<String> description;
	
	@JsonProperty("tempCelsius")
	private float tempCelsius;
	
	@JsonProperty("tempFarenheit")
	private float tempFarenheit;
	
	@JsonProperty("sunrise")
	private Date sunrise;
	
	@JsonProperty("sunset")
	private Date sunset;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public float getTempCelsius() {
		return tempCelsius;
	}

	public void setTempCelsius(float tempCelsius) {
		this.tempCelsius = tempCelsius;
	}

	public float getTempFarenheit() {
		return tempFarenheit;
	}

	public void setTempFarenheit(float tempFarenheit) {
		this.tempFarenheit = tempFarenheit;
	}

	public Date getSunrise() {
		return sunrise;
	}

	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	public Date getSunset() {
		return sunset;
	}

	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

}
