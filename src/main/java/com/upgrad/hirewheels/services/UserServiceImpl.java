package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UserDAO;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User createUser(User user) throws UserAlreadyExistsException {
        if (userDAO.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        if (userDAO.findByMobileNo(user.getMobileNo()) != null) {
            throw new UserAlreadyExistsException("Mobile Number Already Exists");
        }

        return userDAO.save(user);
    }


    @Override
    public User getUser(String emailId, String password) throws UserAlreadyExistsException {
        if (userDAO.findByEmail(emailId) != null) {
            if (userDAO.findByEmail(emailId).getPassword().equals(password)) {
                return userDAO.findByEmail(emailId);
            } else {
                throw new UserAlreadyExistsException("Unauthorized User");
            }
        } else {
            throw new UserAlreadyExistsException("User not Registered");
        }

    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDAO.findById(id)
                .orElseThrow(
                        () -> new UserDetailsNotFoundException("User not found for id: " + id)
                );
    }

    @Override
    public User getUserByEmail(String emailId ) throws UserDetailsNotFoundException {

        User user= userDAO.findByEmail(emailId);
        if(user==null)
            throw new UserDetailsNotFoundException("Invalid Token?EmailId");
        return user;

    }

    @Override
    public User getUserByMobileNo(String mobileNumber){
        return userDAO.findByMobileNo(mobileNumber);
    }



}

