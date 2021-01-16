package com.tongji.express.mapper.worker;

import com.tongji.express.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Mapper
@Repository
public interface WarehouseMapper {
    @Select("select * from warehouse")
    public LinkedList<Warehouse> getWareInfo();

}
