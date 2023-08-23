package com.app.controller;

import java.util.List;

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
import com.app.payload.AddHotelDTO;
import com.app.payload.HotelRespDTO;
import com.app.payload.MyApiResponse;
import com.app.service.HotelService;


@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController 
{
	@Autowired
	private HotelService service;
	
	@GetMapping("/cities/{cId}")
	public ResponseEntity<?> getHotelByCity(@PathVariable Long cId)
	{
		List<HotelRespDTO> list=service.getAllHotelsFromCity(cId);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<?> addHotelInCity(@RequestBody @Valid AddHotelDTO h)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addHotel(h));
	}
	
	@PutMapping("/updateHotel/{id}")
	public MyApiResponse UpdatePackage(@PathVariable Long id,@RequestBody AddHotelDTO hotel){
		return service.updateHotel(id, hotel);
	}
	
	@DeleteMapping("/{hId}")
	public MyApiResponse deleteHotel(@PathVariable Long hId)
	{
		return service.deleteHotel(hId);
	}
	
	
}
