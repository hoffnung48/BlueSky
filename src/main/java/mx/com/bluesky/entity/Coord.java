package mx.com.bluesky.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
public class Coord {
	
	@JsonProperty("lon")
	private float longotide;
	
	@JsonProperty("lat")
	private float lattitude;

	public float getLongotide() {
		return longotide;
	}

	public void setLongotide(float longotide) {
		this.longotide = longotide;
	}

	public float getLattitude() {
		return lattitude;
	}

	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	
	
	
}
