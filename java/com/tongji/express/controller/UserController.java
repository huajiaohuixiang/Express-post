package com.tongji.express.controller;

import com.tongji.express.entity.*;
import com.tongji.express.entity.inputVo.Account;
import com.tongji.express.entity.inputVo.MyPackage;
import com.tongji.express.entity.inputVo.TrueExOrder;
import com.tongji.express.intercepter.utils.JwtUtils;
import com.tongji.express.mapper.user.order.QuitOrderMapper;
import com.tongji.express.mapper.user.express.AckExpressMapper;
import com.tongji.express.mapper.user.express.CheckReadyExpressMapper;
import com.tongji.express.mapper.pack.GetCodeMapper;
import com.tongji.express.mapper.user.account.GetUserInfoMapper;
import com.tongji.express.mapper.user.account.UpdateUserInfoMapper;
import com.tongji.express.mapper.worker.MessageMapper;
import com.tongji.express.result.LocationAndCode;
import com.tongji.express.service.OrderExpressService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * created by kz on
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 360000)
@RequestMapping("user")
public class UserController {

    @Autowired
    AckExpressMapper ackExpressMapper;

    @PostMapping("/ackExpress")
    @ResponseBody
    public String ackExpress(@RequestBody MyPackage myPackage){
        try {
            java.util.Date date=new java.util.Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            ackExpressMapper.ackExpress(myPackage.getPackageID(),sqlDate);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
    }

    @Autowired
    UpdateUserInfoMapper updateUserInfoMapper;

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public String SetUserInfo(@RequestBody UserInfo userInfo){
        try {
            updateUserInfoMapper.updateUserInfo(userInfo);
            return "success";
        }catch (Exception e)
        {
            e.printStackTrace();
            return "failure";
        }
    }

    @Autowired
    CheckReadyExpressMapper checkReadyExpressMapper;
    @Autowired
    GetCodeMapper getCodeMapper;
    @PostMapping("/checkReadyExpress")
    @ResponseBody
    public List<MyPackage> checkReadyExpress(@RequestBody Account account)
    {
        List<MyPackage> result=checkReadyExpressMapper.checkReadyExpress(account.getUserID());
        LocationAndCode locationAndCode;
        for(MyPackage pack:result){
            locationAndCode=getCodeMapper.getCode(pack.getPackageID());
            if(locationAndCode!=null&&locationAndCode.getState().equals("warning"))
            {
                pack.setX(locationAndCode.getX());
                pack.setY(locationAndCode.getY());
                pack.setCupboardID(locationAndCode.getCupboardID());
                pack.setCode(locationAndCode.getCode());
            }
        }
        return checkReadyExpressMapper.checkReadyExpress(account.getUserID());
    }

    @Autowired
    QuitOrderMapper quitOrderMapper;

    @PostMapping("/quitOrder")
    public String quitOrder(@RequestBody TrueExOrder order){
        try{
            quitOrderMapper.quitOrder(order.getOrderID());
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
    }

    @Autowired
    OrderExpressService orderExpressService;

    @PostMapping("/addOrder")
    @ResponseBody
    public int addOrder(@RequestBody TrueExOrder order)
    {
        order.setStatus("未接单");
        int flag=orderExpressService.addOrder(order);
        return order.getOrderID();
    }

    @PostMapping("/checkMyOrder")
    @ResponseBody
    public List<TrueExOrder> queryMyOrder(@RequestBody Account account)
    {
        List<TrueExOrder> result=orderExpressService.checkReadyExpress(account.getUserID());
        for(TrueExOrder order : result ){
            if(order.getStatus().equals("已完成"))
                order.setIntStatus(0);
            else if(order.getStatus().equals("已取消"))
                order.setIntStatus(2);
            else
                order.setIntStatus(1);
        }
        return result;
    }

    @Autowired
    GetUserInfoMapper getUserInfoMapper;

    @GetMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo(HttpServletRequest httpServletRequest)
    {
        Claims claims=JwtUtils.checkJWT(httpServletRequest.getHeader("Token"));
        String userID=(String) claims.get("userID");
        System.out.println(httpServletRequest.getHeader("Token"));
        return getUserInfoMapper.getUserInfo(userID);
    }
    @Autowired
    MessageMapper messageMapper;

    @GetMapping("/getMyMessage")
    public LinkedList<Message> getMyMessage(@RequestParam("userID") String userID){

        return messageMapper.getMyMessage(userID);
    }

}
