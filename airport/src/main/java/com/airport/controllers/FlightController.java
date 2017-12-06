package com.airport.controllers;

import com.airport.models.Flight;
import com.airport.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * setup Flight controller
 */
@RestController
@RequestMapping("api/flights/")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * post a new object
     * @param flight
     */
    @CrossOrigin
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Flight addFlight(@RequestBody Flight flight){ return flightRepository.save(flight); }

    /**
     * get all objects
     * @return
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public Iterable<Flight> getFlights() {
        return flightRepository.findAll();
    }

    /**
     * find one object
     * @param id
     * @return
     */
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public Flight getFlight(@PathVariable long id) {
        return flightRepository.findOne(id);
    }

    /**
     * edit one object
     * @param flight
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public void updateFlight(@RequestBody Flight flight){
        if(flight != null){
            Flight flightFromTable = flightRepository.findOne(flight.getId());
            if(flightFromTable != null){
                flightRepository.save(flight);
            }
        }
    }

    /**
     * delete object
     * @param flight
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }
}