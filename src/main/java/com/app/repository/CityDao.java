package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.City;

public interface CityDao extends JpaRepository<City,Long>{

	@Query("select c from City c left join fetch c.hotel where c.id=?1")
	City getCityHotels(Long cityId);

}
