package com.infosys.anchal.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.anchal.HotelService.entity.Hotel;
import com.infosys.anchal.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createdHotel = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
	}
	
	//get single
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	//get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotels = hotelService.getAllHotel();
		return ResponseEntity.status(HttpStatus.OK).body(hotels);
	}
	
	//update hotels data
	@PutMapping("/{hotelId}")
	public ResponseEntity<?> updateHotel(@PathVariable String hotelId,@RequestBody Hotel hotel){
		Hotel updateHotel = hotelService.updateHotel(hotelId, hotel);
		if(updateHotel != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updateHotel);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hotel not found");

	}
	
	//delete hotel with given id
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<?> deleteHotel(@PathVariable String hotelId){
		Boolean deleted = hotelService.deleteHotel(hotelId);
		if(deleted) {
			return ResponseEntity.status(HttpStatus.OK).body("Hotel deleted successfully !!");

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not found");

	}
	
}
