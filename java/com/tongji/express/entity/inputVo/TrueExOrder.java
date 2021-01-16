package com.tongji.express.entity.inputVo;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * created by kz on
 */
@Data
@Repository
@Configuration
@EntityScan
public class TrueExOrder {

    private int orderID;
    private String senderPhone;
    private String company;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String packageContent;
    private Date orderDate;
    public double weight;
    public String employeeID;
    private String status="未分配";
    private  int intStatus;

}
