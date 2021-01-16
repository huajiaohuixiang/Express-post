package com.tongji.express.mapper.pack;

import com.tongji.express.entity.PackInWare;
import com.tongji.express.entity.Waredetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

@Mapper
public interface WareDetailsMapper {

    @Select("select count(*) from waredetails where warehouse_id=#{id}")
    public int getSum(String id);

    @Select("select * from waredetails ")
    public LinkedList<Waredetails> getDetails();

    @Select("select count(*) from pack_in_ware where (package_id,warehouse_id) IN  (SELECT * from waredetails)")
    public Integer getpacknum();
//select e.* from (select G.*,ROWNUM rn from (pack_in_ware)G where (package_id,warehouse_id)IN  (SELECT * from waredetails)  AND ROWNUM<=5) e where e.rn>=2  ;
    @Select("select e.* from (select G.*,ROWNUM rn from (pack_in_ware)G where (package_id,warehouse_id)IN  (SELECT * from waredetails)  AND ROWNUM<=#{pageIndex}*#{pageSize}) e " +
            "where e.rn>=(#{pageIndex}-1)*#{pageSize}+1")
    public LinkedList<PackInWare> getDetailsWithTime(int pageIndex, int pageSize);


    @Select("select * from pack_in_ware where package_id=#{id} and (package_id,warehouse_id) IN  (SELECT * from waredetails)")
    public PackInWare getOne(String id);
}
