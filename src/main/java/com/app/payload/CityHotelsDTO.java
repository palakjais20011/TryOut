package com.app.payload;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.app.entities.Hotel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CityHotelsDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long cityId;
	@NotBlank
	@JsonProperty(value = "cityName")
	private String cityName;
	@Min(value = 100000)
	@Max(value = 999999)
	private int cityPin;
	@NotBlank
	private String cityState;
	@NotBlank
	private String cityCountry;
	List<Hotel> hotel = new ArrayList<Hotel>();
}
