package com.app.controller;

import java.util.List;

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
import com.app.entities.Package;
import com.app.service.TourPackageService;

@RestController
@RequestMapping("/tourpackage")
@CrossOrigin(origins = "*")
public class TourPackageController {

	@Autowired
	private TourPackageService tourPackageService;
	
	
	@GetMapping
	public ResponseEntity<?> listAllTourPackage(){
		List<Package> list= tourPackageService.getAllTourPackage();
		if(list==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTourPackageDetailsById(@PathVariable Long id) {
		
		Package n =tourPackageService.getTourPackageDetails(id);
		if(n==null)
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(n);
	}
	


	@PutMapping("/{packageId}/city/{cityId}")
	public Package assignCityToPackage(@PathVariable Long packageId ,
			@PathVariable Long cityId ) {
		
		
		return tourPackageService.assignCityToPackage(packageId,cityId);
				
				
	}	
	
	@PostMapping("/savePackage")
	public ResponseEntity<Package> saveHotel(@RequestBody Package tourPackage) {
		 tourPackageService.addTourPackage(tourPackage);
		 return new ResponseEntity<Package>(HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteTourPackage(@PathVariable Long id) {
		return tourPackageService.deleteTourPackage(id);

		
	}
}