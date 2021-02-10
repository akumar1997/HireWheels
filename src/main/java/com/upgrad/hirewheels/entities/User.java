package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(length=50,nullable = false)
    private String firstName;

    @Column(length=50)
    private String lastName;

    @Column(length = 50,nullable = false)
    private String password;

    @Column(length = 50,nullable = false,unique = true)
    private String email;

    @Column(length = 10,nullable = false,unique = true)
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(length = 10,nullable = false)
    private int wallet;


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER , cascade = {CascadeType.ALL})
    private Set<Booking> bookings;

    public User(){}

    public User(int userId,String firstName, String lastName, String password, String email, String mobileNo, int wallet, Object role) {
        this.userId = userId;
        this.firstName=firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mobileNo = mobileNo;
        this.wallet = wallet;
        this.role = (Role)role;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", role=" + role +
                ", wallet=" + wallet +
                '}';
    }
}
