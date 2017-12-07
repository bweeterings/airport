package com.airport.controllers;

import com.airport.models.Airplane;
import com.airport.repositories.AirplaneRepository;
import com.airport.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * setup Airplane controller
 */
@RestController
@RequestMapping("api/airplanes/")
public class AirplaneController {

    /**
     * connect to repository
     */
    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private FlightRepository flightRepository;

    /**
     * post a new airplane
     * @param airplane
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Airplane create(@RequestBody Airplane airplane){ return airplaneRepository.save(airplane); }

    /**
     * return all airplanes
     * @return
     */
    @RequestMapping(value="all", method= RequestMethod.GET)
    public Iterable<Airplane> index () {
        return airplaneRepository.findAll();
    }

    /**
     * return targeted airplane
     * @param id
     * @return
     */
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public Airplane getAirplane(@PathVariable long id) {
        return airplaneRepository.findOne(id);
    }

    /**
     * remove targeted airplane
     * @param airplane
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void deleteAirplane(Airplane airplane) {
        airplaneRepository.delete(airplane);
    }
}