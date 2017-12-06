package com.airport.repositories;

import com.airport.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * represents interface flight repository
 */
@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
}

