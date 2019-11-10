package com.mju.band3.service.impl;

import com.mju.band3.dao.Customer_ReceiptMapper;
import com.mju.band3.dao.Driver_ReceiptMapper;
import com.mju.band3.entity.Bill_Status;
import com.mju.band3.entity.Customer_Receipt;
import com.mju.band3.entity.Driver_Receipt;
import com.mju.band3.service.Customer_ReceiptService;
import com.mju.band3.service.Driver_ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Customer_ReceiptServiceImpl implements Customer_ReceiptService {

@Autowired
    Customer_ReceiptMapper customer_receiptMapper;

    @Override
    public List<Customer_Receipt> selectAll() {
        return customer_receiptMapper.selectAll();
    }


    @Override
    public List<Customer_Receipt> CustomerReceiptSearch(Map<String, Object> map) {

        return customer_receiptMapper.CustomerReceiptSearch(map);

    }

    @Override
    public Customer_Receipt selectByPrimaryKey(Integer customerReceiptId) {
        return customer_receiptMapper.selectByPrimaryKey(customerReceiptId);
    }

    @Override
    public int deleteByPrimaryKey(Integer customerReceiptId) {
        return customer_receiptMapper.deleteByPrimaryKey(customerReceiptId);
    }

    @Override
    public void insert(Customer_Receipt customer_receipt) {
customer_receiptMapper.insert(customer_receipt);
    }

    @Override
    public int updateByPrimaryKey(Customer_Receipt record) {
        return customer_receiptMapper.updateByPrimaryKey(record);
    }

    @Override
    public String selectwaybillId(String waybillId) {
        return customer_receiptMapper.selectwaybillId(waybillId);
    }

    @Override
    public void DeleteCustomerReceipt(Integer id) {
         customer_receiptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String selectwaybillIdNull(String waybillId) {
        return customer_receiptMapper.selectwaybillIdNull(waybillId);
    }

    @Override
    public void updateCustomerReceiptEdit(Customer_Receipt customer_receipt) {
    customer_receiptMapper.updateCustomerReceiptEdit(customer_receipt);
    }
}
