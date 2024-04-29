package com.icwd.hotel.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.exceptions.ResourceNotFoundException;
import com.icwd.hotel.repositories.HotelServiceRepository;

@Service
public class HotelServices {
	
	@Autowired
	private HotelServiceRepository hotelServiceRepository;
	
	// create hotel
	public Hotel createHotel(Hotel hotel){	
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelServiceRepository.save(hotel);		
	}
	
	// getAll Hotel
	public List<Hotel> getAllHotel(){
		return hotelServiceRepository.findAll();		
	}
	
	// get single hotel
	public Optional<Hotel> getSingleHotel(String hotelId) throws ResourceNotFoundException{
		
		Optional<Hotel> hotel = hotelServiceRepository.findById(hotelId);
		if(ObjectUtils.isEmpty(hotel)) {			
			throw new ResourceNotFoundException("hotelId with given id is not available at server !! "+hotelId);	
			
		}else {
			return hotel;
		}		
	}

}
