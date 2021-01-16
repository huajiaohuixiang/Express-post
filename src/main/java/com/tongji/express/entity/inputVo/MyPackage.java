package com.tongji.express.entity.inputVo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * created by kz on
 */

@Data
@Repository
@Configuration
@TableName(value = "package")
public class MyPackage {

    @TableId(value = "package_ID")
    @NotEmpty
    private String packageID;
    private Date sendDate;
    private String senderAddress;
    @Length(min=11,max=11)
    private String senderPhone;
    private String senderName;
    private String company;
    private String receiverName;
    @Length(min=11,max=11)
    private String receiverPhone;
    private String receiverAddress;
    private String packageContent;
    private double weight;
    private String receiveDate;
    private int status=1;
    private String code;
    private String x;
    private String y;
    private String cupboardID;


    public MyPackage(){}

}
