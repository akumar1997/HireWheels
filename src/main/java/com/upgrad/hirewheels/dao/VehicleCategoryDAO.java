package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDAO extends JpaRepository<VehicleCategory,Integer> {
}
