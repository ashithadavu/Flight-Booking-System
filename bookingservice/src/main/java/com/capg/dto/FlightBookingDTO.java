package com.capg.dto;

import java.time.LocalDateTime;

import com.capg.entity.FlightInfo;

public class FlightBookingDTO {
	private String id;
	private String flightId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String phoneNumber;
	private int requiredNumberOfSeats;
	private FlightInfo flightInfo;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	
public FlightBookingDTO() {
		
	}


public FlightBookingDTO(String id, String flightId, String firstName, String lastName, String gender, String email,
		String phoneNumber, int requiredNumberOfSeats, FlightInfo flightInfo, LocalDateTime createdTime,
		LocalDateTime updatedTime) {
	super();
	this.id = id;
	this.flightId = flightId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.requiredNumberOfSeats = requiredNumberOfSeats;
	this.flightInfo = flightInfo;
	this.createdTime = createdTime;
	this.updatedTime = updatedTime;
}


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getFlightId() {
	return flightId;
}

public void setFlightId(String flightId) {
	this.flightId = flightId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public int getRequiredNumberOfSeats() {
	return requiredNumberOfSeats;
}

public void setRequiredNumberOfSeats(int requiredNumberOfSeats) {
	this.requiredNumberOfSeats = requiredNumberOfSeats;
}

public FlightInfo getFlightInfo() {
	return flightInfo;
}

public void setFlightInfo(FlightInfo flightInfo) {
	this.flightInfo = flightInfo;
}

public LocalDateTime getCreatedTime() {
	return createdTime;
}

public void setCreatedTime(LocalDateTime createdTime) {
	this.createdTime = createdTime;
}

public LocalDateTime getUpdatedTime() {
	return updatedTime;
}

public void setUpdatedTime(LocalDateTime updatedTime) {
	this.updatedTime = updatedTime;
}
	
	
	
	
	
	

}
