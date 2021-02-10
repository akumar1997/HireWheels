package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Entity
public class VehicleSubCategory {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicle_subcategory_id;

    @Column(length = 50,nullable = false,unique = true)
    private String vehicle_subcategory_name;

    @Column(length = 10,nullable = false)
    private int cost_per_hour;

    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = false)
    private VehicleCategory vehicleCategory;

    @OneToMany(mappedBy = "vehicle_subcategory",fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<Vehicle> vehicles;

    public VehicleSubCategory(){}

    public VehicleSubCategory(int vehicle_subcategory_id, String vehicle_subcategory_name,
                              int cost_per_hour,VehicleCategory vehicleCategory) {
        this.vehicle_subcategory_id = vehicle_subcategory_id;
        this.vehicle_subcategory_name = vehicle_subcategory_name;
        this.cost_per_hour=cost_per_hour;
        this.vehicleCategory =  vehicleCategory;
    }


    public int getVehicle_subcategory_id() {
        return vehicle_subcategory_id;
    }

    public void setVehicle_subcategory_id(int vehicle_subcategory_id) {
        this.vehicle_subcategory_id = vehicle_subcategory_id;
    }

    public String getVehicle_subcategory_name() {
        return vehicle_subcategory_name;
    }

    public void setVehicle_subcategory_name(String vehicle_subcategory_name) {
        this.vehicle_subcategory_name = vehicle_subcategory_name;
    }

    public int getCost_per_hour() {
        return cost_per_hour;
    }

    public void setCost_per_hour(int cost_per_hour) {
        this.cost_per_hour = cost_per_hour;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = (vehicleCategory);
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


    @Override
    public String
    toString() {
        return "VehicleSubcategory{" +
                "vehicle_subcategory_id=" + vehicle_subcategory_id +
                ", vehicle_subcategory_name='" + vehicle_subcategory_name + '\'' +
                ", cost_per_hour=" + cost_per_hour +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }
}

