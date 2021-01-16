package com.tongji.express.entity.inputVo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.tongji.express.entity.inputVo.MyPackage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * created by kz on
 */
@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
public class InWarehouseRecord {

    @TableField(value = "warehouse_ID")
    private String warehouseID;
    @TableField(value = "employee_ID")
    private String employeeID;

    private Date  inDate;
    @TableField(value = "package_ID")
    private String packageID;
    private Date sendDate;
    private String senderAddress;
    private String senderPhone;
    private String senderName;
    private String company;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String packageContent;
    private double weight;
    private int status=1;

    public MyPackage getMyPackage(){
       MyPackage package1=new MyPackage();

       package1.setStatus(this.status);
       package1.setPackageID(this.packageID);
       package1.setCompany(this.company);
       package1.setPackageContent(this.packageContent);
       package1.setReceiverName(this.receiverName);
       package1.setReceiverPhone(this.receiverPhone);
       package1.setSendDate(this.sendDate);
       package1.setSenderName(this.senderName);
       package1.setSenderAddress(this.senderAddress);
       package1.setReceiverAddress(this.receiverAddress);
       package1.setWeight(this.weight);
       package1.setSenderPhone(this.senderPhone);
       return package1;
    }
}
