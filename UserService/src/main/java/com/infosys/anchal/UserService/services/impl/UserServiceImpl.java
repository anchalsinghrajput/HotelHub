package com.infosys.anchal.UserService.services.impl;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.anchal.UserService.entities.Hotel;
import com.infosys.anchal.UserService.entities.Rating;
import com.infosys.anchal.UserService.entities.User;
import com.infosys.anchal.UserService.exceptions.ResourceNotFoundException;
import com.infosys.anchal.UserService.external.services.HotelService;
import com.infosys.anchal.UserService.external.services.RatingService;
import com.infosys.anchal.UserService.repositories.UserRepository;
import com.infosys.anchal.UserService.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
		
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

//	@Override
//	public User getUser(String userId) {
//		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id " + userId + " is not found on server !!"));
//		//fetch rating of the above user from rating service
//		String url = "http://RATING-SERVICE/ratings/user/" + user.getUserId();
//		Rating[] ratingsOfUser = restTemplate.getForObject(url, Rating[].class);
//		
//		//		user.setRatings(Arrays.asList(ratingsOfUser));
//		
//		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//		
//		List<Rating> ratingList = ratings.stream().map(rating-> {
//			String urlForRating = "http://HOTEL-SERVICE/hotels/" + rating.getHotelId();
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(urlForRating, Hotel.class);
//			Hotel hotel = forEntity.getBody();
//			rating.setHotel(hotel);
//			return rating;
//		}).collect(Collectors.toList());
//		
//		user.setRatings(ratingList);
//
//		return user;
//	}

	@Override
	public User getUser(String userId) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User with given id " + userId + " is not found on the server!"));

	        List<Rating> ratingsOfUser = ratingService.getRatingsByUserId(user.getUserId());

	        ratingsOfUser.forEach(rating -> {
	            Hotel hotel = hotelService.getHotelByHotelId(rating.getHotelId());
	            rating.setHotel(hotel);
	        });

	        user.setRatings(ratingsOfUser);
	        return user;
	}
	
	@Override
	public User updateUser(String userId, User curUser) {
		Optional<User> optionalExistingUser = userRepository.findById(userId);
		if(optionalExistingUser.isPresent()) {
			User existingUser = optionalExistingUser.get();
			existingUser.setName(curUser.getName());
			existingUser.setEmail(curUser.getEmail());
			existingUser.setAbout(curUser.getAbout());
			return userRepository.save(existingUser);
		}
        throw new ResourceNotFoundException("User with ID " + userId + " not found.");
	} 

	@Override
	public boolean deleteUser(String userId) {
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return true;
		}
		return false;
	}

}
