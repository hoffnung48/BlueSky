package mx.com.bluesky.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class Wind {

	@JsonProperty("speed")
	private float speed;

	@JsonProperty("deg")
	private int deg;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

}
