package com.app.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HotelRespDTO {

	
	private Long hotelId;
	
	private String hotelName;

	private String hotelAddress;

	private double hotelPrice;
	
	private double hotelEarning;

	private boolean hotelActive;
	
}
