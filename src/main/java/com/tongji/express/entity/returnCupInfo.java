package com.tongji.express.entity;

public class returnCupInfo {
    private String cupboardId;
    private String cupboardName;
    private long capacity;
    private long left_capacity;

    public String getCupboardId() {
        return cupboardId;
    }

    public void setCupboardId(String cupboardId) {
        this.cupboardId = cupboardId;
    }

    public String getCupboardName() {
        return cupboardName;
    }

    public void setCupboardName(String cupboardName) {
        this.cupboardName = cupboardName;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getLeft_capacity() {
        return left_capacity;
    }

    public void setLeft_capacity(long left_capacity) {
        this.left_capacity = left_capacity;
    }
}
