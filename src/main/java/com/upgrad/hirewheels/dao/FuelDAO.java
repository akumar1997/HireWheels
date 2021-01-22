package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelDAO extends JpaRepository<Fuel,Integer> {
}
