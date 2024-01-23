package com.infosys.anchal.UserService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.infosys.anchal.UserService.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/user/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);
	
//	@PostMapping("/ratings")
//	Rating createRating(Rating rating);
//
//	@PutMapping("/ratings/{ratingId}")
//	Rating updateRating(String ratingId, Rating rating);
}
