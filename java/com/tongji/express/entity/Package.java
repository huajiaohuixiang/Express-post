package com.tongji.express.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class Package {
    private String packageId;
    private Time sendDate;
    private String sendAddress;
    private String senderName;
    private String senderPhone;
    private String exCompany;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private Time receiveDate;
    private String packageContent;

    @Id
    @Column(name = "PACKAGE_ID")
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "SEND_DATE")
    public Time getSendDate() {
        return sendDate;
    }

    public void setSendDate(Time sendDate) {
        this.sendDate = sendDate;
    }

    @Basic
    @Column(name = "SEND_ADDRESS")
    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    @Basic
    @Column(name = "SENDER_NAME")
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Basic
    @Column(name = "SENDER_PHONE")
    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    @Basic
    @Column(name = "EX_COMPANY")
    public String getExCompany() {
        return exCompany;
    }

    public void setExCompany(String exCompany) {
        this.exCompany = exCompany;
    }

    @Basic
    @Column(name = "RECEIVER_NAME")
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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
    @Column(name = "RECEIVER_ADDRESS")
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    @Basic
    @Column(name = "RECEIVE_DATE")
    public Time getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Time receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Basic
    @Column(name = "PACKAGE_CONTENT")
    public String getPackageContent() {
        return packageContent;
    }

    public void setPackageContent(String packageContent) {
        this.packageContent = packageContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (packageId != null ? !packageId.equals(aPackage.packageId) : aPackage.packageId != null) return false;
        if (sendDate != null ? !sendDate.equals(aPackage.sendDate) : aPackage.sendDate != null) return false;
        if (sendAddress != null ? !sendAddress.equals(aPackage.sendAddress) : aPackage.sendAddress != null)
            return false;
        if (senderName != null ? !senderName.equals(aPackage.senderName) : aPackage.senderName != null) return false;
        if (senderPhone != null ? !senderPhone.equals(aPackage.senderPhone) : aPackage.senderPhone != null)
            return false;
        if (exCompany != null ? !exCompany.equals(aPackage.exCompany) : aPackage.exCompany != null) return false;
        if (receiverName != null ? !receiverName.equals(aPackage.receiverName) : aPackage.receiverName != null)
            return false;
        if (receiverPhone != null ? !receiverPhone.equals(aPackage.receiverPhone) : aPackage.receiverPhone != null)
            return false;
        if (receiverAddress != null ? !receiverAddress.equals(aPackage.receiverAddress) : aPackage.receiverAddress != null)
            return false;
        if (receiveDate != null ? !receiveDate.equals(aPackage.receiveDate) : aPackage.receiveDate != null)
            return false;
        if (packageContent != null ? !packageContent.equals(aPackage.packageContent) : aPackage.packageContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId != null ? packageId.hashCode() : 0;
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + (sendAddress != null ? sendAddress.hashCode() : 0);
        result = 31 * result + (senderName != null ? senderName.hashCode() : 0);
        result = 31 * result + (senderPhone != null ? senderPhone.hashCode() : 0);
        result = 31 * result + (exCompany != null ? exCompany.hashCode() : 0);
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        result = 31 * result + (receiverPhone != null ? receiverPhone.hashCode() : 0);
        result = 31 * result + (receiverAddress != null ? receiverAddress.hashCode() : 0);
        result = 31 * result + (receiveDate != null ? receiveDate.hashCode() : 0);
        result = 31 * result + (packageContent != null ? packageContent.hashCode() : 0);
        return result;
    }
}
