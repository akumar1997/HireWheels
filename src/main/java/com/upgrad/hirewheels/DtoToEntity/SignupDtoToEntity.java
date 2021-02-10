package com.upgrad.hirewheels.DtoToEntity;

import com.upgrad.hirewheels.dto.SignUpDto;
import com.upgrad.hirewheels.entities.User;

import com.upgrad.hirewheels.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignupDtoToEntity {


    @Autowired
    RoleService roleService;

    public User convertor(SignUpDto signUpDto){
        User user=new User();
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setEmail(signUpDto.getEmailId());
        user.setMobileNo(signUpDto.getMobileNumber());
        user.setWallet(1000);
        user.setRole(roleService.findByRoleName("User"));
        user.setPassword(signUpDto.getPassword());
        return user;
    }
}
