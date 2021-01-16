package com.tongji.express.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "EX_ORDER", schema = "TEST")
public class ExOrder {
    @Id
    @Column(name = "ORDER_ID")
    private String orderId;
    @Basic
    @Column(name = "SENDER_NAME")
    private String senderName;
    @Basic
    @Column(name = "SENDER_PHONE")
    private String senderPhone;
    @Basic
    @Column(name = "SENDER_ADDRESS")
    private String sendAddress;
    @Basic
    @Column(name = "COMPANY")
    private String company;

    @Basic
    @Column(name = "RECEIVER_NAME")
    private String receiverName;

    @Basic
    @Column(name = "RECEIVER_ADDRESS")
    private String receiverAddress;

    @Basic
    @Column(name = "RECEIVER_PHONE")
    private String receiverPhone;

    @Basic
    @Column(name = "PACKAGE_CONTENT")
    private String packageContent;

    @Basic
    @Column(name = "ORDER_DATE")
    private Time orderDate;

    @Basic
    @Column(name = "WEIGHT")
    private String weight;
    @Basic
    @Column(name = "STATUS")

    private String status;

    @Basic
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Basic
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "sender_name")
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Basic
    @Column(name = "SENDER_PHONE")
    public String getSendPhone() {
        return senderPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.senderPhone = sendPhone;
    }
    @Basic
    @Column(name = "SENDER_ADDRESS")
    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "receiver_name")
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Basic
    @Column(name = "RECEIVER_ADDRESS")
    public String getReceiverAddress() {
        return receiverAddress;
    }


    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    @Basic
    @Column(name = "RECEIVER_PHONE")
    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Basic
    @Column(name = "Package_Content")
    public String getPackageContent() {
        return packageContent;
    }

    public void setPackageContent(String packageContent) {
        this.packageContent = packageContent;
    }

    @Basic
    @Column(name = "order_date")
    public Time getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Time orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "employee_id")
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

        ExOrder exOrder = (ExOrder) o;

        if (orderId != null ? !orderId.equals(exOrder.orderId) : exOrder.orderId != null) return false;
        if (senderName != null ? !senderName.equals(exOrder.senderName) : exOrder.senderName != null) return false;
        if (senderPhone != null ? !senderPhone.equals(exOrder.senderPhone) : exOrder.senderPhone != null) return false;
        if (sendAddress != null ? !sendAddress.equals(exOrder.sendAddress) : exOrder.sendAddress != null) return false;
        if (company != null ? !company.equals(exOrder.company) : exOrder.company != null) return false;
        if (receiverName != null ? !receiverName.equals(exOrder.receiverName) : exOrder.receiverName != null)
            return false;
        if (receiverAddress != null ? !receiverAddress.equals(exOrder.receiverAddress) : exOrder.receiverAddress != null)
            return false;
        if (receiverPhone != null ? !receiverPhone.equals(exOrder.receiverPhone) : exOrder.receiverPhone != null)
            return false;
        if (packageContent != null ? !packageContent.equals(exOrder.packageContent) : exOrder.packageContent != null)
            return false;
        if (orderDate != null ? !orderDate.equals(exOrder.orderDate) : exOrder.orderDate != null) return false;
        if (weight != null ? !weight.equals(exOrder.weight) : exOrder.weight != null) return false;
        if (status != null ? !status.equals(exOrder.status) : exOrder.status != null) return false;
        if (employeeId != null ? !employeeId.equals(exOrder.employeeId) : exOrder.employeeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (senderName != null ? senderName.hashCode() : 0);
        result = 31 * result + (senderPhone != null ? senderPhone.hashCode() : 0);
        result = 31 * result + (sendAddress != null ? sendAddress.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        result = 31 * result + (receiverAddress != null ? receiverAddress.hashCode() : 0);
        result = 31 * result + (receiverPhone != null ? receiverPhone.hashCode() : 0);
        result = 31 * result + (packageContent != null ? packageContent.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        return result;
    }
}
