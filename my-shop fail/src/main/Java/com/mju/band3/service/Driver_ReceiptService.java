package com.mju.band3.service;
import com.mju.band3.entity.Customer_Receipt;
import com.mju.band3.entity.Driver_Receipt;

import java.util.List;
import java.util.Map;


public interface Driver_ReceiptService {

    public List<Driver_Receipt> SelectDriver_ReceiptServiceAll();


    List<Driver_Receipt> Driver_Receipt_search(Map<String,Object> map);
    public Driver_Receipt selectByPrimaryKey(Integer id);

    void updateDriver_Receipt(Driver_Receipt driver_receipt);

    void deleteDriver_Receipt(Integer id);
    String selectContractIdNull(String ContractId);
    void update_driver_receipt_edit(Driver_Receipt driver_receipt);

    void insertDriver_Receipt(Driver_Receipt driver_receipt);

    String selectContractId(String ContractId);


}
