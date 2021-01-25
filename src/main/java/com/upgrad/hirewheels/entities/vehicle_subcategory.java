package com.upgrad.hirewheels.entities;

import javax.persistence.*;

@Entity
public class vehicle_subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int typeId;

    @Column(nullable=false)
    private String typeName;

    public int getTypeId() {


        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
