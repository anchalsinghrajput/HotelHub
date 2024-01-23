package com.infosys.anchal.RatingService.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.anchal.RatingService.entity.Rating;
import com.infosys.anchal.RatingService.repositories.RatingRepository;
import com.infosys.anchal.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRatingById(String ratingId) {
		return ratingRepository.findById(ratingId).get();
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public Rating updateRating(String ratingId, Rating rating) {
		Optional<Rating> existRating = ratingRepository.findById(ratingId);
		if(existRating.isPresent()) {
			Rating curRating = existRating.get();
			curRating.setUserId(rating.getUserId());
			curRating.setHotelId(rating.getHotelId());
			curRating.setFeedback(rating.getFeedback());
			curRating.setRating(rating.getRating());
			ratingRepository.save(curRating);
			return curRating;
		}
		return null;
	}

	@Override
	public Boolean deleteRating(String ratingId) {
		Optional<Rating> existRating = ratingRepository.findById(ratingId);
		if(existRating.isPresent()) {
			ratingRepository.deleteById(ratingId);
			return true;
		}
		return false;
	}

}
