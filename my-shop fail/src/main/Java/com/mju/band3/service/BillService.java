package com.mju.band3.service;

import com.mju.band3.entity.Bill;
import com.mju.band3.entity.Bill_Status;
import com.mju.band3.entity.Staff;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BillService {
    public List<Bill> SelectBillAll();

    public List<Bill> billTaker(Bill bill);

    public Bill selectByPrimaryKey(Integer id);

    List<Staff> getAllStaff();

    void updateBillEdit(Bill bill);

     void deleteBill(Integer id);

     void insertBill(Bill bill);

     Integer selectBillId(String billBegin);

    void BathInsertBill_Status(List<Bill_Status> list);

    void deleteByPrimaryKeyWithoutWay(Integer id);

    List<Bill_Status> sexyGenerator(String bill);

    List<Bill_Status> bill_destroy_search(Map<String,Object> map);

    Bill_Status selectSingleWayBillId(String wayBillID);

    void updateSingleStatusDestroy(String wayBillId);
}
