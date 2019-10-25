package com.mju.band3.service;
import com.mju.band3.entity.Customer_Receipt;


import java.util.List;
import java.util.Map;


public interface Customer_ReceiptService {
    List<Customer_Receipt> selectAll();
    Customer_Receipt selectByPrimaryKey(Integer customerReceiptId);
    int deleteByPrimaryKey(Integer customerReceiptId);
    void insert(Customer_Receipt customer_receipt);
    int updateByPrimaryKey(Customer_Receipt record);
    void updateCustomerReceiptEdit(Customer_Receipt customer_receipt);
    String selectwaybillId(String waybillId);
    void DeleteCustomerReceipt(Integer id);
    String selectwaybillIdNull(String waybillId);
    List<Customer_Receipt> CustomerReceiptSearch(Map<String,Object> map);
}
