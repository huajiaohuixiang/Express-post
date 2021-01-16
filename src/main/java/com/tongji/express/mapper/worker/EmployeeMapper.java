package com.tongji.express.mapper.worker;


import com.tongji.express.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee order by cast(EMPLOYEE_ID as int)")
    public LinkedList<Employee> getEmployee();
    @Update("update employee set sex =#{sex},name=#{name},address=#{address},cell_phone=#{cell_phone},department_id=#{de_id},position=#{pos},status=#{status}  where employee_id=#{id}")
    public void updateEmployee(String id,String sex,String name,String address,String cell_phone,String de_id,String pos,String status);
    @Insert("insert into employee values(#{id},#{sex},#{name},#{address},#{cell_phone},#{de_id},#{pos},#{status})" )
    public  void addEmployee(String id,String sex,String name,String address,String cell_phone,String de_id,String pos,String status);
    @Delete("delete from employee where employee_id=#{id}")
    public  void deleteEmployee(String id);
    @Update("update employee set status=#{status} where employee_id=#{id}")
    public  void dispatcherEmployee(String id,String status);
    @Select("select employee_id,name,cell_phone,status from employee where position=#{position} order by cast(EMPLOYEE_ID as int)")
    public LinkedList<Map<String,Object>> getCourier(String position);
    @Select("select * from employee where employee_id=#{id}")
    public  LinkedList<Employee> searchEmployee(String id);
}

