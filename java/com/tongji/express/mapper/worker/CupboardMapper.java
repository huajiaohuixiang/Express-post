package com.tongji.express.mapper.worker;

import com.tongji.express.entity.Cupboard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

@Mapper
public interface CupboardMapper {

    @Select("select * from cupboard")
    public LinkedList<Cupboard> getCupBoard();


    @Insert("insert into cupboard values(#{id},#{name},#{capacity})")
    public void insertCup(String id, String name, long capacity);
}
