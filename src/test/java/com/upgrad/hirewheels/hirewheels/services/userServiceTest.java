package com.upgrad.hirewheels.hirewheels.services;

import com.upgrad.hirewheels.dao.RoleDAO;

import com.upgrad.hirewheels.dao.UserDAO;

import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.services.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class userServiceTest {
    @Mock
    UserDAO usersDao;

    @Mock
    RoleDAO roleDao;


    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    public void setUpMockito(){

        Role role=new Role(1,"save test");

        User u1=new User(1,"save test","save test","save test",
                "save test1","save test1",10, role);
        User u2=new User(2,"save test","save test","save test",
                "save test2","save test2",10,
                role);

        User user=u1;
        Mockito.when(usersDao.save(user)).thenReturn(u1);
        Mockito.when(usersDao.save(u1)).thenReturn(u1);
        Mockito.when(usersDao.findById(1)).thenReturn(Optional.of(u1));

        Mockito.when(usersDao.findByMobileNo("save test1")).thenReturn(u1);

        Mockito.when(usersDao.findByEmail("save test1")).thenReturn(u1);

    }

    @Test
    public void testCreateUser() throws UserAlreadyExistsException {
        Role role=new Role();
        role.setRoleName("save test");
        User u1= new User();
        u1.setFirstName("save test");
        u1.setWallet(10);
        u1.setPassword("save test");
        u1.setRole(role);
        u1.setMobileNo("save test");
        u1.setEmail("save test");
        u1.setLastName("save test");

        User savedUser= userService.createUser(u1);
        System.out.println(savedUser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserId() != 0);
        Assertions.assertEquals("save test", savedUser.getFirstName());
        Assertions.assertEquals("save test", savedUser.getLastName());
        Assertions.assertEquals("save test1", savedUser.getPassword());
        Assertions.assertEquals("save test1", savedUser.getEmail());
        Assertions.assertEquals("save test1", savedUser.getMobileNo());
        Assertions.assertEquals(10, savedUser.getWallet());
        Assertions.assertEquals("save test", savedUser.getRole().getRoleName());

    }
    @Test
    public void testGetUser() throws UserAlreadyExistsException {
        User getUser= userService.getUser("save test1", "save test");

        Assertions.assertNotNull(getUser);
        Assertions.assertTrue(getUser.getUserId() != 0);
        Assertions.assertEquals("save test", getUser.getFirstName());
        Assertions.assertEquals("save test", getUser.getLastName());
        Assertions.assertEquals("save test", getUser.getPassword());
        Assertions.assertEquals("save test1", getUser.getEmail());
        Assertions.assertEquals("save test1", getUser.getMobileNo());
        Assertions.assertEquals(10, getUser.getWallet());
        Assertions.assertEquals("save test", getUser.getRole().getRoleName());

    }


}
