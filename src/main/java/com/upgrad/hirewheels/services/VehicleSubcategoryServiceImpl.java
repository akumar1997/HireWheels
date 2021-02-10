package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleSubCategoryDAO;

import com.upgrad.hirewheels.entities.VehicleSubCategory;

import com.upgrad.hirewheels.exceptions.VehicleSubcategoryDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleSubcategoryServiceImpl implements VehicleSubcategoryService{

    @Autowired
    VehicleSubCategoryDAO vehicleSubcategoryDao;

    @Override
    public VehicleSubCategory getVehicleSubcategoryDetails(int id) throws VehicleSubcategoryDetailsNotFoundException {
        return vehicleSubcategoryDao.findById(id)
                .orElseThrow(
                        () -> new VehicleSubcategoryDetailsNotFoundException("VehicleSubcategory not found for id: " + id)
                );
    }
}
