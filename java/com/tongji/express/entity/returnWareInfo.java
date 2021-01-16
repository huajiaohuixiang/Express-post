package com.tongji.express.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

public class returnWareInfo {
    private String warehouseId;
    private String warehouseName;
    private String capacity;
    private int left_capacity;


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

    public int getLeft_capacity() {
        return left_capacity;
    }

    public void setLeft_capacity(int left_capacity) {
        this.left_capacity = left_capacity;
    }
}
