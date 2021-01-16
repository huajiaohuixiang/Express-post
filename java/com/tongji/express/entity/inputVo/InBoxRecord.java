package com.tongji.express.entity.inputVo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "pack_in_ware")
public class InBoxRecord {

    @TableField(value = "package_ID")
    private String packageID;
    @TableField(value = "warehouse_ID")
    private String warehouseID;

    private String x;

    private String y;

    private String boxID;

    private String cupboardID;

    private String userID;

    @TableField("employee_ID")
    private String employeeID;

    private Date inDate;
    private Date outDate;

    private String status;

    private String code;

    private int flag;

}
