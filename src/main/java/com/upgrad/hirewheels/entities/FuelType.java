package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FuelType {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuelTypeId;

    @Column(length = 50,nullable = false, unique = true)
    private String fuelType;

    @OneToMany(mappedBy = "fuelType",fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public FuelType(){}

    public FuelType(int fuelTypeId, String fuelType) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
    }


    public int getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(int fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "fuelId=" + fuelTypeId +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
