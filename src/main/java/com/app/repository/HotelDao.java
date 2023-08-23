package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Long> {

	 List<Hotel> findByCityCityId(Long cId);
}
