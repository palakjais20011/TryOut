package com.app.service;

import java.util.List;
import com.app.entities.Hotel;
import com.app.payload.AddHotelDTO;
import com.app.payload.HotelRespDTO;
import com.app.payload.MyApiResponse;

public interface HotelService {

	AddHotelDTO addHotel(AddHotelDTO h);

	List<Hotel> getAllHotels();

	MyApiResponse deleteHotel(Long hId);

	Hotel getById(Long hId);

	List<HotelRespDTO> getAllHotelsFromCity(Long cId);
	
	HotelRespDTO getHotelDetails(Long cId,Long hId);

	MyApiResponse updateHotel(Long hId, AddHotelDTO hotel);

}
