package com.infosys.anchal.HotelService.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	
	@Id
	private String hotelId;
	private String name;
	private String location;
	private String about;
}
