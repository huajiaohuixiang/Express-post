package com.tongji.express.controller;

import com.tongji.express.entity.inputVo.CodeAndCupboard;
import com.tongji.express.intercepter.utils.JsonData;
import com.tongji.express.result.State;
import com.tongji.express.service.GetOutExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * created by kz on
 */

@RestController
@RequestMapping("getOutPackage")
@CrossOrigin(origins = "*",maxAge = 3600)
public class GetOutExpressController {
    @Autowired
    GetOutExpressService getOutExpressService;
    @PostMapping
    @ResponseBody
    public JsonData getOutExpress(@RequestBody CodeAndCupboard codeAndCupboard){
        State state= getOutExpressService.getOutExpress(codeAndCupboard.getCupboardID(),codeAndCupboard.getCode());
        if (state.getResult().equals("success"))
            return JsonData.buildSuccess(1,"取件成功");
        else
            return JsonData.buildError("取件失败",-1);
    }
}
