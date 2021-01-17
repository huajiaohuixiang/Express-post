package com.tongji.express.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by kz on
 */
@Data
@NoArgsConstructor
public class CouponStore {
    @TableId
    private String batchID;
    @TableField
    private int num;
}
