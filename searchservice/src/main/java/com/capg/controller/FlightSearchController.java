package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.FlightDTO;
import com.capg.dto.SearchRequest;
import com.capg.dto.SearchResponce;
import com.capg.service.FlightService;


@RestController
@CrossOrigin
@RequestMapping("/flights")
public class FlightSearchController {

	@Autowired
	private FlightService service;
	
	 @PostMapping("/create")
	    public ResponseEntity<FlightDTO> createFlight(@Valid @RequestBody FlightDTO flightDTO) {
	        return new ResponseEntity<FlightDTO>(service.newFlight(flightDTO), HttpStatus.CREATED);
	    }

	    @GetMapping("/getAll")
	    public List<FlightDTO> flights(){
	        return service.getFlights();
	    }

	    @GetMapping("/get/{id}")
	    public FlightDTO flightById(@PathVariable Integer id) {
	        return service.getFlight(id);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<FlightDTO> update(@PathVariable Integer id, @Valid @RequestBody FlightDTO flightDTO) {
	        return new ResponseEntity<FlightDTO>(service.updateFlight(id, flightDTO), HttpStatus.ACCEPTED);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String delete(@PathVariable Integer id) {
	        service.deleteFlight(id);
	        return "Flight with ID: " + id + " was deleted successfully";
	    }

	    @DeleteMapping("/deleteAll")
	    public String deleteAll() {
	        service.deleteAll();
	        return "All flights were deleted successfully";
	    }
	    
	    @GetMapping( "/details")
		public List<FlightDTO> getFlightDetails(@RequestParam("origin")String origin,@RequestParam("destination")String destination) {
	    	SearchRequest request = new SearchRequest(origin, destination);
			List<FlightDTO> details=service.getFlightDetails(request);
			return details;
		}
		
		@GetMapping("/{name}")
		public SearchResponce getFlightDetailsByName(@PathVariable("name")String name) {
			List<FlightDTO> details=service.getFlightByName(name);
			SearchResponce responce=new SearchResponce();
			responce.setFlightdetails(details);
			return responce;
			
		}
		
		
		@GetMapping( "/hello")
		public String getFlightDetails() {
			return "WELCOME TO FLIGHT BOOKING SYSTEM";
		}
		
		
	}


