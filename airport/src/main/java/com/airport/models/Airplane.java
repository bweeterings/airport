package com.airport.models;

import com.airport.enumerations.PlaneType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * pojo class for Airplane
 */
@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @NotNull
    private PlaneType planeType;

    @NotNull
    private int fuelCurrent;
    private int fuelCapacity = 5000;

    public Airplane() {}

    public Airplane(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Airplane(long id, String name, PlaneType planeType, int fuelCurrent, int fuelCapacity) {
        this.id = id;
        this.name = name;
        this.planeType = planeType;
        this.fuelCurrent = fuelCurrent;
        this.fuelCapacity = fuelCapacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public int getFuelCurrent() {
        return fuelCurrent;
    }

    public void setFuelCurrent(int fuelCurrent) {
        this.fuelCurrent = fuelCurrent;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
