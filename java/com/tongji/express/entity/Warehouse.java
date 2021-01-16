package com.tongji.express.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Warehouse {
    @Id
    @Column(name = "WAREHOUSE_ID")
    private String warehouseId;

    @Basic
    @Column(name = "WAREHOUSE_NAME")
    private String warehouseName;

    @Basic
    @Column(name = "CAPACITY")
    private String capacity;


    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }


    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (warehouseId != null ? !warehouseId.equals(warehouse.warehouseId) : warehouse.warehouseId != null)
            return false;
        if (warehouseName != null ? !warehouseName.equals(warehouse.warehouseName) : warehouse.warehouseName != null)
            return false;
        if (capacity != null ? !capacity.equals(warehouse.capacity) : warehouse.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = warehouseId != null ? warehouseId.hashCode() : 0;
        result = 31 * result + (warehouseName != null ? warehouseName.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }
}
