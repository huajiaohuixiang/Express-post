package com.tongji.express.mapper.pack;

import com.tongji.express.entity.inputVo.MyPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface QueryPackageMapper {

    @Select("select * from package where package_id=#{id}")
    MyPackage queryPackage(@Param("id") String id);
}
