package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_category_id")
    private int vehicleCategoryId;

    @Column(name = "vehicle_category_name", nullable = false)
    private String vehicleCategoryName;

    @OneToMany(mappedBy = "vehicleCategory",fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<VehicleSubcategory> vehicleSubcategories;


    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public Set<VehicleSubcategory> getVehicleSubcategories() {
        return vehicleSubcategories;
    }

    public void setVehicleSubcategories(Set<VehicleSubcategory> vehicleSubcategories) {
        this.vehicleSubcategories = vehicleSubcategories;
    }


    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", vehicleCategoryName='" + vehicleCategoryName + '\'' +
                '}';
    }
}

