package com.capg.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capg.entity.FlightInfo;
//mongo repository is a built in class
//inheritance concept:extends
public interface FlightRepository extends MongoRepository<FlightInfo,String>{
	/*
	 * @Query("{date:'?0'}") List<FlightInfo> findFlightByDate(String date);
	 * 
	 * @Query("{source:'?0',destination:'?1'}") List<FlightInfo>
	 * findFlightBySourceDestination(String source, String destination);
	 * 
	 * @Query("{name:'?0'}") List<FlightInfo> findFlightByName(String name);
	 * 
	 * @Query("{:'?0'}") List<FlightInfo> findAll();
	 * 
	 *
	 */
	 @Query("{source:'?0',destination:'?1'}") List<FlightInfo> findFlight(String source,String destination);

}
