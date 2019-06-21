package mx.com.bluesky.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class Sys {

	@JsonProperty("type")
	private int type;

	@JsonProperty("id")
	private int id;

	@JsonProperty("message")
	private String message;

	@JsonProperty("country")
	private String country;

	@JsonProperty("sunrise")
	private long sunrise;

	@JsonProperty("sunset")
	private long sunset;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getSunrise() {
		return sunrise;
	}

	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	public void setSunset(long sunset) {
		this.sunset = sunset;
	}

}
