package com.airport.models;

import com.airport.enumerations.Destination;
import com.airport.enumerations.Origin;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    private Airplane airplane;

    @NotNull
    private Origin origin;
    @NotNull
    private Destination destination;

    private int fuelCost = 2000;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Flight() {}

    public Flight(long id, Airplane airplane, Origin origin, Destination destination, LocalDate startDate, LocalDate endDate, int fuelCost) {
        this.id = id;
        this.airplane = airplane;
        this.origin = origin;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fuelCost = fuelCost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(int fuelCost) {
        this.fuelCost = fuelCost;
    }
}