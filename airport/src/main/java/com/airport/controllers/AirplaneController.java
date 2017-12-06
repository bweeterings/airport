package com.airport.controllers;

import com.airport.models.Airplane;
import com.airport.repositories.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/airplanes/")
public class AirplaneController {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Airplane create(@RequestBody Airplane airplane){ return airplaneRepository.save(airplane); }

    @RequestMapping(value="all", method= RequestMethod.GET)
    public Iterable<Airplane> index () {
        return airplaneRepository.findAll();
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public Airplane getAirplane(@PathVariable long id) {
        return airplaneRepository.findOne(id);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public void deleteAirplane(Airplane airplane) {
        airplaneRepository.delete(airplane);
    }
}