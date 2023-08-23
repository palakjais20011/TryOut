package com.app.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entities.City;
import com.app.entities.Hotel;
import com.app.payload.AddHotelDTO;
import com.app.payload.HotelRespDTO;
import com.app.payload.MyApiResponse;
import com.app.repository.CityDao;
import com.app.repository.HotelDao;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hDao;
	
	@Autowired
	CityDao cDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Hotel> getAllHotels() {
		return hDao.findAll();
	}
	
	@Override
	public AddHotelDTO addHotel(AddHotelDTO dto) 
	{
			City cc = cDao.findById(dto.getCityId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid city id"));
			
			Hotel hh = mapper.map(dto, Hotel.class);
			cc.addHotel(hh);
			return mapper.map(hDao.save(hh), AddHotelDTO.class);

	}
	
	@Override
	public Hotel getById(Long hId) {
			
		return hDao.findById(hId).orElseThrow(()-> new com.app.custom_exception.ResourceNotFoundException("Invalid Id"));
	}

	@Override
	public List<HotelRespDTO> getAllHotelsFromCity(Long cId) {
		List<Hotel> Hotel=hDao.findByCityCityId(cId);
		return Hotel.stream().map(hotel -> mapper.map(hotel,HotelRespDTO.class)).collect(Collectors.toList());
	}

	@Override
	public HotelRespDTO getHotelDetails(Long cId, Long hId) {
		Hotel hh =hDao.findById(hId).orElseThrow(() -> new ResourceNotFoundException("Invalid hotel id!"));
		
		if(hh.getCity().getCityId() != cId)
			throw new ResourceNotFoundException("Dept id does not match!");
		return mapper.map(hh, HotelRespDTO.class);
	}
	
	@Override
	public MyApiResponse deleteHotel(Long hId) {
		Hotel hh = hDao.findById(hId).orElseThrow(() -> new ResourceNotFoundException("Hotel id not found!"));
		hDao.delete(hh);
		return new MyApiResponse("Hotel deleted successfully!");
	}
	
	@Override
	public MyApiResponse updateHotel(Long hId, AddHotelDTO hotel) {

		Hotel needToUpdate =hDao.findById(hId).orElseThrow(() -> new com.app.custom_exception.ResourceNotFoundException("City id not exists!"));
		mapper.map(hotel , needToUpdate);
		needToUpdate.setHotelId(hId);
		
		return new MyApiResponse("City updated successfully!");
	}
	

}
