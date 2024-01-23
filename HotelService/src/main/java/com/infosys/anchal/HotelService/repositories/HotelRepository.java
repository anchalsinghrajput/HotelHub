package com.infosys.anchal.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.anchal.HotelService.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
