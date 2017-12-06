package com.airport.models;

import com.airport.enumerations.PlaneType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @NotNull
    @OneToOne
    private PlaneType planeType;

    @NotNull
    private int fuelCurrent;
    private int fuelCapacity = 5000;

    public Airplane() {}



    public Airplane(long id, String name) {
        this.id = id;
        this.name = name;
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
}
