package com.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.entities.City;
import com.app.entities.Hotel;
import com.app.payload.CityDTO;
import com.app.payload.CityHotelsDTO;
import com.app.payload.MyApiResponse;
import com.app.repository.CityDao;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	CityDao dao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<CityDTO> getAllCities() {
		List<City> list = dao.findAll();
		return list.stream()
				.map(city -> mapper.map(city,CityDTO.class)).collect(Collectors.toList());
	}
	
	@Override
	public CityDTO getCityDetails(Long cityId) {
		City city=dao.findById(cityId).
		orElseThrow(() -> new com.app.custom_exception.ResourceNotFoundException("Invalid city Id !!!!"));
		return mapper.map(city,CityDTO.class);
				
	}
	
	@Override
	public CityHotelsDTO getCityAndHotelsDetails(Long cityId) 
	{		
			City city = dao.getCityHotels(cityId);
			return mapper.map(city,CityHotelsDTO.class);
	}

	@Override
	public CityDTO addCity(CityDTO c) {
		City cityEntity = mapper.map(c, City.class);
		City persistentCity = dao.save(cityEntity);
		return mapper.map(persistentCity, CityDTO.class);
	}

	@Override
	public MyApiResponse deleteCity(Long cId) {
		City cc = dao.findById(cId).orElseThrow(() -> new com.app.custom_exception.ResourceNotFoundException("Invalid city id"));
		//dao.delete(rr);
		
		Iterator<Hotel> projectItr = cc.getHotel().iterator();
		while (projectItr.hasNext())
			cc.removeHotel(projectItr.next());
		
		dao.delete(cc);
		return new MyApiResponse("City deleted successfully!");
	}

//	private City getById(Long cId) {
//		return dao.findById(cId).orElseThrow(()-> new com.app.custom_exception.ResourceNotFoundException("Invalid Id"));
//	}

	@Override
	public MyApiResponse updateCity(Long cId, CityDTO city) {

		City needToUpdate =dao.findById(cId).orElseThrow(() -> new com.app.custom_exception.ResourceNotFoundException("City id not exists!"));
		mapper.map(city , needToUpdate);
		needToUpdate.setCityId(cId);;
		
		return new MyApiResponse("City updated successfully!");
	}

	

}
