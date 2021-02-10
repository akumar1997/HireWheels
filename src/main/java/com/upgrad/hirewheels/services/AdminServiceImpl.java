package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.VehicleDAO;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    VehicleDAO vehicleDao;

    @Override
    public Vehicle getVehicleDetails(int id) throws VehicleDetailsNotFoundException {
        return vehicleDao.findById(id)
                .orElseThrow(
                        () -> new VehicleDetailsNotFoundException("Vehicle not found for id: " + id)
                );
    }
    @Override
    public Vehicle registerVehicle(Vehicle vehicle){
        vehicle.setAvailabilityStatus(false);
        return vehicleDao.save(vehicle);

    }

    @Override
    public Vehicle changeAvailability(Vehicle vehicle, boolean status) throws VehicleDetailsNotFoundException{
        Vehicle savedVehicle = getVehicleDetails(vehicle.getVehicle_id());
        savedVehicle.setAvailabilityStatus(status);
        return vehicleDao.save(savedVehicle);
    }
}
