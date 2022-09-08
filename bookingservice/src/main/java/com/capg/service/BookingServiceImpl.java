package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.FlightBookingDTO;
import com.capg.entity.FlightBooking;
import com.capg.repository.FlightBookingRepository;
import com.capg.transformer.FlightBookingTransformer;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private FlightBookingRepository repository;
	
	@Autowired
	private FlightBookingTransformer transformer;

	@Override
	public FlightBookingDTO book(FlightBookingDTO flightBookingDTO) {
		
		FlightBooking booking = transformer.transform(flightBookingDTO);
		repository.save(booking);
		return flightBookingDTO;
	}

	@Override
	public List<FlightBookingDTO> getBookingDetails() {
		// TODO Auto-generated method stub
		List<FlightBooking> bookingDetails= repository.findAll();
		List<FlightBookingDTO> dtos = transformer.transform(bookingDetails);
		return dtos;
	}

	@Override
	public FlightBookingDTO getBookingDetailsById(String id) {
		// TODO Auto-generated method stub
		Optional<FlightBooking> bookingDetail= repository.findById(id);
		if(bookingDetail.isPresent()) {
		  FlightBookingDTO bookingDTO=transformer.transform(bookingDetail.get());
		  return bookingDTO;
		}
		return null;
	}

	@Override
	public FlightBookingDTO updateBookingDetails(String id, FlightBookingDTO bookingDetailsDTO) {
		// TODO Auto-generated method stub
		Optional<FlightBooking> bookingDetail = repository.findById(id);
		if(bookingDetail.isPresent()) {
			FlightBooking flightbooking  = transformer.transform(bookingDetailsDTO,bookingDetail.get());
			repository.save(flightbooking);
			return bookingDetailsDTO;
		}
		
		return null;
	}

	@Override
	public void deleteBookingDetailsById(String id) {
		Optional<FlightBooking> bookingDetail=repository.findById(id);
		if(bookingDetail.isPresent()) {
			repository.delete(bookingDetail.get());
		}
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		repository.deleteAll();
		
	}

}
