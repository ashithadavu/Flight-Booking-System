package com.capg.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.dto.FlightBookingDTO;
import com.capg.entity.FlightBooking;

@Component
public class FlightBookingTransformer {

	public FlightBookingDTO transform(FlightBooking flightbooking) {

		FlightBookingDTO dto = new FlightBookingDTO();
		dto.setFirstName(flightbooking.getFirstName());
		dto.setLastName(flightbooking.getLastName());
		dto.setGender(flightbooking.getGender());
		dto.setEmail(flightbooking.getEmail());
		dto.setPhoneNumber(flightbooking.getPhoneNumber());
		dto.setRequiredNumberOfSeats(flightbooking.getRequiredNumberOfSeats());
		dto.setFlightInfo(flightbooking.getFlightInfo());
		dto.setCreatedTime(flightbooking.getCreatedTime());
		dto.setUpdatedTime(flightbooking.getUpdatedTime());
		return dto;

	}

	public List<FlightBookingDTO> transform(List<FlightBooking> flightInfos) {
		List<FlightBookingDTO> flightDetails = new ArrayList();
		for (FlightBooking info : flightInfos) {
			FlightBookingDTO flightDto = transform(info);
			flightDetails.add(flightDto);
		}

		return flightDetails;

	}

	public FlightBooking transform(FlightBookingDTO flightbookingdto) {

		FlightBooking flightbooking = new FlightBooking();
		flightbooking.setFirstName(flightbookingdto.getFirstName());
		flightbooking.setLastName(flightbookingdto.getLastName());
		flightbooking.setGender(flightbookingdto.getGender());
		flightbooking.setEmail(flightbookingdto.getEmail());
		flightbooking.setPhoneNumber(flightbookingdto.getPhoneNumber());
		flightbooking.setRequiredNumberOfSeats(flightbookingdto.getRequiredNumberOfSeats());
		flightbooking.setFlightInfo(flightbookingdto.getFlightInfo());
		flightbooking.setCreatedTime(flightbookingdto.getCreatedTime());
		flightbooking.setUpdatedTime(flightbookingdto.getUpdatedTime());
		return flightbooking;

	}
	
	public FlightBooking transform(FlightBookingDTO flightbookingdto,FlightBooking flightbooking) {

		flightbooking.setFirstName(flightbookingdto.getFirstName());
		flightbooking.setLastName(flightbookingdto.getLastName());
		flightbooking.setGender(flightbookingdto.getGender());
		flightbooking.setEmail(flightbookingdto.getEmail());
		flightbooking.setPhoneNumber(flightbookingdto.getPhoneNumber());
		flightbooking.setRequiredNumberOfSeats(flightbookingdto.getRequiredNumberOfSeats());
		flightbooking.setFlightInfo(flightbookingdto.getFlightInfo());
		flightbooking.setCreatedTime(flightbookingdto.getCreatedTime());
		flightbooking.setUpdatedTime(flightbookingdto.getUpdatedTime());
		return flightbooking;

	}
}
