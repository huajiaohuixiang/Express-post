package com.tongji.express.mapper.pack;

import com.tongji.express.result.LocationAndCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */
@Mapper
@Repository
public interface GetCodeMapper {

    @Select("select * from box where package_ID=#{id}")
    LocationAndCode getCode(@Param("id")String id);
}
