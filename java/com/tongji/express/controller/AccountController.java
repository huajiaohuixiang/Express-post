package com.tongji.express.controller;

import com.tongji.express.entity.inputVo.Account;
import com.tongji.express.entity.UserInfo;
import com.tongji.express.mapper.user.account.EnrollUserMapper;
import com.tongji.express.mapper.user.account.GetUserInfoMapper;
import com.tongji.express.service.RegisterUserService;
import com.tongji.express.intercepter.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * created by kz on
 */

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("account")
public class AccountController {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody Account account){

        System.out.println(account.getUserID()+" "+account.getSex()+account.getUserID()+account.getName());
        return registerUserService.insertNewUser(account);
    }

    @Autowired
    EnrollUserMapper enrollUserMapper;

    @Autowired
    GetUserInfoMapper getUserInfoMapper;

    @PostMapping("/enroll")
    @ResponseBody
    public String enroll(@RequestBody Account account ){
        String truePwd=enrollUserMapper.getPasswordByID(account.getUserID());
        if(truePwd!=null&&truePwd.equals(account.getPassword())) {

            UserInfo userInfo = getUserInfoMapper.getUserInfo(account.getUserID());

            account.setName(userInfo.getName());
            System.out.println(account.getName());
            account.setSex(userInfo.getSex());
            System.out.println(account.getSex());
            String old=redisTemplate.opsForValue().get(account.getUserID());
            if(old!=null)
                return old;
            else
                return JwtUtils.genJsonWebToken(account);
        }
        else
        {
            System.out.println("------------fail----------");
            return null;
        }
    }

}
