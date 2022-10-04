package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.FlightDTO;
import com.capg.dto.SearchRequest;
import com.capg.entity.FlightInfo;
import com.capg.repository.FlightRepository;
import com.capg.transformer.FlightTransformer;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired // injecting the depenndency
	private FlightRepository flightRepository;//private fields because outside the methods
	
	@Autowired
	private FlightTransformer transformer;
	
	@Override
	public List<FlightDTO> getFlightDetails(SearchRequest request) {
		
		  // TODO Auto-generated method stub List<FlightInfo>
		System.out.println(request.getSource());
		System.out.println(request.getDestination());
		List<FlightInfo> flightDetails=flightRepository.findFlight(request.getSource(),request.getDestination());
		List<FlightDTO> flightDto=transformer.transform(flightDetails);
		 
		return flightDto;
	}
	
	@Override
	public List<FlightDTO> getFlightByName(String name) {
		/*
		 * // TODO Auto-generated method stub List<FlightInfo>
		 * flightDetails=flightRepository.findFlightByName(name); List<FlightDTO>
		 * flightDto=transformer.transform(flightDetails);
		 */
		return null;
	}

	@Override
	public FlightDTO newFlight(FlightDTO flightDTO) {
		return null;
	}

	@Override
	public List<FlightDTO> getFlights() {
		List<FlightInfo> flights = flightRepository.findAll();
		List<FlightDTO> flightDto=transformer.transform(flights);
		return flightDto;
	}

	@Override
	public FlightDTO updateFlight(Integer id, FlightDTO flightDTO) {
		return null;
	}

	@Override
	public void deleteFlight(Integer id) {
		
	}

	@Override
	public void deleteAll() {
		flightRepository.deleteAll();
	}

	@Override
	public FlightDTO getFlight(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
