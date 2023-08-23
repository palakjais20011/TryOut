package com.app.service;

import java.util.List;
import com.app.entities.Package;

public interface TourPackageService {
	
	//List<Hotel> getAllHotels();
	List<Package> getAllTourPackage();

	Package addTourPackage(Package tourpackage);

	String deleteTourPackage(Long packageid);

	Package getTourPackageDetails(Long id);

	Package assignCityToPackage(Long packageId, Long cityId);
}