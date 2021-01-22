package com.upgrad.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class fuel_type {
    @Id
    private int fuel_id;

    
    private String fuel_type;

    public int getFuel_id() {
        return fuel_id;
    }

    public void setFuel_id(int fuel_id) {
        this.fuel_id = fuel_id;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    @Override
    public String toString() {
        return "fuel_type{" +
                "fuel_id=" + fuel_id +
                ", fuel_type='" + fuel_type + '\'' +
                '}';
    }
}
