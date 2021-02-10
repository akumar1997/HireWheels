package com.upgrad.hirewheels.controllers;

import com.upgrad.hirewheels.dto.VehicleDto;
import com.upgrad.hirewheels.entities.Vehicle;
import com.upgrad.hirewheels.exceptions.VehicleDetailsNotFoundException;
import com.upgrad.hirewheels.services.VehicleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/hirewheels/v1")
public class VehicleController {

        @Autowired
        VehicleServiceImpl vehicleService;

        @Autowired
        ModelMapper modelmapper;

        @GetMapping(value = "/getV",produces= MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity getVehicles(@RequestParam("categoryName") String categoryName,
                                          @RequestParam("pickupDate") ChronoLocalDate pickupDate,
                                          @RequestParam("dropoffDate") ChronoLocalDate dropoffDate,
                                          @RequestParam("locationId") int locationId)
                throws VehicleDetailsNotFoundException {


                if (categoryName == null || pickupDate == null || dropoffDate == null || locationId <= 0) {
                        List<Vehicle> vehicles = vehicleService.getAllVehicles();
                        List<VehicleDto> vehicleDtos = new ArrayList<>();
                        for (Vehicle vehicle : vehicles) {
                                vehicleDtos.add(modelmapper.map(vehicle, VehicleDto.class));
                        }

                        return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);
                }
                Set<Vehicle> vehicles = vehicleService.getAvailableVehicles(categoryName, locationId, pickupDate, dropoffDate);
                List<VehicleDto> vehicleDtos = new ArrayList<>();
                for (Vehicle vehicle : vehicles) {
                        vehicleDtos.add(modelmapper.map(vehicle, VehicleDto.class));
                }

                return new ResponseEntity<>(vehicleDtos, HttpStatus.OK);


        }
}
