package com.infosys.anchal.RatingService.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.infosys.anchal.RatingService.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
}
