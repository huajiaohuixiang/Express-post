package com.tongji.express.service;

import com.tongji.express.entity.inputVo.InRecord;
import com.tongji.express.entity.inputVo.InWarehouseRecord;
import com.tongji.express.entity.WareDetail;
import com.tongji.express.mapper.pack.AddPackageMapper;
import com.tongji.express.mapper.pack.InDetailMapper;
import com.tongji.express.mapper.pack.InWarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by kz on
 */
@Service
public class PackInWarehouseService {

    @Autowired
    AddPackageMapper addPackageMapper;

    @Autowired
    InDetailMapper inDetailMapper;

    @Autowired
    InWarehouseMapper inWarehouseMapper;

    @Transactional
    public void packInWarehouse(InWarehouseRecord inWarehouseRecord) {

        inWarehouseRecord.getMyPackage().setStatus(1);
        addPackageMapper.insert(inWarehouseRecord.getMyPackage());
        inWarehouseMapper.insert(new InRecord(inWarehouseRecord.getMyPackage().getPackageID(),inWarehouseRecord.getWarehouseID(),
                inWarehouseRecord.getEmployeeID(),inWarehouseRecord.getInDate()));
        inDetailMapper.insert(new WareDetail(inWarehouseRecord.getMyPackage().getPackageID(),inWarehouseRecord.getWarehouseID()));


    }
}