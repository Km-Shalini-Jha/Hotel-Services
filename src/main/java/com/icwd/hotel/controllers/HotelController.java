package com.icwd.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.icwd.hotel.entities.Hotel;
import com.icwd.hotel.exceptions.ResourceNotFoundException;
import com.icwd.hotel.payload.ApiResponseClass;
import com.icwd.hotel.services.HotelServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/hotel",produces = "application/json")
public class HotelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelServices hotelServices;
	
	@PostMapping("/saveHotel")
	public ResponseEntity<ApiResponseClass> createHotel(@RequestBody Hotel hotel){
		Hotel createdHotel = hotelServices.createHotel(hotel);
		return 	new ResponseEntity<>(new ApiResponseClass("true",createdHotel,"Data saved successfully"),HttpStatus.CREATED);	
	}
	
	@GetMapping("/getAllHotel")
	public ResponseEntity<ApiResponseClass> getAllHotel(){
		logger.info("getAllHotel being called...");
		List<Hotel> list = hotelServices.getAllHotel();
		return new ResponseEntity<>(new ApiResponseClass("true",list,"List of All Hotel"),HttpStatus.OK);
	}
	
	@GetMapping("/getSingleHotel")
	public ResponseEntity<ApiResponseClass> getHotel(@RequestParam("hotelId") String hotelId) throws ResourceNotFoundException{
		Optional<Hotel> ht = hotelServices.getSingleHotel(hotelId);
		return new ResponseEntity<>(new ApiResponseClass("true",ht,"hotel data"),HttpStatus.OK);		
	}
	
}
