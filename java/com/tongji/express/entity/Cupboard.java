package com.tongji.express.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cupboard {
    private String cupboardId;
    private String cupboardName;
    private long capacity;

    @Id
    @Column(name = "CUPBOARD_ID")
    public String getCupboardId() {
        return cupboardId;
    }

    public void setCupboardId(String cupboardId) {
        this.cupboardId = cupboardId;
    }

    @Basic
    @Column(name = "CUPBOARD_NAME")
    public String getCupboardName() {
        return cupboardName;
    }

    public void setCupboardName(String cupboardName) {
        this.cupboardName = cupboardName;
    }

    @Basic
    @Column(name = "CAPACITY")
    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cupboard cupboard = (Cupboard) o;

        if (capacity != cupboard.capacity) return false;
        if (cupboardId != null ? !cupboardId.equals(cupboard.cupboardId) : cupboard.cupboardId != null) return false;
        if (cupboardName != null ? !cupboardName.equals(cupboard.cupboardName) : cupboard.cupboardName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cupboardId != null ? cupboardId.hashCode() : 0;
        result = 31 * result + (cupboardName != null ? cupboardName.hashCode() : 0);
        result = 31 * result + (int) (capacity ^ (capacity >>> 32));
        return result;
    }
}
