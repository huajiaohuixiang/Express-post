package com.tongji.express.mapper.pack;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tongji.express.entity.inputVo.MyPackage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * created by kz on
 */

@Mapper
@Repository
public interface AddPackageMapper extends BaseMapper<MyPackage> {

}
