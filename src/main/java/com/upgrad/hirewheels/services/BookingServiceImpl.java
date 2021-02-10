package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.BookingDAO;

import com.upgrad.hirewheels.dao.UserDAO;

import com.upgrad.hirewheels.entities.Booking;

import com.upgrad.hirewheels.entities.User;
import com.upgrad.hirewheels.exceptions.BookingDetailsNotFoundException;
import com.upgrad.hirewheels.exceptions.UserDetailsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingDAO bookingDao;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserDAO userDao;



    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return bookingDao.findById(id)
                .orElseThrow(
                        () -> new BookingDetailsNotFoundException("Booking not found for id: " + id)
                );
    }


    @Override
    public Booking addBooking(Booking booking)throws Exception, BookingDetailsNotFoundException, UserDetailsNotFoundException {
        User user=userService.getUserDetails((booking.getUser().getUserId()));

                  if(user.getWallet()-booking.getAmount()>0){
                      user.setWallet(user.getWallet()-booking.getAmount());
                      userDao.save(user);
                      return bookingDao.save(booking);
                  }
                  throw new Exception("Insufficient Balance. Please Check With Admin");
    }
}
