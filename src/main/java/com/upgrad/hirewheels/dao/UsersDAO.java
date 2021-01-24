package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users,Integer> {
    //TODO 3.2: Providing Custom Query Methods for the UserDao Interface
    //

    //Write custom query methods inside the UserDao interface to find a user by his:

    //First name

    Users findByFirstName(String firstName);

    //First name or last name

    Users findByFirstNameOrLastName(String firstName,String lastName);

    //Email

    Users findByEmail(String email);

    //Mobile Number

    Users findByMobileNo(String mobileNo);
}
