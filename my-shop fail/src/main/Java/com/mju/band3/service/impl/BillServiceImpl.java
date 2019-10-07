package com.mju.band3.service.impl;

import com.mju.band3.dao.BillMapper;
import com.mju.band3.dao.Bill_StatusMapper;
import com.mju.band3.dao.StaffMapper;
import com.mju.band3.entity.Bill;
import com.mju.band3.entity.Bill_Status;
import com.mju.band3.entity.Staff;
import com.mju.band3.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillMapper billMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    Bill_StatusMapper billStatusMapper;
    @Override
    public List<Bill> SelectBillAll() {
        return billMapper.selectAll();
    }

    @Override
    public List<Bill> billTaker(Bill bill) {
        return billMapper.bill_search(bill);
    }

    @Override
    public Bill selectByPrimaryKey(Integer id) {
        return billMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffMapper.selectAll();
    }

    @Override
    public void updateBillEdit(Bill bill) {
        billMapper.updateBillEdit(bill);
    }

    @Override
    public void deleteBill(Integer id) {
        billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertBill(Bill bill) {
        billMapper.insert(bill);
    }

    @Override
    public Integer selectBillId(String billBegin) {
        return billMapper.selectBillId(billBegin);
    }

    @Override
    public void BathInsertBill_Status(List<Bill_Status> list) {
        billStatusMapper.BathInsertBill_Status(list);
    }

    @Override
    public void deleteByPrimaryKeyWithoutWay(Integer id) {
        billStatusMapper.deleteByPrimaryKeyWithoutWay(id);
    }

    @Override
    public List<Bill_Status> sexyGenerator(String  bill) {
        return billStatusMapper.sexyGenerator(bill);
    }

    @Override
    public List<Bill_Status> bill_destroy_search(Map<String, Object> map) {

        return billStatusMapper.bill_destroy_search(map);

    }

    @Override
    public Bill_Status selectSingleWayBillId(String wayBillID) {
        return billStatusMapper.selectSingleWayBillId(wayBillID);
    }

    @Override
    public void updateSingleStatusDestroy(String wayBillId) {
        billStatusMapper.updateSingleStatusDestroy(wayBillId);
    }


}
