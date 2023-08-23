package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.CityDTO;
import com.app.payload.MyApiResponse;
import com.app.service.CityService;


@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "http://localhost:3000")
public class CityController 
{
	@Autowired
	private CityService service;
	
	public CityController() 
	{
		System.out.println("inside city controller "+getClass());
	}
	
	//get all cities
	@GetMapping
	public ResponseEntity<?> listAllCities()
	{
		return ResponseEntity.ok(service.getAllCities());
	}
	
	@GetMapping("/{cId}")
	public ResponseEntity<?> getCityDetail(@PathVariable Long cId)
	{
		return ResponseEntity.ok(service.getCityDetails(cId));
	}
	
	@GetMapping("/{cId}/hotels")
	public ResponseEntity<?> getCityandHotelDetails(@PathVariable Long cId)
	{
		return ResponseEntity.ok(service.getCityAndHotelsDetails(cId));
	}
	
	//add new city
	@PostMapping
	public ResponseEntity<?> saveCity(@RequestBody @Valid CityDTO c)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCity(c));
	}
	
	@PutMapping("/updateCity/{id}")
	public MyApiResponse UpdatePackage(@PathVariable Long id,@RequestBody CityDTO city){
		return service.updateCity(id, city);
	}
	
	@DeleteMapping("/{cId}")
	public MyApiResponse removeCity(@PathVariable Long cId)
	{
		return service.deleteCity(cId);
	}
	
	
}
