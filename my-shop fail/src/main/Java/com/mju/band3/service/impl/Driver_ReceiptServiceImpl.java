package com.mju.band3.service.impl;

import com.mju.band3.dao.Driver_ReceiptMapper;
import com.mju.band3.entity.Driver_Receipt;
import com.mju.band3.service.Driver_ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Driver_ReceiptServiceImpl implements Driver_ReceiptService {
    @Autowired
    Driver_ReceiptMapper driver_receiptMapper;
    @Override
    public List<Driver_Receipt> SelectDriver_ReceiptServiceAll() {
        return driver_receiptMapper.selectAll();
    }

    @Override
    public List<Driver_Receipt> Driver_Receipt_search(Map<String, Object> map) {

       return  driver_receiptMapper.DriverReceiptSearch(map);

    }


    @Override
    public Driver_Receipt selectByPrimaryKey(Integer id) {
        return driver_receiptMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDriver_Receipt(Driver_Receipt driver_receipt) {
         driver_receiptMapper.updateByPrimaryKey(driver_receipt);
    }

    @Override
    public void deleteDriver_Receipt(Integer id) {
driver_receiptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String selectContractIdNull(String ContractId) {
        return driver_receiptMapper.selectContractIdNull(ContractId);
    }

    @Override
    public void update_driver_receipt_edit(Driver_Receipt driver_receipt) {
        driver_receiptMapper.update_driver_receipt_edit(driver_receipt);
    }

    @Override
    public void insertDriver_Receipt(Driver_Receipt driver_receipt) {
driver_receiptMapper.insert(driver_receipt);
    }

    @Override
    public String selectContractId(String ContractId) {
        return driver_receiptMapper.selectContractId(ContractId);
    }
}
