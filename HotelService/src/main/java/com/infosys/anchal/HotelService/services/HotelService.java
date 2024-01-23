package com.infosys.anchal.HotelService.services;

import java.util.List;

import com.infosys.anchal.HotelService.entity.Hotel;

public interface HotelService {
	
	// get all hotels
	List<Hotel> getAllHotel();
	
	// get single hotel by given hotel id
	Hotel getHotel(String hotelId);
	
	// create a hotel
	Hotel createHotel(Hotel hotel);
	
	// update a hotel data
	Hotel updateHotel(String hotelId, Hotel hotel);
	
	// delete a hotel
	Boolean deleteHotel(String HotelId);
}
