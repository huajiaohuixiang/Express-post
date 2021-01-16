package com.tongji.express.mapper.worker;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface CountPackageMapper  {

    @Select("select count(*) from package")
    int countPackage();
}
