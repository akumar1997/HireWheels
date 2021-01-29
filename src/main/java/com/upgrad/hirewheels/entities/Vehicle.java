package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicle_id;

    @Column(nullable = false)
    private String vehicle_model;

    @Column(nullable = false, unique = true
    )
    private int vehicle_number;

    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_id" , nullable = false)
    private VehicleSubcategory vehicle_subcategory;

    @Column(nullable = false)
    private String vehicle_color;

    @ManyToOne
    @JoinColumn(name = "location_id",nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable = false)
    private FuelType fuelType;

    @Column(nullable = false)
    private boolean availabilityStatus;

    @Column(nullable = false)
    private String image;


    @OneToMany(mappedBy = "vehicle",fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<Booking> bookings;

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public int getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(int vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public VehicleSubcategory getVehicle_subcategory() {
        return vehicle_subcategory;
    }

    public void setVehicle_subcategory(VehicleSubcategory vehicle_subcategory) {
        this.vehicle_subcategory = vehicle_subcategory;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_number=" + vehicle_number +
                ", vehicle_subcategory=" + vehicle_subcategory +
                ", vehicle_color='" + vehicle_color + '\'' +
                ", location=" + location +
                ", fuelType=" + fuelType +
                ", availabilityStatus=" + availabilityStatus +
                ", image='" + image + '\'' +
                '}';
    }
}

