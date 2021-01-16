package com.tongji.express.controller.worker;


import com.tongji.express.entity.Box;
import com.tongji.express.mapper.worker.BoxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class getCupDetails {
    @Autowired
    BoxMapper boxMapper;

    @GetMapping("/getCupDetails")
    public LinkedList<Box> getCupDetails(){

        return boxMapper.getBox();
    }

}
