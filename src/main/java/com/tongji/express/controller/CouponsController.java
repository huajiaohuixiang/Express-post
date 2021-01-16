package com.tongji.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class CouponsController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/createNCoupons")
    public Integer createaNCoupons(@RequestParam("N")Integer N, @RequestParam("date")String date, @RequestParam("amount")float amount){
        try {
            this.jdbcTemplate.execute("call createNCoupon("+N+",'"+date+"',"+amount+")");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }



}
