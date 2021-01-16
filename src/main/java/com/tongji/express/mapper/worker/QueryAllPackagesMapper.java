package com.tongji.express.mapper.worker;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tongji.express.entity.inputVo.MyPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface QueryAllPackagesMapper {

    @Select("select * from package")
    IPage<MyPackage> queryAllPackages(Page<MyPackage> page);
}
