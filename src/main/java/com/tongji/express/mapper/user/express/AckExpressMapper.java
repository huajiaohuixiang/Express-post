package com.tongji.express.mapper.user.express;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface AckExpressMapper {

    @Update("update package set status=0,receive_date=#{date} where package_id=#{id}")
    int ackExpress(@Param("id")String id,@Param("date") Date date);
}
