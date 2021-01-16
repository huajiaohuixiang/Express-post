package com.tongji.express.mapper.worker;

import com.tongji.express.entity.inputVo.InBoxRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface InsertBoxRecordMapper {

    @Insert("insert into package_out_ware(package_ID,warehouse_ID,out_date,employee_ID,box_ID)" +
            "values(#{packageID,jdbcType=VARCHAR},#{warehouseID,jdbcType=VARCHAR},#{inDate,jdbcType=DATE}," +
            "#{employeeID,jdbcType=VARCHAR},#{boxID,jdbcType=VARCHAR})")
    int insert(InBoxRecord inBoxRecord);
}
