package com.tongji.express.mapper.worker;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.tongji.express.entity.WareDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface DelWareDetailMapper  {

    @Delete("delete from waredetails where package_ID=#{id}")
    int delete(@Param("id") String id);

}
