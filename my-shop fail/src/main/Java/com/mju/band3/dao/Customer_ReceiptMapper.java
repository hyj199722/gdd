package com.mju.band3.dao;


import com.mju.band3.entity.Customer_Receipt;

import java.util.List;
import java.util.Map;
//顾客回执的增删改查
public interface Customer_ReceiptMapper {
    int deleteByPrimaryKey(Integer customerReceiptId);

    int insert(Customer_Receipt customer_receipt);

    Customer_Receipt selectByPrimaryKey(Integer customerReceiptId);

    List<Customer_Receipt> selectAll();

    String selectwaybillId(String waybillId);

    String selectwaybillIdNull(String waybillId);

    void updateCustomerReceiptEdit(Customer_Receipt customer_receipt);

    List<Customer_Receipt> CustomerReceiptSearch(Map<String,Object> map);

    int updateByPrimaryKey(Customer_Receipt record);
}