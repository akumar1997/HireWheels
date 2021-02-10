package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class VehicleCategory {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_category_id")
    private int vehicleCategoryId;

    @Column(length = 50,name = "vehicle_category_name", nullable = false)
    private String vehicleCategoryName;

    @OneToMany(mappedBy = "vehicleCategory",fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<VehicleSubCategory> vehicleSubCategories;

    public VehicleCategory(){}

    public VehicleCategory(int vehicleCategoryId, String vehicleCategoryName) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.vehicleCategoryName = vehicleCategoryName;
    }


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

    public Set<VehicleSubCategory> getVehicleSubCategories() {
        return vehicleSubCategories;
    }

    public void setVehicleSubCategories(Set<VehicleSubCategory> vehicleSubCategories) {
        this.vehicleSubCategories = vehicleSubCategories;
    }


    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleCategoryId=" + vehicleCategoryId +
                ", vehicleCategoryName='" + vehicleCategoryName + '\'' +
                '}';
    }
}

