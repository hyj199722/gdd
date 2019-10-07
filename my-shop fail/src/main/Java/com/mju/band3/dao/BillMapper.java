package com.mju.band3.dao;

import com.mju.band3.entity.Bill;
import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Integer billId);

    int insert(Bill record);

    Bill selectByPrimaryKey(Integer billId);

    List<Bill> selectAll();

    int updateByPrimaryKey(Bill record);

    List<Bill> bill_search(Bill bill);

    void updateBillEdit(Bill bill);

    Integer selectBillId(String billBegin);




}