package com.tongji.express.controller.worker;


import com.tongji.express.entity.PackInWare;
import com.tongji.express.entity.Package;
import com.tongji.express.entity.returnWarePack;
import com.tongji.express.mapper.pack.WareDetailsMapper;
import com.tongji.express.mapper.worker.packageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class getWareDetails {
    @Autowired
    WareDetailsMapper wareDetailsMapper;
    @Autowired
    packageMapper packagemapper;


    @GetMapping("/getmetedata")
    public Integer getmetedata(){
        Integer s= wareDetailsMapper.getpacknum();
        return  s;
    }

    @GetMapping("/getWareDetails")
    public LinkedList<returnWarePack> getWareDetals(@RequestParam("pageindex")int pageindex, @RequestParam("pagesize") int pagesize){
        System.out.println(pageindex);
        System.out.println(pagesize);
        LinkedList<PackInWare> packwithtime=wareDetailsMapper.getDetailsWithTime(pageindex, pagesize);



        LinkedList<returnWarePack> result=new LinkedList<>();

        for (PackInWare item:packwithtime
             ) {
            System.out.println(item.getPackageId());
            returnWarePack temp=new returnWarePack();
            Package packinfo=packagemapper.getpack(item.getPackageId());
            temp.setPackageId(item.getPackageId());
            temp.setWarehouseId(item.getWarehouseId());
            temp.setIn_time(item.getInDate());
            temp.setSenderName(packinfo.getSenderName());
            temp.setSenderPhone(packinfo.getSenderPhone());
            temp.setReceiverName(packinfo.getReceiverName());
            temp.setReceiverPhone(packinfo.getReceiverPhone());
            result.add(temp);
        }
    return result;
    }


    @GetMapping("/getWarePackageById")
    public returnWarePack getWareDetails(@RequestParam("id") String id){
        PackInWare item=wareDetailsMapper.getOne(id);
        Package packinfo=packagemapper.getpack(item.getPackageId());
        returnWarePack temp=new returnWarePack();
        temp.setPackageId(item.getPackageId());
        temp.setWarehouseId(item.getWarehouseId());
        temp.setIn_time(item.getInDate());
        temp.setSenderName(packinfo.getSenderName());
        temp.setSenderPhone(packinfo.getSenderPhone());
        temp.setReceiverName(packinfo.getReceiverName());
        temp.setReceiverPhone(packinfo.getReceiverPhone());
        return  temp;
    }
}
