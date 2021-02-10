package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.VehicleSubCategory;

import com.upgrad.hirewheels.exceptions.VehicleSubcategoryDetailsNotFoundException;

public interface VehicleSubcategoryService {

    public VehicleSubCategory getVehicleSubcategoryDetails(int id) throws VehicleSubcategoryDetailsNotFoundException;
    }
