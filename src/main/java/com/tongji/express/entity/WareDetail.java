package com.tongji.express.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "WAREDETAILS")
public class WareDetail {

    @TableField(value = "package_ID")
    private String packageID;
    @TableField(value = "warehouse_ID")
    private String warehouseID;

}
