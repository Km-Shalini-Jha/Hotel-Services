package com.icwd.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icwd.hotel.entities.Hotel;

@Repository
public interface HotelServiceRepository extends JpaRepository<Hotel, String>{

}
