package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuelId;


    private String fuelType;

    public int getFuelId() {
        return fuelId;
    }

    public void setFuelId(int fuelId) {
        this.fuelId = fuelId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "fuelId=" + fuelId +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
