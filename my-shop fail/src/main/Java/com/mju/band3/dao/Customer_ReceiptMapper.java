package com.mju.band3.dao;

import com.mju.band3.entity.Customer_Receipt;
import java.util.List;

public interface Customer_ReceiptMapper {
    int deleteByPrimaryKey(Integer customerReceiptId);

    int insert(Customer_Receipt record);

    Customer_Receipt selectByPrimaryKey(Integer customerReceiptId);

    List<Customer_Receipt> selectAll();

    int updateByPrimaryKey(Customer_Receipt record);
}