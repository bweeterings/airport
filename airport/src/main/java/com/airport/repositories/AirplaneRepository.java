package com.airport.repositories;

import com.airport.models.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * represents interface airplane repository
 */
@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}