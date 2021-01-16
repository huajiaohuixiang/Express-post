package com.tongji.express.controller;


import com.tongji.express.entity.Employee;
import com.tongji.express.mapper.worker.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class EmployeeInfo {
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/getEmployee")
    public LinkedList<Employee> getEmployee(){

        return employeeMapper.getEmployee();
    }
    @PostMapping("/updateEmployee")
    public HashMap<String,Object> updateEmployee(@RequestBody Employee employee){
        HashMap<String,Object> map=new HashMap<String,Object>();
        employeeMapper.updateEmployee(employee.getEmployeeId(),employee.getSex(),employee.getName(),employee.getAddress(),employee.getCellPhone(),employee.getDepartmentId(),employee.getPosition(),employee.getStatus());
        map.put("code",200);
        map.put("message","成功！");
        return map;
    }

    @PostMapping("/addEmployee")
    public HashMap<String,Object>  addEmployee(@RequestBody Employee employee){
        HashMap<String,Object> map=new HashMap<String,Object>();

        if (employeeMapper.searchEmployee(employee.getEmployeeId()).size()!=0)
        {
            map.put("code",400);
            map.put("message","添加失败 员工工号已存在！");
        }
        else{
            employeeMapper.addEmployee(employee.getEmployeeId(),employee.getSex(),employee.getName(),employee.getAddress(),employee.getCellPhone(),employee.getDepartmentId(),employee.getPosition(),employee.getStatus());
            map.put("code",200);
            map.put("message","添加成功！");
        }
        return map;
    }


    @PostMapping("/dispatcherEmployee")
    public HashMap<String,Object> dispatcherEmployee(@RequestParam("employee_id") String employee_id){
        HashMap<String,Object> map=new HashMap<String,Object>();
        employeeMapper.dispatcherEmployee(employee_id,"已接单");
        map.put("code",200);
        map.put("message","分配成功！");
        return map;
    }

    @PostMapping("/deleteEmployee")
    public HashMap<String,Object>  deleteEmployee(@RequestParam("employee_id") String employee_id){
        HashMap<String,Object> map=new HashMap<String,Object>();
        employeeMapper.deleteEmployee(employee_id);
        map.put("code",200);
        map.put("message","删除成功！");
        return map;
    }

    @GetMapping("/getCourier")
    public LinkedList<Map<String,Object>> getCourier(){

//        LinkedList<Employee> em=employeeMapper.getCourier("快递员");

        return employeeMapper.getCourier("快递员");

    }

    @GetMapping("/searchEmployee")
    public  LinkedList<Employee>  searchEmployee(@RequestParam("employee_id") String employee_id){
        return employeeMapper.searchEmployee(employee_id);
    }

}
