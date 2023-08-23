package com.app.service;

import java.util.List;

import com.app.payload.CityDTO;
import com.app.payload.CityHotelsDTO;
import com.app.payload.MyApiResponse;

public interface CityService {

	List<CityDTO> getAllCities();

	CityDTO addCity(CityDTO c);

	MyApiResponse deleteCity(Long cId);

	CityDTO getCityDetails(Long cityId);
	
	CityHotelsDTO getCityAndHotelsDetails(Long cityId);

	MyApiResponse updateCity(Long id, CityDTO city);


}
