package com.mju.band3.dao;

import com.mju.band3.entity.Driver_Receipt;
import java.util.List;

public interface Driver_ReceiptMapper {
    int deleteByPrimaryKey(Integer driverReceiptId);

    int insert(Driver_Receipt record);

    Driver_Receipt selectByPrimaryKey(Integer driverReceiptId);

    List<Driver_Receipt> selectAll();

    int updateByPrimaryKey(Driver_Receipt record);
}