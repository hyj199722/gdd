package com.mju.band3.service;

import com.mju.band3.entity.Staff;
import com.mju.band3.entity.Waybill;

import java.util.List;
import java.util.Map;

public interface WaybillService {
    String latestRecord();
    Boolean idCanBeUse(String waybillId);
    void insert(Waybill waybill);
    List<Staff> getStaff();
    Waybill getWaybill(String waybillId);
    List<Waybill> getWaybills();
    List<Waybill> waybillSearch(Map<String,Object> map);
    void deleteWaybill(String waybillId);
    void changeStatus(String waybillId,Integer status);
    List<Waybill> selectByLocation(Map<String,String> map);
    void update(Waybill waybill);
}
