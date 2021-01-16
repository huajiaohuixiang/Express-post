package com.tongji.express.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "PACK_IN_WARE", schema = "TEST")
@IdClass(PackInWarePK.class)
public class PackInWare {
    private String packageId;
    private String warehouseId;
    private String employeeId;
    private String inDate;

    @Id
    @Column(name = "PACKAGE_ID")
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Id
    @Column(name = "WAREHOUSE_ID")
    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "EMPLOYEE_ID")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "IN_DATE")
    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackInWare that = (PackInWare) o;

        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (warehouseId != null ? !warehouseId.equals(that.warehouseId) : that.warehouseId != null) return false;
        if (employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null) return false;
        if (inDate != null ? !inDate.equals(that.inDate) : that.inDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (inDate != null ? inDate.hashCode() : 0);
        return result;
    }
}
