package com.mju.band3.dao;


import com.mju.band3.entity.Bill;
import com.mju.band3.entity.Bill_Status;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface Bill_StatusMapper {
    int deleteByPrimaryKey(@Param("billId") Integer billId, @Param("waybillId") String waybillId);

    int insert(Bill_Status record);

    Bill_Status selectByPrimaryKey(@Param("billId") Integer billId, @Param("waybillId") String waybillId);

    List<Bill_Status> selectAll();

    int updateByPrimaryKey(Bill_Status record);

    void BathInsertBill_Status(List<Bill_Status> list);

    void deleteByPrimaryKeyWithoutWay(Integer integer);

    List<Bill_Status> sexyGenerator(String bill);

    List<Bill_Status> bill_destroy_search(Map<String,Object> map);

    Bill_Status selectSingleWayBillId(String wayBillID);

    void updateSingleStatusDestroy(String wayBillId);
}