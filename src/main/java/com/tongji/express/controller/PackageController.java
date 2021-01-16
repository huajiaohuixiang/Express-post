package com.tongji.express.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tongji.express.entity.inputVo.InBoxRecord;
import com.tongji.express.entity.inputVo.InWarehouseRecord;
import com.tongji.express.entity.inputVo.MyPackage;
import com.tongji.express.mapper.pack.QueryPackageMapper;
import com.tongji.express.mapper.worker.*;
import com.tongji.express.result.State;
import com.tongji.express.result.Trace;
import com.tongji.express.service.InBoxService;
import com.tongji.express.service.PackInWarehouseService;
import com.tongji.express.service.TracePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * created by kz on
 */


@RestController
@RequestMapping("worker/package")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PackageController {

    @Autowired
    QueryPackageMapper queryPackageMapper;

    @GetMapping("/singleQuery/{packageID}")
    @ResponseBody
    public MyPackage queryPackage(@PathVariable String packageID)
    {
        return queryPackageMapper.queryPackage(packageID);
    }

    @Autowired
    QueryAllPackagesMapper queryAllPackagesMapper;

    @GetMapping("/allQuery/{size}/{page}")
    @ResponseBody
    public IPage<MyPackage> queryPackage(@PathVariable int size,@PathVariable int page)
    {
        return queryAllPackagesMapper.queryAllPackages(new Page<>(page,size));
    }

    @Autowired
    DelPackageMapper delPackageMapper;

    @PostMapping("/del")
    @ResponseBody
    public State delPackage(@RequestBody MyPackage myPackage)
    {
        try
        {
            delPackageMapper.deleteById(myPackage.getPackageID());
            return State.success;
        }catch (Exception e){
            e.printStackTrace();
            return State.fail;
        }
    }

    @Autowired
    PackInWarehouseService packInWarehouseService;

    @PostMapping("/packInWare")
    @ResponseBody
    public Date packInWarehouse(@RequestBody InWarehouseRecord inWarehouseRecord) {
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        inWarehouseRecord.setInDate(sqlDate);
        System.out.println(inWarehouseRecord.getInDate());
        try {
            packInWarehouseService.packInWarehouse(inWarehouseRecord);
            return date;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    UpdatePackageInfoMapper updatePackageInfoMapper;

    @PostMapping("/updatePackageInfo")
    @ResponseBody
    public State updatePackageInfo(@RequestBody MyPackage myPackage){
        try{
            updatePackageInfoMapper.updateById(myPackage);
            return State.success;
        }catch (Exception e){
            e.printStackTrace();
            return State.fail;
        }
    }

    @Autowired
    CountPackageMapper countPackageMapper;

    @GetMapping("/countPackage")
    @ResponseBody
    public int countPackage(){
        try{
            return countPackageMapper.countPackage();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Autowired
    InBoxService inBoxService;

    @PostMapping("/packInBox")
    @ResponseBody
    public State packageInBox(@RequestBody InBoxRecord inBoxRecord){
        try{
            if(inBoxService.packageInBox(inBoxRecord).getResult().equals("success"))
            {
                System.out.println(inBoxRecord.getCode());
               String url = "https://sms-api.upyun.com/api/messages";

                Map<String, String> jsonMap=new HashMap<>();
                //如果需要其它的请求头信息、都可以在这里追加
                HttpHeaders httpHeaders = new HttpHeaders();

                httpHeaders.add("Authorization","BNm0ib0FdEgibBO8u3LDvFytBcEeD3");

                MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

                httpHeaders.setContentType(type);

                httpHeaders.setConnection("Keep-Alive");

                jsonMap.put("template_id", "4027");
                jsonMap.put("mobile",inBoxRecord.getUserID());
                jsonMap.put("vars",inBoxRecord.getCupboardID()+"号柜"+inBoxRecord.getCode());

                HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(jsonMap, httpHeaders);

                RestTemplate restTemplate=new RestTemplate();
                ResponseEntity<String> apiResponse = restTemplate.postForEntity(url, httpEntity, String.class);
                return State.success;
            }
            return State.fail;
        }catch (Exception e){
            e.printStackTrace();
            return State.fail;
        }

    }

    @Autowired
    TracePackageService tracePackageService;
    @GetMapping("/tracePackage/{packageID}")
    @ResponseBody
    public Trace getPackageTrace(@PathVariable String packageID){
        try{
            return tracePackageService.getTrace(packageID);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Autowired
    QueryPackagesByStatusMapper queryPackagesByStatusMapper;
    @GetMapping("/queryPackagesByStatus/{status}/{size}/{page}")
    @ResponseBody
    public IPage<MyPackage> queryPackagesByStatus(@PathVariable int status,@PathVariable int size,@PathVariable int page)
    {
        return queryPackagesByStatusMapper.queryAllPackages(new Page<>(page,size),status);
    }



}
