package com.tongji.express.controller;


import com.tongji.express.entity.inputVo.Account;
import com.tongji.express.entity.Administrator;
import com.tongji.express.entity.ExOrder;
import com.tongji.express.intercepter.utils.JwtUtils;
import com.tongji.express.mapper.worker.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class AdminInfo {

    @Autowired
    AdministratorMapper administratorMapper;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @GetMapping("/getAdmin")
    public LinkedList<Administrator> getAdministrator(){
        return administratorMapper.getAdministrator();
    }
    @PostMapping("/registry")
   public HashMap<String,Object> addAdministrator(@RequestBody Administrator administrator){
        HashMap<String,Object> map=new HashMap<String,Object>();
        if (administratorMapper.findByEmId(administrator.getEmployeeId())==null){
            map.put("code",400);
            map.put("message","注册失败 员工工号不存在！");
            return map;
        }
        if (administratorMapper.findByName(administrator.getAdminName())!= null ){
            map.put("code",400);
            map.put("message","注册失败 用户名已存在！");
            return map;
        }

        administratorMapper.addAdministrator(administrator.getAdminName(),administrator.getPassword(),administrator.getEmployeeId());
        map.put("code",200);
        map.put("administrator",administrator.getAdminName());
        return  map;
    }

    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestParam("admin_name") String name,@RequestParam("password") String password){
        HashMap<String,Object> map=new HashMap<String,Object>();
        Account account;
        Administrator administrator=administratorMapper.login(name,password);
        if (administrator==null){
            map.put("code",400);
            map.put("message","登陆失败！");
            map.put("Token",null);
            return map;
        } else {
            account=new Account(administrator.getEmployeeId(),administrator.getAdminName());
            account.setSex("男");
            map.put("code",200);
            map.put("message","登陆成功！");
            String e_id=administratorMapper.getEmid(name);
            String pos=administratorMapper.getPos(e_id);
            map.put("employee_id",e_id);
            map.put("position",pos);
            //不管之前有没有，生成新token加入redis或者替换老token
            String newToken= JwtUtils.genJsonWebToken(account);
            redisTemplate.opsForValue().set(account.getUserID(),newToken);
            map.put("Token", newToken);
            return  map;
        }
    }
    @PostMapping("/getMyOrder")
    public  LinkedList<ExOrder> getMyOrder(@RequestParam("employee_id")String id){
        return administratorMapper.getOrder(id);
    }
}
