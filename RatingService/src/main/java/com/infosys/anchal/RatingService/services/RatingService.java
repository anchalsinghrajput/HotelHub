package com.infosys.anchal.RatingService.services;

import java.util.List;

import com.infosys.anchal.RatingService.entity.Rating;

public interface RatingService {
	
	//create rating
	Rating createRating(Rating rating);
	
	//get all rating
	List<Rating> getAllRating();
	
	//get single rating with RatingId
	Rating getRatingById(String ratingId);
	
	//get all by userId
	List<Rating> getAllRatingByUserId(String userId);
	
	//get all by hotelId
	List<Rating> getAllRatingByHotelId(String hotelId);

	//update rating
	Rating updateRating(String ratingId, Rating rating);
	
	//delete rating
	Boolean deleteRating(String ratingId);
}
