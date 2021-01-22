package com.upgrad.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class vehicle {
    @Id
    private int vehicle_id;

    @Column(nullable = false)
    private String vehicle_model;

    @Column(nullable = false, unique = true
    )
    private int vehicle_number;

//    @Column(nullable = false)
//    private int type_id;

//    @Column(nullable = false)
//    private int category_id;

    @Column(nullable = false)
    private String vehicle_color;

//    @Column(nullable = false)
//    private int location_id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int price_per_day;
//
//    @Column(nullable = false)
//    private int fuel_id;

    @Column(nullable = false)
    private boolean availability;

    @Override
    public String toString() {
        return "vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_number=" + vehicle_number +
//                ", type_id=" + type_id +
//                ", category_id=" + category_id +
                ", vehicle_color='" + vehicle_color + '\'' +
//                ", location_id=" + location_id +
                ", image='" + image + '\'' +
                ", price_per_day=" + price_per_day +
//                ", fuel_id=" + fuel_id +
                ", availability=" + availability +
                '}';
    }
}
