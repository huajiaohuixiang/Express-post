package com.tongji.express.controller.worker;


import com.tongji.express.entity.Box;
import com.tongji.express.mapper.worker.BoxMapper;
import com.tongji.express.mapper.worker.CupboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class InsertCupBox {
    @Autowired
    CupboardMapper cupboardMapper;

    @Autowired
    BoxMapper boxMapper;

    @GetMapping("/insertCup")
    public String insertCup(@RequestParam("id")String id,@RequestParam("name")String name ,@RequestParam("capacity")long capacity){
        cupboardMapper.insertCup(id,name,capacity);
        return "success";
    }

    @PostMapping("/insertBox")
    public Box insertBox(@RequestBody Box box){
        boxMapper.insertBox(box.getBoxId(),box.getCupboardId(),box.getType(),box.getColy(),box.getRowx(),box.getState(),box.getPackageId());
        return box;
    }
}
