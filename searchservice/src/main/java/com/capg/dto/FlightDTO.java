package com.capg.dto;
//connecting entity with service layer(layerd architecture)
public class FlightDTO {
	private String name;
	private int duration;
	private String departure;
	private String arrival;
	private int price;
	private String source;
	private String destination;
	private String date;
	private int availableSeats;
	
	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public FlightDTO() {
		
	}
	
	
	public FlightDTO(String name, int duration, String departure, String arrival, int price, String source,
			String destination, String date, int availableSeats) {
		super();
		this.name = name;
		this.duration = duration;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.availableSeats = availableSeats;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
