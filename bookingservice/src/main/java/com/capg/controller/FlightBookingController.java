package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.FlightBookingDTO;
import com.capg.service.BookingService;

@RestController
@RequestMapping("/booking")
public class FlightBookingController {
	
@Autowired
private BookingService bookingService;

@PostMapping("/book")
public ResponseEntity<FlightBookingDTO> bookFlight( @RequestBody FlightBookingDTO flightBookingDTO) {
	System.out.print(flightBookingDTO.toString());
    return new ResponseEntity<FlightBookingDTO>(bookingService.book(flightBookingDTO), HttpStatus.CREATED);
}

@GetMapping("/getAll")
public List<FlightBookingDTO> bookingDetails() {
    return bookingService.getBookingDetails();
}

@GetMapping("/get/{id}")
public FlightBookingDTO bookingDetailsById(@PathVariable String id) {
    return bookingService.getBookingDetailsById(id);
}

@PutMapping("/update/{id}")
public ResponseEntity<FlightBookingDTO> update(@PathVariable String id, @RequestBody FlightBookingDTO bookingDetailsDTO) {
    return new ResponseEntity<FlightBookingDTO>(bookingService.updateBookingDetails(id, bookingDetailsDTO), HttpStatus.ACCEPTED);
}

@DeleteMapping("/delete/{id}")
public String delete(@PathVariable String id) {
    bookingService.deleteBookingDetailsById(id);
    return "Booking details with ID: " + id + " was deleted successfully";
}

@DeleteMapping("/deleteAll")
public String deleteAll() {
    bookingService.deleteAll();
    return "All booking data was deleted successfully";
}
}

