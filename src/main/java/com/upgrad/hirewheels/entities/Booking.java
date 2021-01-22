package com.upgrad.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    private int bookingId;


    private LocalDate pickupDate;


    private LocalDate dropoffDate;


    private LocalDate bookingDate;


    private int bookingAmount;

//    @Column(nullable=false)
//    private int location_id;
//
//    @Column(nullable=false)
//    private int vehicle_id;
//
//    @Column(nullable=false)
//    private int user_id;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int booking_id) {
        this.bookingId = booking_id;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickup_date) {
        this.pickupDate = pickup_date;
    }

    public LocalDate getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(LocalDate dropoff_date) {
        this.dropoffDate = dropoff_date;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate booking_date) {
        this.bookingDate = booking_date;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int booking_amount) {
        this.bookingAmount = booking_amount;
    }

//    public int getLocation_id() {
//        return location_id;
//    }
//
//    public void setLocation_id(int location_id) {
//        this.location_id = location_id;
//    }
//
//    public int getVehicle_id() {
//        return vehicle_id;
//    }
//
//    public void setVehicle_id(int vehicle_id) {
//        this.vehicle_id = vehicle_id;
//    }
//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }

    @Override
    public String toString() {
        return "booking{" +
                "booking_id=" + bookingId +
                ", pickup_date=" + pickupDate +
                ", dropoff_date=" + dropoffDate +
                ", booking_date=" + bookingDate +
                ", booking_amount=" + bookingAmount +
//                ", location_id=" + location_id +
//                ", vehicle_id=" + vehicle_id +
//                ", user_id=" + user_id +
                '}';
    }
}
