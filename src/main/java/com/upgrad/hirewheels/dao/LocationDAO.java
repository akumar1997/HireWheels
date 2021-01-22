package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO extends JpaRepository<Location,Integer> {
}
