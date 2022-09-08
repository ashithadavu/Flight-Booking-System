package com.capg.service;

import java.util.List;

import com.capg.dto.FlightBookingDTO;

public interface BookingService {
	public FlightBookingDTO book(FlightBookingDTO flightBookingDTO);
	public  List<FlightBookingDTO> getBookingDetails();
	public FlightBookingDTO getBookingDetailsById(String id);
	public FlightBookingDTO updateBookingDetails(String id,FlightBookingDTO bookingDetailsDTO);
	public void deleteBookingDetailsById(String id);
	public void deleteAll();
}
