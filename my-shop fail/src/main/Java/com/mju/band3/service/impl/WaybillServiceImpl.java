package com.mju.band3.service.impl;

import com.mju.band3.dao.Bill_StatusMapper;
import com.mju.band3.dao.StaffMapper;
import com.mju.band3.dao.WaybillMapper;
import com.mju.band3.entity.Bill_Status;
import com.mju.band3.entity.Staff;
import com.mju.band3.entity.Waybill;
import com.mju.band3.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WaybillServiceImpl implements WaybillService {
    @Autowired
    WaybillMapper waybillMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    Bill_StatusMapper billStatusMapper;
    @Override
    public String latestRecord() {//获取最新一条记录
        List<Bill_Status> billStatuses=billStatusMapper.latestRecord();
        if (billStatuses.isEmpty()){
            return "无可填写货运单";
        }
        billStatuses.get(0);
        return billStatuses.get(0).getWaybillId();
    }

    @Override
    public Boolean idCanBeUse(String waybillId) {
        Boolean b;
        if(billStatusMapper.idCanBeUse(waybillId)!=null){
            b=true;
        }else{
            b=false;
        }
        return b;
    }

    @Override
    public void insert(Waybill waybill) {
        waybillMapper.insert(waybill);
        billStatusMapper.changeTheStatus(waybill.getWaybillId());
    }

    @Override
    public List<Staff> getStaff() {
        return staffMapper.selectAll();
    }

    @Override
    public Waybill getWaybill(String waybillId) {
        return waybillMapper.selectByPrimaryKey(waybillId);
    }

    @Override
    public List<Waybill> getWaybills() {
        return waybillMapper.selectAll();
    }

    @Override
    public List<Waybill> waybillSearch(Map<String, Object> map) {
        return waybillMapper.waybillSearch(map);
    }

    @Override
    public void deleteWaybill(String waybillId) {
        waybillMapper.deleteByPrimaryKey(waybillId);
        billStatusMapper.updateSingleStatusDestroy(waybillId);
    }

    @Override
    public void changeStatus(String waybillId, Integer status) {
        waybillMapper.changeStatus(waybillId,status);
    }
}
