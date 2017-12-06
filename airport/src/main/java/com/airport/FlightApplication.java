package com.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}
	/**
	List<Flight> flights = new ArrayList<>();

	Airplane airplane1 = new Airplane(1,"Pickachu");

	Flight flight1 = new Flight(1, Origin, Destination);

	private void someHardCodedflights() {
		flights.add(flight1);
	}
 	*/

}
