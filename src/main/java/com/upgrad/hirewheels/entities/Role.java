package com.upgrad.hirewheels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    private int roleId;

    @Column(nullable = false)
    private String roleType;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "role{" +
                "roleId=" + roleId +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
