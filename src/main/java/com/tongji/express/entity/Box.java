package com.tongji.express.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Box {
    @Id
    @Column(name = "BOX_ID")
    private String boxId;

    @Basic
    @Column(name = "CUPBOARD_ID")
    private String cupboardId;
    @Basic
    @Column(name = "TYPE")
    private String type;

    @Basic
    @Column(name = "COLY")
    private String coly;

    @Basic
    @Column(name = "ROWX")
    private String rowx;

    @Basic
    @Column(name = "STATE")
    private String state;

    @Basic
    @Column(name = "PACKAGE_ID")
    private String packageId;


    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }


    public String getCupboardId() {
        return cupboardId;
    }

    public void setCupboardId(String cupboardId) {
        this.cupboardId = cupboardId;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getColy() {
        return coly;
    }

    public void setColy(String coly) {
        this.coly = coly;
    }


    public String getRowx() {
        return rowx;
    }

    public void setRowx(String rowx) {
        this.rowx = rowx;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (boxId != null ? !boxId.equals(box.boxId) : box.boxId != null) return false;
        if (cupboardId != null ? !cupboardId.equals(box.cupboardId) : box.cupboardId != null) return false;
        if (type != null ? !type.equals(box.type) : box.type != null) return false;
        if (coly != null ? !coly.equals(box.coly) : box.coly != null) return false;
        if (rowx != null ? !rowx.equals(box.rowx) : box.rowx != null) return false;
        if (state != null ? !state.equals(box.state) : box.state != null) return false;
        if (packageId != null ? !packageId.equals(box.packageId) : box.packageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = boxId != null ? boxId.hashCode() : 0;
        result = 31 * result + (cupboardId != null ? cupboardId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (coly != null ? coly.hashCode() : 0);
        result = 31 * result + (rowx != null ? rowx.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        return result;
    }
}
