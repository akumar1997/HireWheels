package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class initServiceImpl implements initService{
    @Autowired
    RoleDAO roleDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    VehicleCategoryDAO vehicleCategoryDAO;

    @Autowired
    VehicleSubCategoryDAO vehicleSubCategoryDAO;

    @Autowired
    CityDAO cityDAO;

    @Autowired
    FuelTypeDAO fuelTypeDAO;

    @Autowired
    LocationDAO locationDAO;

//    @Autowired
//    DTOEntityConverter dtoEntityConverter;

    public void start() {
        addUserRole();
        addUsers();
        addVehicleCategory();
        addVehicleSubCategory();
        addCity();
        addFuelType();
        addLocation();
    }

    private void addCity() {
        City c=new City();
        c.setCityId(1);
        c.setCityName("Mumbai");
        cityDAO.save(c);
    }

    private void addLocation() {
        Location location1 = new Location();
        location1.setCity(cityDAO.findById(1));
        location1.setLocationId(1);
        location1.setLocationName("Worli");
        location1.setAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location1.setPincode(400018);


        locationDAO.save(location1);

        Location location2 = new Location();
        location2.setCity(cityDAO.findById(1));
        location2.setLocationId(2);
        location2.setLocationName("Chembur");
        location2.setAddress("Optic Complex");
        location2.setPincode(400019);

        locationDAO.save(location2);

        Location location3 = new Location();
        location3.setCity(cityDAO.findById(6));
        location3.setLocationId(3);
        location3.setLocationName("Powai");
        location3.setAddress("Hiranandani Tower");
        location3.setPincode(400017);

        locationDAO.save(location3);
    }

    private void addFuelType() {

        FuelType f1=new FuelType();
        f1.setFuelTypeId(1);
        f1.setFuelType("Petrol");
        fuelTypeDAO.save(f1);

        FuelType f2=new FuelType();
        f1.setFuelTypeId(2);
        f2.setFuelType("Diesel");
        fuelTypeDAO.save(f2);
    }

    private void addVehicleCategory() {

        VehicleCategory vc1=new VehicleCategory();
        vc1.setVehicleCategoryId(3);
        vc1.setVehicleCategoryName("CAR");
        vehicleCategoryDAO.save(vc1);

        VehicleCategory vc2=new VehicleCategory();
        vc2.setVehicleCategoryId(4);
        vc2.setVehicleCategoryName("BIKE");
        vehicleCategoryDAO.save(vc2);
    }

    private void addVehicleSubCategory() {


        VehicleSubCategory vs1=new VehicleSubCategory();
        vs1.setVehicleCategory(vehicleCategoryDAO.findById(3).get());
        vs1.setVehicle_subcategory_id(111);
        vs1.setVehicle_subcategory_name("SUV");
        vs1.setCost_per_hour(300);

        vehicleSubCategoryDAO.save(vs1);

        VehicleSubCategory vs2=new VehicleSubCategory();
        vs2.setVehicleCategory(vehicleCategoryDAO.findById(3).get());
        vs2.setVehicle_subcategory_id(112);
        vs2.setVehicle_subcategory_name("SEDAN");
        vs2.setCost_per_hour(350);

        vehicleSubCategoryDAO.save(vs2);

        VehicleSubCategory vs3=new VehicleSubCategory();
        vs3.setVehicleCategory(vehicleCategoryDAO.findById(3).get());
        vs3.setVehicle_subcategory_id(113);
        vs3.setVehicle_subcategory_name("HATCHBACK");
        vs3.setCost_per_hour(250);

        vehicleSubCategoryDAO.save(vs3);

        VehicleSubCategory vs4=new VehicleSubCategory();
        vs4.setVehicleCategory(vehicleCategoryDAO.findById(4).get());
        vs4.setVehicle_subcategory_id(114);
        vs4.setVehicle_subcategory_name("CRUISER");
        vs4.setCost_per_hour(200);

        vehicleSubCategoryDAO.save(vs4);

        VehicleSubCategory vs5=new VehicleSubCategory();
        vs5.setVehicleCategory(vehicleCategoryDAO.findById(4).get());
        vs5.setVehicle_subcategory_id(115);
        vs5.setVehicle_subcategory_name("DIRT BIKE");
        vs5.setCost_per_hour(200);

        vehicleSubCategoryDAO.save(vs5);

        VehicleSubCategory vs6=new VehicleSubCategory();
        vs6.setVehicleCategory(vehicleCategoryDAO.findById(4).get());
        vs6.setVehicle_subcategory_id(116);
        vs6.setVehicle_subcategory_name("SPORTS BIKE");
        vs6.setCost_per_hour(150);

        vehicleSubCategoryDAO.save(vs6);

    }

    private void addUserRole() {

        Role r1=new Role();
        r1.setRoleId(1);
        r1.setRoleName("Admin");
        roleDAO.save(r1);

        Role r2=new Role();
        r2.setRoleId(2);
        r2.setRoleName("User");
        roleDAO.save(r2);


    }

    private void addUsers() {

        User u=new User();
        u.setUserId(1);
        u.setRole(roleDAO.findById(1));
        u.setWallet(10000);
        u.setPassword("admin@123");
        u.setMobileNo("9876543212");
        u.setEmail("admin@gmail.com");
        u.setFirstName("Arnav");
        u.setLastName("Admin");
        userDAO.save(u);

    }



}
