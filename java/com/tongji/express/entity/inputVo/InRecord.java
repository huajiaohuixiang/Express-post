package com.tongji.express.entity.inputVo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * created by kz on
 */
@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "PACK_IN_WARE")
public class InRecord {
    @TableField(value = "package_ID")
    private String packageID;
    @TableField(value = "warehouse_ID")
    private String warehouseID;
    @TableField(value = "employee_ID")
    private String employeeID;

    private Date inDate;

}
