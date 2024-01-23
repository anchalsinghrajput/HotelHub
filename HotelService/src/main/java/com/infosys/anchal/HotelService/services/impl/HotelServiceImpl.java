package com.infosys.anchal.HotelService.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.anchal.HotelService.entity.Hotel;
import com.infosys.anchal.HotelService.exception.ResourceNotFoundException;
import com.infosys.anchal.HotelService.repositories.HotelRepository;
import com.infosys.anchal.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}

	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(String hotelId, Hotel hotel) {
		Optional<Hotel> optionalExistingHotel = hotelRepository.findById(hotelId);
		if(optionalExistingHotel.isPresent()) {
			Hotel existingHotel = optionalExistingHotel.get();
			existingHotel.setName(hotel.getName());
			existingHotel.setLocation(hotel.getLocation());
			existingHotel.setAbout(hotel.getAbout());
			return hotelRepository.save(existingHotel);
		}
		return null;
	}

	@Override
	public Boolean deleteHotel(String hotelId) {
		Optional<Hotel> optionalExistingHotel = hotelRepository.findById(hotelId);
		if(optionalExistingHotel.isPresent()) {
			hotelRepository.deleteById(hotelId);
			return true;
		}
		return false;
	}

}
