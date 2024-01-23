package com.infosys.anchal.RatingService.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user_rating")
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;	
}
