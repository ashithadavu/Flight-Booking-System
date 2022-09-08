package com.capg.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.dto.FlightDTO;
import com.capg.entity.FlightInfo;

@Component
public class FlightTransformer {
	
	public FlightDTO transform(FlightInfo flightInfo) {
		
		FlightDTO dto = new FlightDTO();
		dto.setDate(flightInfo.getDate());
		dto.setArrival(flightInfo.getArrival());
		dto.setDeparture(flightInfo.getDeparture());
		dto.setDestination(flightInfo.getDestination());
		dto.setSource(flightInfo.getSource());
		dto.setName(flightInfo.getName());
		dto.setPrice(flightInfo.getPrice());
		dto.setAvailableSeats(flightInfo.getAvailableSeats());
		return dto;
		
	}
	
	public List<FlightDTO> transform(List<FlightInfo> flightInfos){
		List<FlightDTO> flightDetails = new ArrayList();
		for(FlightInfo info : flightInfos) {
			FlightDTO flightDto = transform(info);
			flightDetails.add(flightDto);
		}
		
		return flightDetails;
		
	}

}
