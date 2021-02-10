package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User,Integer> {
    //TODO 3.2: Providing Custom Query Methods for the UserDao Interface
    //

    public List<User> findByFirstName(String firstName);

    public List<User> findByFirstNameOrLastName(String firstName, String lastName);

    public User findByMobileNo(String mobileNumber);

    public User findByEmail(String emailId);

}
