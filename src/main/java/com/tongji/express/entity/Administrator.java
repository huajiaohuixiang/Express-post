package com.tongji.express.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ADMINISTRATOR", schema = "TEST")
public class Administrator {
    private String adminName;
    private String password;
    private String employeeId;

    @Id
    @Column(name = "ADMIN_NAME")
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "EMPLOYEE_ID")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(adminName, that.adminName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminName, password, employeeId);
    }
}
