package com.tongji.express.mapper.worker;


import com.tongji.express.entity.Package;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface packageMapper {

    @Select("Select * from package where package_id=#{id}")
    Package getpack(String id);

}
