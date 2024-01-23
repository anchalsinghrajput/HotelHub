package com.infosys.anchal.RatingService.controller;

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

import com.infosys.anchal.RatingService.entity.Rating;
import com.infosys.anchal.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating newRating = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
	}
	
	//get all rating
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating(){
		List<Rating> allRating = ratingService.getAllRating();
		return ResponseEntity.status(HttpStatus.OK).body(allRating);
	}
	
	
	//	get rating by specific id
	@GetMapping("/{ratingId}")
	public ResponseEntity<?> getRating(@PathVariable String ratingId){
		Rating rating = ratingService.getRatingById(ratingId);
		if(rating != null) {
			return ResponseEntity.status(HttpStatus.OK).body(rating);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating with given id not found !!");
	}
	
	
	//get all rating by userId
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getRatingByUserId(@PathVariable String userId){
		List<Rating> rating = ratingService.getAllRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(rating);
	}
	
	//get all rating by hotelId
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<?> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> rating = ratingService.getAllRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(rating);
	}
	

	//update rating
	@PutMapping("/{ratingId}")
	public ResponseEntity<?> updateRating(@PathVariable String ratingId, @RequestBody Rating rating){
		Rating updatedRating = ratingService.updateRating(ratingId, rating);
		if(updatedRating != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updatedRating);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The rating with given id not found");
	}
	
	//delete rating
	@DeleteMapping("/{ratingId}")
	public ResponseEntity<?> deleteRating(@PathVariable String ratingId){
		boolean deleteRating = ratingService.deleteRating(ratingId);
		if(deleteRating == true) {
			return ResponseEntity.status(HttpStatus.OK).body("The rating is successfully deleted");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The rating with given id not found");
	}
}
