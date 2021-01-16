package com.tongji.express.mapper.worker;

import com.tongji.express.entity.inputVo.InBoxRecord;
import com.tongji.express.entity.inputVo.InWarehouseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface TracePackageMapper {

    @Select("select * from pack_in_ware where package_id=#{id}")
    InWarehouseRecord getWareRecord(@Param("id")String packageID);

    @Select("select * from package_out_ware where package_id=#{id}")
    InBoxRecord getBoxRecord(@Param("id") String packageID);
}
