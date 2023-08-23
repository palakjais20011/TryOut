package com.app.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.City;
import com.app.entities.Package;
import com.app.repository.CityDao;
import com.app.repository.TourPackageDao;


@Service
@Transactional

public class TourPackageServiceImpl implements TourPackageService {

	
	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private TourPackageDao tourPackageDao;
	

	@Override
	public Package addTourPackage(Package tourpackage) {
	
		return tourPackageDao.save(tourpackage);
	}

	@Override
	public String deleteTourPackage(Long packageid) {
		tourPackageDao.deleteById(packageid);
		return "Package deleted sucessfully";
	}

	@Override
	public List<Package> getAllTourPackage() {
	
		return tourPackageDao.findAll();
	}

	@Override
	public Package getTourPackageDetails(Long id) {
		
		//TourPackage tap= tourPackageDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Package ID!!!"));
	return  tourPackageDao.findById(id).orElse(null);
	}

	@Override
	public Package assignCityToPackage(Long packageId, Long cityId) {
		List<City> cities=null;
		
		Package tourpackage = tourPackageDao.findById(packageId).get();
		City city= cityDao.findById(cityId).get();	
		cities=tourpackage.getCity();
		cities.add(city);
		tourpackage.setCity(cities);
		
		return tourPackageDao.save(tourpackage);
	}
	

}