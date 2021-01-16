package com.tongji.express.service;

import com.tongji.express.entity.inputVo.Account;
import com.tongji.express.mapper.user.account.RegisterUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by kz on
 */


@Service
public class RegisterUserService {

    @Autowired
    RegisterUserMapper registerUserMapper;

    public String insertNewUser(Account account) {
        try
        {
            registerUserMapper.insertNewUser(account);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
    }

}
