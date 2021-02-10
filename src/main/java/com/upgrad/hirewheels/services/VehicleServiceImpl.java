package com.upgrad.hirewheels.services;


import com.upgrad.hirewheels.dao.BookingDAO;
import com.upgrad.hirewheels.dao.VehicleCategoryDAO;

import com.upgrad.hirewheels.dao.VehicleDAO;

import com.upgrad.hirewheels.dao.VehicleSubCategoryDAO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleDAO vehicleDao;

    @Autowired
    VehicleCategoryDAO vehicleCategoryDao;

    @Autowired
    VehicleSubCategoryDAO vehicleSubcategoryDao;

    @Autowired
    BookingDAO bookingDao;

    @Override
    public List<Vehicle> getAllVehicles(){

        return vehicleDao.findAll();
    }

    public Set<Vehicle> getAvailableVehicles(String category, int locationId, ChronoLocalDate pickupDate,
                                              ChronoLocalDate dropoffDate){

        List<Vehicle> vehicles=vehicleDao.findAll();

        Set<Vehicle> availableVehicles=new HashSet<>();
        List<Vehicle> av=new ArrayList<>();

        for(Vehicle v: vehicles){

            if(v.isAvailabilityStatus()==true){

                if(v.getVehicle_subcategory().getVehicleCategory().getVehicleCategoryName().equals(category)){
                    if(v.getLocation().getLocationId()==locationId){
                        av.add(v);
                              }
                }
            }
        }
        for(Vehicle v1:av) {
            List<Booking> bookings = bookingDao.findByVehicle(v1);
            for(Booking b: bookings){
                if(b.getPickupDate().compareTo(pickupDate)<0 && b.getDropoffDate().compareTo(pickupDate)<0){
                    availableVehicles.add(v1);


                }
                else if(b.getPickupDate().compareTo(pickupDate)>0 && b.getPickupDate().compareTo(dropoffDate)>0){
                    availableVehicles.add(v1);
                }
            }

        }

        for(Vehicle vehicle: av){
            availableVehicles.add(vehicle);
        }
        return availableVehicles;


    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleDao.save(vehicle);
    }

    @Override
    public  Vehicle getVehicleDetails(int id) throws VehicleDetailsNotFoundException {
        return vehicleDao.findById(id)
                .orElseThrow(
                        () -> new VehicleDetailsNotFoundException("Vehicle not found for id: " + id)
                );
    }

}
