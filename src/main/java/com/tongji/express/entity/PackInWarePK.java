package com.tongji.express.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PackInWarePK implements Serializable {
    private String packageId;
    private String warehouseId;

    @Column(name = "PACKAGE_ID")
    @Id
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Column(name = "WAREHOUSE_ID")
    @Id
    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackInWarePK that = (PackInWarePK) o;

        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (warehouseId != null ? !warehouseId.equals(that.warehouseId) : that.warehouseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        return result;
    }
}
