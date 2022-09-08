package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.capg.entity.FlightBooking;


public interface FlightBookingRepository extends MongoRepository<FlightBooking,String>{
	

}
