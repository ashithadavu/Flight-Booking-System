package com.capg.service;

import java.util.List;

import com.capg.dto.FlightDTO;
import com.capg.dto.SearchRequest;
//dto will connect entity to service
public interface FlightService {
	
	List<FlightDTO> getFlightByName(String name);

	List<FlightDTO> getFlightDetails(SearchRequest request);

	FlightDTO newFlight(FlightDTO flightDTO);

	List<FlightDTO> getFlights();

	FlightDTO updateFlight(Integer id, FlightDTO flightDTO);

	void deleteFlight(Integer id);

	void deleteAll();

	FlightDTO getFlight(Integer id);
	
}
